package com.stratagile.qlink.ui.activity.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.stratagile.qlink.R;
import com.stratagile.qlink.application.AppConfig;
import com.stratagile.qlink.base.BaseFragment;
import com.stratagile.qlink.constant.ConstantValue;
import com.stratagile.qlink.db.Wallet;
import com.stratagile.qlink.entity.AllWallet;
import com.stratagile.qlink.entity.TokenInfo;
import com.stratagile.qlink.entity.Tpcs;
import com.stratagile.qlink.entity.eventbus.ChangeCurrency;
import com.stratagile.qlink.ui.activity.main.component.DaggerMarketComponent;
import com.stratagile.qlink.ui.activity.main.contract.MarketContract;
import com.stratagile.qlink.ui.activity.main.module.MarketModule;
import com.stratagile.qlink.ui.activity.main.presenter.MarketPresenter;
import com.stratagile.qlink.ui.activity.wallet.EthTransactionRecordActivity;
import com.stratagile.qlink.ui.adapter.wallet.TpcsAdapter;
import com.stratagile.qlink.utils.FileUtil;
import com.stratagile.qlink.utils.LocalWalletUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author hzp
 * @Package com.stratagile.qlink.ui.activity.main
 * @Description: $description
 * @date 2018/10/25 15:54:02
 */

public class MarketFragment extends BaseFragment implements MarketContract.View {
    @Override
    protected void initDataFromNet() {

    }
    @Inject
    MarketPresenter mPresenter;
    @BindView(R.id.tvPrice)
    TextView tvPrice;
    @BindView(R.id.ivPrice)
    ImageView ivPrice;
    @BindView(R.id.llPrice)
    LinearLayout llPrice;
    @BindView(R.id.tvChange)
    TextView tvChange;
    @BindView(R.id.ivChange)
    ImageView ivChange;
    @BindView(R.id.llChange)
    LinearLayout llChange;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    private MainViewModel viewModel;

