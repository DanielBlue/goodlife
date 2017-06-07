package com.zoesap.goodlife.view.LoadMoreRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.zoesap.goodlife.R;

/**
 * Created by maoqi on 2017/6/7.
 */
public abstract class LoadMoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_FOOTER = 10086;
    private boolean hasMoreData ;

    public abstract RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType);

    public abstract void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position);

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foot_view_load_more, parent, false);
            return new FooterViewHolder(view);
        } else {
            return onCreateItemViewHolder(parent, viewType);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FooterViewHolder) {
            //没有更多数据
            if (hasMoreData) {
                ((FooterViewHolder) holder).mProgressView.setVisibility(View.VISIBLE);
            } else {
                ((FooterViewHolder) holder).mProgressView.setVisibility(View.VISIBLE);
            }
        } else {
            onBindItemViewHolder(holder, position);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return TYPE_FOOTER;
    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder {
        public final ProgressBar mProgressView;

        public FooterViewHolder(View view) {
            super(view);
            mProgressView = (ProgressBar) view.findViewById(R.id.pb_progress);
        }
    }
}
