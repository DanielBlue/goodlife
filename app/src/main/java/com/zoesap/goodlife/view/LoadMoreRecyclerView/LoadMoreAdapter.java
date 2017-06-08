package com.zoesap.goodlife.view.LoadMoreRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zoesap.goodlife.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by maoqi on 2017/6/7.
 */
public abstract class LoadMoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_FOOTER = 10086;
    private boolean hasMoreData;

    public abstract RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType);

    public abstract void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position);

    public abstract int getListItemCount();

    public LoadMoreAdapter(boolean hasMoreData) {
        this.hasMoreData = hasMoreData;
    }

    public void setHasMoreData(boolean hasMoreData) {
        this.hasMoreData = hasMoreData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foot_view_load_more, parent, false);
            return new FooterViewHolder(view);
        }
        return onCreateItemViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FooterViewHolder) {
            if (hasMoreData) {
                ((FooterViewHolder) holder).tvText.setVisibility(View.GONE);
                ((FooterViewHolder) holder).pbProgress.setVisibility(View.VISIBLE);
            } else {
                ((FooterViewHolder) holder).tvText.setVisibility(View.VISIBLE);
                ((FooterViewHolder) holder).pbProgress.setVisibility(View.GONE);
            }
        } else {
            onBindItemViewHolder(holder, position);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return TYPE_FOOTER;
        }
        return 0;
    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_text)
        TextView tvText;
        @BindView(R.id.pb_progress)
        ProgressBar pbProgress;

        public FooterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public int getItemCount() {
        return getListItemCount() + 1;
    }
}
