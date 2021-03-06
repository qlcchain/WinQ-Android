package com.stratagile.qlink.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.stratagile.qlink.db.BnbWallet;
import com.stratagile.qlink.db.BtcWallet;
import com.stratagile.qlink.db.BuySellBuyTodo;
import com.stratagile.qlink.db.BuySellSellTodo;
import com.stratagile.qlink.db.DefiSearchHistory;
import com.stratagile.qlink.db.DWCSession;
import com.stratagile.qlink.db.EntrustTodo;
import com.stratagile.qlink.db.EosAccount;
import com.stratagile.qlink.db.EthWallet;
import com.stratagile.qlink.db.QLCAccount;
import com.stratagile.qlink.db.RecordSave;
import com.stratagile.qlink.db.SwapRecord;
import com.stratagile.qlink.db.TopupTodoList;
import com.stratagile.qlink.db.TransactionRecord;
import com.stratagile.qlink.db.UserAccount;
import com.stratagile.qlink.db.VpnEntity;
import com.stratagile.qlink.db.VpnServerRecord;
import com.stratagile.qlink.db.Wallet;

import com.stratagile.qlink.db.BnbWalletDao;
import com.stratagile.qlink.db.BtcWalletDao;
import com.stratagile.qlink.db.BuySellBuyTodoDao;
import com.stratagile.qlink.db.BuySellSellTodoDao;
import com.stratagile.qlink.db.DefiSearchHistoryDao;
import com.stratagile.qlink.db.DWCSessionDao;
import com.stratagile.qlink.db.EntrustTodoDao;
import com.stratagile.qlink.db.EosAccountDao;
import com.stratagile.qlink.db.EthWalletDao;
import com.stratagile.qlink.db.QLCAccountDao;
import com.stratagile.qlink.db.RecordSaveDao;
import com.stratagile.qlink.db.SwapRecordDao;
import com.stratagile.qlink.db.TopupTodoListDao;
import com.stratagile.qlink.db.TransactionRecordDao;
import com.stratagile.qlink.db.UserAccountDao;
import com.stratagile.qlink.db.VpnEntityDao;
import com.stratagile.qlink.db.VpnServerRecordDao;
import com.stratagile.qlink.db.WalletDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig bnbWalletDaoConfig;
    private final DaoConfig btcWalletDaoConfig;
    private final DaoConfig buySellBuyTodoDaoConfig;
    private final DaoConfig buySellSellTodoDaoConfig;
    private final DaoConfig defiSearchHistoryDaoConfig;
    private final DaoConfig dWCSessionDaoConfig;
    private final DaoConfig entrustTodoDaoConfig;
    private final DaoConfig eosAccountDaoConfig;
    private final DaoConfig ethWalletDaoConfig;
    private final DaoConfig qLCAccountDaoConfig;
    private final DaoConfig recordSaveDaoConfig;
    private final DaoConfig swapRecordDaoConfig;
    private final DaoConfig topupTodoListDaoConfig;
    private final DaoConfig transactionRecordDaoConfig;
    private final DaoConfig userAccountDaoConfig;
    private final DaoConfig vpnEntityDaoConfig;
    private final DaoConfig vpnServerRecordDaoConfig;
    private final DaoConfig walletDaoConfig;

    private final BnbWalletDao bnbWalletDao;
    private final BtcWalletDao btcWalletDao;
    private final BuySellBuyTodoDao buySellBuyTodoDao;
    private final BuySellSellTodoDao buySellSellTodoDao;
    private final DefiSearchHistoryDao defiSearchHistoryDao;
    private final DWCSessionDao dWCSessionDao;
    private final EntrustTodoDao entrustTodoDao;
    private final EosAccountDao eosAccountDao;
    private final EthWalletDao ethWalletDao;
    private final QLCAccountDao qLCAccountDao;
    private final RecordSaveDao recordSaveDao;
    private final SwapRecordDao swapRecordDao;
    private final TopupTodoListDao topupTodoListDao;
    private final TransactionRecordDao transactionRecordDao;
    private final UserAccountDao userAccountDao;
    private final VpnEntityDao vpnEntityDao;
    private final VpnServerRecordDao vpnServerRecordDao;
    private final WalletDao walletDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        bnbWalletDaoConfig = daoConfigMap.get(BnbWalletDao.class).clone();
        bnbWalletDaoConfig.initIdentityScope(type);

        btcWalletDaoConfig = daoConfigMap.get(BtcWalletDao.class).clone();
        btcWalletDaoConfig.initIdentityScope(type);

        buySellBuyTodoDaoConfig = daoConfigMap.get(BuySellBuyTodoDao.class).clone();
        buySellBuyTodoDaoConfig.initIdentityScope(type);

        buySellSellTodoDaoConfig = daoConfigMap.get(BuySellSellTodoDao.class).clone();
        buySellSellTodoDaoConfig.initIdentityScope(type);

        defiSearchHistoryDaoConfig = daoConfigMap.get(DefiSearchHistoryDao.class).clone();
        defiSearchHistoryDaoConfig.initIdentityScope(type);

        dWCSessionDaoConfig = daoConfigMap.get(DWCSessionDao.class).clone();
        dWCSessionDaoConfig.initIdentityScope(type);

        entrustTodoDaoConfig = daoConfigMap.get(EntrustTodoDao.class).clone();
        entrustTodoDaoConfig.initIdentityScope(type);

        eosAccountDaoConfig = daoConfigMap.get(EosAccountDao.class).clone();
        eosAccountDaoConfig.initIdentityScope(type);

        ethWalletDaoConfig = daoConfigMap.get(EthWalletDao.class).clone();
        ethWalletDaoConfig.initIdentityScope(type);

        qLCAccountDaoConfig = daoConfigMap.get(QLCAccountDao.class).clone();
        qLCAccountDaoConfig.initIdentityScope(type);

        recordSaveDaoConfig = daoConfigMap.get(RecordSaveDao.class).clone();
        recordSaveDaoConfig.initIdentityScope(type);

        swapRecordDaoConfig = daoConfigMap.get(SwapRecordDao.class).clone();
        swapRecordDaoConfig.initIdentityScope(type);

        topupTodoListDaoConfig = daoConfigMap.get(TopupTodoListDao.class).clone();
        topupTodoListDaoConfig.initIdentityScope(type);

        transactionRecordDaoConfig = daoConfigMap.get(TransactionRecordDao.class).clone();
        transactionRecordDaoConfig.initIdentityScope(type);

        userAccountDaoConfig = daoConfigMap.get(UserAccountDao.class).clone();
        userAccountDaoConfig.initIdentityScope(type);

        vpnEntityDaoConfig = daoConfigMap.get(VpnEntityDao.class).clone();
        vpnEntityDaoConfig.initIdentityScope(type);

        vpnServerRecordDaoConfig = daoConfigMap.get(VpnServerRecordDao.class).clone();
        vpnServerRecordDaoConfig.initIdentityScope(type);

        walletDaoConfig = daoConfigMap.get(WalletDao.class).clone();
        walletDaoConfig.initIdentityScope(type);

        bnbWalletDao = new BnbWalletDao(bnbWalletDaoConfig, this);
        btcWalletDao = new BtcWalletDao(btcWalletDaoConfig, this);
        buySellBuyTodoDao = new BuySellBuyTodoDao(buySellBuyTodoDaoConfig, this);
        buySellSellTodoDao = new BuySellSellTodoDao(buySellSellTodoDaoConfig, this);
        defiSearchHistoryDao = new DefiSearchHistoryDao(defiSearchHistoryDaoConfig, this);
        dWCSessionDao = new DWCSessionDao(dWCSessionDaoConfig, this);
        entrustTodoDao = new EntrustTodoDao(entrustTodoDaoConfig, this);
        eosAccountDao = new EosAccountDao(eosAccountDaoConfig, this);
        ethWalletDao = new EthWalletDao(ethWalletDaoConfig, this);
        qLCAccountDao = new QLCAccountDao(qLCAccountDaoConfig, this);
        recordSaveDao = new RecordSaveDao(recordSaveDaoConfig, this);
        swapRecordDao = new SwapRecordDao(swapRecordDaoConfig, this);
        topupTodoListDao = new TopupTodoListDao(topupTodoListDaoConfig, this);
        transactionRecordDao = new TransactionRecordDao(transactionRecordDaoConfig, this);
        userAccountDao = new UserAccountDao(userAccountDaoConfig, this);
        vpnEntityDao = new VpnEntityDao(vpnEntityDaoConfig, this);
        vpnServerRecordDao = new VpnServerRecordDao(vpnServerRecordDaoConfig, this);
        walletDao = new WalletDao(walletDaoConfig, this);

        registerDao(BnbWallet.class, bnbWalletDao);
        registerDao(BtcWallet.class, btcWalletDao);
        registerDao(BuySellBuyTodo.class, buySellBuyTodoDao);
        registerDao(BuySellSellTodo.class, buySellSellTodoDao);
        registerDao(DefiSearchHistory.class, defiSearchHistoryDao);
        registerDao(DWCSession.class, dWCSessionDao);
        registerDao(EntrustTodo.class, entrustTodoDao);
        registerDao(EosAccount.class, eosAccountDao);
        registerDao(EthWallet.class, ethWalletDao);
        registerDao(QLCAccount.class, qLCAccountDao);
        registerDao(RecordSave.class, recordSaveDao);
        registerDao(SwapRecord.class, swapRecordDao);
        registerDao(TopupTodoList.class, topupTodoListDao);
        registerDao(TransactionRecord.class, transactionRecordDao);
        registerDao(UserAccount.class, userAccountDao);
        registerDao(VpnEntity.class, vpnEntityDao);
        registerDao(VpnServerRecord.class, vpnServerRecordDao);
        registerDao(Wallet.class, walletDao);
    }
    
    public void clear() {
        bnbWalletDaoConfig.clearIdentityScope();
        btcWalletDaoConfig.clearIdentityScope();
        buySellBuyTodoDaoConfig.clearIdentityScope();
        buySellSellTodoDaoConfig.clearIdentityScope();
        defiSearchHistoryDaoConfig.clearIdentityScope();
        dWCSessionDaoConfig.clearIdentityScope();
        entrustTodoDaoConfig.clearIdentityScope();
        eosAccountDaoConfig.clearIdentityScope();
        ethWalletDaoConfig.clearIdentityScope();
        qLCAccountDaoConfig.clearIdentityScope();
        recordSaveDaoConfig.clearIdentityScope();
        swapRecordDaoConfig.clearIdentityScope();
        topupTodoListDaoConfig.clearIdentityScope();
        transactionRecordDaoConfig.clearIdentityScope();
        userAccountDaoConfig.clearIdentityScope();
        vpnEntityDaoConfig.clearIdentityScope();
        vpnServerRecordDaoConfig.clearIdentityScope();
        walletDaoConfig.clearIdentityScope();
    }

    public BnbWalletDao getBnbWalletDao() {
        return bnbWalletDao;
    }

    public BtcWalletDao getBtcWalletDao() {
        return btcWalletDao;
    }

    public BuySellBuyTodoDao getBuySellBuyTodoDao() {
        return buySellBuyTodoDao;
    }

    public BuySellSellTodoDao getBuySellSellTodoDao() {
        return buySellSellTodoDao;
    }

    public DefiSearchHistoryDao getDefiSearchHistoryDao() {
        return defiSearchHistoryDao;
    }

    public DWCSessionDao getDWCSessionDao() {
        return dWCSessionDao;
    }

    public EntrustTodoDao getEntrustTodoDao() {
        return entrustTodoDao;
    }

    public EosAccountDao getEosAccountDao() {
        return eosAccountDao;
    }

    public EthWalletDao getEthWalletDao() {
        return ethWalletDao;
    }

    public QLCAccountDao getQLCAccountDao() {
        return qLCAccountDao;
    }

    public RecordSaveDao getRecordSaveDao() {
        return recordSaveDao;
    }

    public SwapRecordDao getSwapRecordDao() {
        return swapRecordDao;
    }

    public TopupTodoListDao getTopupTodoListDao() {
        return topupTodoListDao;
    }

    public TransactionRecordDao getTransactionRecordDao() {
        return transactionRecordDao;
    }

    public UserAccountDao getUserAccountDao() {
        return userAccountDao;
    }

    public VpnEntityDao getVpnEntityDao() {
        return vpnEntityDao;
    }

    public VpnServerRecordDao getVpnServerRecordDao() {
        return vpnServerRecordDao;
    }

    public WalletDao getWalletDao() {
        return walletDao;
    }

}
