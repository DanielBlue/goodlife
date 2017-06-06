package com.zoesap.goodlife.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zoesap.goodlife.R;
import com.zoesap.goodlife.model.bean.RechargeHistoryBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by maoqi on 2017/6/5.
 */

public class RechargeHistoryListAdapter extends RecyclerView.Adapter<RechargeHistoryListAdapter.ViewHolder> {
    List<RechargeHistoryBean> data;
    Context context;

    public RechargeHistoryListAdapter(Context context, List<RechargeHistoryBean> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_recharge_history_list, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvChargeDate.setText(data.get(position).getTv_charge_date());
        holder.tvRechargeNum.setText(data.get(position).getTv_recharge_num());
        holder.tvRechargePhone.setText(data.get(position).getTv_recharge_phone());
        holder.tvRechargeStatus.setText(data.get(position).getTv_recharge_status());

    }

    @Override
    public int getItemCount() {
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
