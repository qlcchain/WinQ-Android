package com.stratagile.qlink.ui.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.stratagile.qlink.R;

/**
 * Created by huzhipeng on 2018/1/11.
 */

public class AppealUploadImgItemDecoration extends RecyclerView.ItemDecoration {
    int mSpace;

    /**
     * Retrieve any offsets for the given item. Each field of <code>outRect</code> specifies
     * the number of pixels that the item view should be inset by, similar to padding or margin.
     * The default implementation sets the bounds of outRect to 0 and returns.
     * <p>
     * <p>
     * If this ItemDecoration does not affect the positioning of item views, it should set
     * all four fields of <code>outRect</code> (left, top, right, bottom) to zero
     * before returning.
     * <p>
     * <p>
     * If you need to access Adapter for additional data, you can call
     * {@link RecyclerView#getChildAdapterPosition(View)} to get the adapter position of the
     * View.
     *
     * @param outRect Rect to receive the output.
     * @param view    The child view to decorate
     * @param parent  RecyclerView this ItemDecoration is decorating
     * @param state   The current state of RecyclerView.
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.set(0, 0, 0, 0);
        }
        if (parent.getChildAdapterPosition(view) == 1) {
            outRect.set(mSpace - 2, 0, 0, 0);
        }
        if (parent.getChildAdapterPosition(view) == 2) {
            outRect.set(0, mSpace + 4, 0, 0);
        }
        if (parent.getChildAdapterPosition(view) == 3) {
            outRect.set(mSpace - 2, mSpace + 4, 0, 0);
        }

    }

    public AppealUploadImgItemDecoration(int space) {
        this.mSpace = space;
    }
}