package com.zoesap.goodlife.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zoesap.goodlife.R;
import com.zoesap.goodlife.model.bean.RechargeHistoryBean;
import com.zoesap.goodlife.view.LoadMoreRecyclerView.LoadMoreAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by maoqi on 2017/6/8.
 */

public class TestAdapter extends LoadMoreAdapter {
    Context context;
    List<RechargeHistoryBean> data;

    public TestAdapter(Context context, List<RechargeHistoryBean> data,boolean hasMoreData) {
        super(hasMoreData);
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_recharge_history_list, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ViewHolder holder = (ViewHolder)viewHolder;
        holder.tvChargeDate.setText(data.get(position).getTv_charge_date());
        holder.tvRechargeNum.setText(data.get(position).getTv_recharge_num());
        holder.tvRechargePhone.setText(data.get(position).getTv_recharge_phone());
        holder.tvRechargeStatus.setText(data.get(position).getTv_recharge_status());

    }

    @Override
    public int getListItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_recharge_status)
        TextView tvRechargeStatus;
        @BindView(R.id.tv_recharge_num)
        TextView tvRechargeNum;
        @BindView(R.id.tv_recharge_phone)
        TextView tvRechargePhone;
        @BindView(R.id.tv_charge_date)
        TextView tvChargeDate;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
