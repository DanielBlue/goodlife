package com.zoesap.goodlife.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.zoesap.goodlife.BaseToolbarActivity;
import com.zoesap.goodlife.R;
import com.zoesap.goodlife.adapter.RechargeHistoryListAdapter;
import com.zoesap.goodlife.adapter.SpacesItemDecoration;
import com.zoesap.goodlife.model.bean.RechargeHistoryBean;
import com.zoesap.goodlife.util.DensityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RechargeHistoryActivity extends BaseToolbarActivity {

    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tb_toolbar)
    Toolbar tbToolbar;
    private List<RechargeHistoryBean> data;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_recharge_history);
        ButterKnife.bind(this);
        initToolbar(tbToolbar);
        tvTitle.setText(R.string.recharge_history);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.addItemDecoration(new SpacesItemDecoration(DensityUtils.dp2px(this,5)));
        rvList.setAdapter(new RechargeHistoryListAdapter(this,data));
    }

    @Override
    protected void initData() {
        data = new ArrayList<>();
        RechargeHistoryBean bean;
        for (int x=0;x<20;x++){
            bean = new RechargeHistoryBean("充值中"+x,"10.22","充值号码 : 1523365974412","下单时间 : 2017-6-5");
            data.add(bean);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static Intent createStartIntent(Activity activity) {
        Intent intent = new Intent(activity, RechargeHistoryActivity.class);
        return intent;
    }

}
