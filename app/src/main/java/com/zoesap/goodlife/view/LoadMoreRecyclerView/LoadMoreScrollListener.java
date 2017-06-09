package com.zoesap.goodlife.view.LoadMoreRecyclerView;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by maoqi on 2017/6/7.
 */

public abstract class LoadMoreScrollListener extends RecyclerView.OnScrollListener {

    private int previousTotal = 0;
    private boolean loading = true;
    int firstVisibleItem, visibleItemCount, totalItemCount;

    private int currentPage = 1;

    private LinearLayoutManager mLinearLayoutManager;

    public LoadMoreScrollListener(LinearLayoutManager linearLayoutManager) {
        this.mLinearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = mLinearLayoutManager.getItemCount();
        firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();

        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;
            }
        }

        if (!loading && (totalItemCount - visibleItemCount) <= firstVisibleItem) {
            currentPage++;
            onLoadMore(currentPage);
            loading = true;
        }

    }

    public void setPreviousTotal(int previousTotal) {
        this.previousTotal = previousTotal;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    public boolean getLoading() {
        return loading;
    }
    public abstract void onLoadMore(int currentPage);
}