package com.zoesap.goodlife.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.zoesap.goodlife.GoodLifeApplication;
import com.zoesap.goodlife.R;

/**
 * Created by maoqi on 2017/6/6.
 */

public class MyHouseListAdapter extends RecyclerView.Adapter<MyHouseListAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(GoodLifeApplication.appContext, R.layout.item_my_house_list,null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