    TpcsAdapter tpcsAdapter;
    Tpcs tpcs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_market, null);
        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        Bundle mBundle = getArguments();
        refreshLayout.setColorSchemeColors(getResources().getColor(R.color.mainColor));
        viewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        viewModel.timeStampLiveData.observe(this, new Observer<Long>() {
            @Override
            public void onChanged(@Nullable Long tokenInfos) {
                fetechData(LocalWalletUtil.getLocalTokens());
            }
        });

        viewModel.walletTypeMutableLiveData.observe(this, new Observer<AllWallet.WalletType>() {
            @Override
            public void onChanged(@Nullable AllWallet.WalletType walletType) {
                tpcsAdapter.setWalletTpye(walletType);
            }
        });
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetechData(LocalWalletUtil.getLocalTokens());
            }
        });
        tpcsAdapter = new TpcsAdapter(new ArrayList<>());
        tpcsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                for (int i = 0; i < viewModel.tokenInfoMutableLiveData.getValue().size(); i++) {
//                    if (tpcs.getData().get(position).getSymbol().toLowerCase().equals(viewModel.tokenInfoMutableLiveData.getValue().get(i).getTokenSymol().toLowerCase())) {
//                        Intent intent = new Intent(getActivity(), EthTransactionRecordActivity.class);
//                        intent.putExtra("tokenInfo", viewModel.tokenInfoMutableLiveData.getValue().get(i));
//                        intent.putParcelableArrayListExtra("tokens", viewModel.tokenInfoMutableLiveData.getValue());
//                        startActivity(intent);
//                    }
//                }
            }
        });
        recyclerView.setAdapter(tpcsAdapter);
        File file = new File(Environment.getExternalStorageDirectory() + "/Qwallet/tokens");
        ArrayList<String> list = new ArrayList<>();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            list.add("ETH");
            list.add("NEO");
            list.add("EOS");
            LocalWalletUtil.updateLocalTokens(list);
        } else {
            list.addAll(LocalWalletUtil.getLocalTokens());
        }
        fetechData(list);
        return view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void changeCurrency(ChangeCurrency changeWallet) {
        fetechData(LocalWalletUtil.getLocalTokens());
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    private void fetechData(ArrayList<String> list) {
        refreshLayout.setRefreshing(false);
        if (list == null) {
            return;
        }
        Map<String, Object> map = new HashMap<>();
        String[] strings = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strings[i] = list.get(i);
        }
        map.put("symbols", strings);
        map.put("coin", ConstantValue.currencyBean.getName());
        mPresenter.getTpcs(map);
    }


    @Override
    protected void setupFragmentComponent() {
        DaggerMarketComponent
                .builder()
                .appComponent(((AppConfig) getActivity().getApplication()).getApplicationComponent())
                .marketModule(new MarketModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void setPresenter(MarketContract.MarketContractPresenter presenter) {
        mPresenter = (MarketPresenter) presenter;
    }

    @Override
    protected void initDataFromLocal() {

    }

    @Override
    public void showProgressDialog() {
        progressDialog.show();
    }

    @Override
    public void closeProgressDialog() {
        progressDialog.hide();
    }

    @Override
    public void setData(Tpcs data) {
        tpcsAdapter.setNewData(data.getData());
        tpcs = data;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.llPrice, R.id.llChange})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llPrice:
                revisePrice();
                break;
            case R.id.llChange:
                reviseChange();
                break;
            default:
                break;
        }
    }

    /**
     * 价格是否按降序
     */
    boolean orderPrice = false;

    private void revisePrice() {
        ivPrice.setVisibility(View.VISIBLE);
        if (orderPrice) {
            orderPrice = false;
            ivPrice.setImageDrawable(getResources().getDrawable(R.mipmap.sort_n));
            Collections.sort(tpcs.getData(), new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    if (o1 instanceof Tpcs.DataBean && o2 instanceof Tpcs.DataBean) {
                        Tpcs.DataBean e1 = (Tpcs.DataBean) o1;
                        Tpcs.DataBean e2 = (Tpcs.DataBean) o2;
                        if (Double.parseDouble(e1.getLastPrice()) > Double.parseDouble(e2.getLastPrice())) {
                            return 1;
                        } else if (Double.parseDouble(e1.getLastPrice()) == Double.parseDouble(e2.getLastPrice())) {
                            return 0;
                        } else {
                            return -1;
                        }
//                        return Double.parseDouble(e1.getLastPrice()) > Double.parseDouble(e2.getLastPrice()) ? 1:0;
                    }
                    throw new ClassCastException("");
                }
            });
            System.out.println("使用Comparator比较器按价格升序排序后:");
            tpcsAdapter.setNewData(tpcs.getData());
        } else {
            orderPrice = true;
            ivPrice.setImageDrawable(getResources().getDrawable(R.mipmap.sort_h));
            Collections.sort(tpcs.getData(), new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    if (o1 instanceof Tpcs.DataBean && o2 instanceof Tpcs.DataBean) {
                        Tpcs.DataBean e1 = (Tpcs.DataBean) o1;
                        Tpcs.DataBean e2 = (Tpcs.DataBean) o2;
                        if (Double.parseDouble(e2.getLastPrice()) > Double.parseDouble(e1.getLastPrice())) {
                            return 1;
                        } else if (Double.parseDouble(e2.getLastPrice()) == Double.parseDouble(e1.getLastPrice())) {
                            return 0;
                        } else {
                            return -1;
                        }
//                        return Double.parseDouble(e2.getLastPrice()) > Double.parseDouble(e1.getLastPrice()) ? 1:0;
                    }
                    throw new ClassCastException("");
                }
            });
            System.out.println("使用Comparator比较器按价格降序排序后:");
            tpcsAdapter.setNewData(tpcs.getData());
        }
    }

    boolean orderRise = false;

    /**
     * 按涨跌幅排序
     */
    private void reviseChange() {
        ivChange.setVisibility(View.VISIBLE);
        if (orderRise) {
            orderRise = false;
            ivChange.setImageDrawable(getResources().getDrawable(R.mipmap.sort_n));
            Collections.sort(tpcs.getData(), new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    if (o1 instanceof Tpcs.DataBean && o2 instanceof Tpcs.DataBean) {
                        Tpcs.DataBean e1 = (Tpcs.DataBean) o1;
                        Tpcs.DataBean e2 = (Tpcs.DataBean) o2;
                        if (Double.parseDouble(e1.getPriceChangePercent()) > Double.parseDouble(e2.getPriceChangePercent())) {
                            return 1;
                        } else if (Double.parseDouble(e1.getPriceChangePercent()) == Double.parseDouble(e2.getPriceChangePercent())) {
                            return 0;
                        } else {
                            return -1;
                        }
//                        return e1.getPriceChangePercent().compareTo(e2.getPriceChangePercent());
                    }
                    throw new ClassCastException("");
                }
            });
            System.out.println("使用Comparator比较器按涨幅升序排序后:");
            tpcsAdapter.setNewData(tpcs.getData());
        } else {
            orderRise = true;
            ivChange.setImageDrawable(getResources().getDrawable(R.mipmap.sort_h));
            Collections.sort(tpcs.getData(), new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    if (o1 instanceof Tpcs.DataBean && o2 instanceof Tpcs.DataBean) {
                        Tpcs.DataBean e1 = (Tpcs.DataBean) o1;
                        Tpcs.DataBean e2 = (Tpcs.DataBean) o2;
                        if (Double.parseDouble(e2.getPriceChangePercent()) > Double.parseDouble(e1.getPriceChangePercent())) {
                            return 1;
                        } else if (Double.parseDouble(e2.getPriceChangePercent()) == Double.parseDouble(e1.getPriceChangePercent())) {
                            return 0;
                        } else {
                            return -1;
                        }
//                        return e2.getPriceChangePercent().compareTo(e1.getPriceChangePercent());
                    }
                    throw new ClassCastException("");
                }
            });
            System.out.println("使用Comparator比较器按涨幅降序排序后:");
            tpcsAdapter.setNewData(tpcs.getData());
        }
    }
}