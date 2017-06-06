package com.zoesap.goodlife.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zoesap.goodlife.GoodLifeApplication;
import com.zoesap.goodlife.R;
import com.zoesap.goodlife.model.bean.NotifyMessageBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 毛琦 on 2017/6/3.
 */

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.ViewHoler> {

    private List<NotifyMessageBean> data;

    public MessageListAdapter(List<NotifyMessageBean> data) {
        this.data = data;
    }

    @Override
    public ViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(GoodLifeApplication.appContext, R.layout.item_message, null);
        ViewHoler holer = new ViewHoler(view);
        return holer;
    }

    @Override
    public void onBindViewHolder(ViewHoler holder, int position) {
        holder.tvTitle.setText(data.get(position).getTitle());
        holder.tvDate.setText(data.get(position).getDate());
        holder.tvDes.setText(data.get(position).getDes());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHoler extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.tv_des)
        TextView tvDes;
        @BindView(R.id.rl_item)
        RelativeLayout rlItem;

        public ViewHoler(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
