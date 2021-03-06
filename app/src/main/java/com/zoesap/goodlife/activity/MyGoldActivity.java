package com.zoesap.goodlife.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.zoesap.goodlife.R;
import com.zoesap.goodlife.base.BaseToolbarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyGoldActivity extends BaseToolbarActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tb_toolbar)
    Toolbar tbToolbar;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_my_gold);
        ButterKnife.bind(this);
        initToolbar(tbToolbar);
        tvTitle.setText(R.string.my_gold);
    }

    @Override
    protected void initData() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public static Intent createStartIntent(Activity activity) {
        Intent intent = new Intent(activity, MyGoldActivity.class);
        return intent;
    }

    @OnClick({R.id.ll_recharge, R.id.ll_give, R.id.ll_income_list, R.id.ll_give_list, R.id.ll_recharge_list})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_recharge:
                startActivity(GoldRechargeActivity.createStartIntent(this));
                break;
            case R.id.ll_give:
                startActivity(GoldGiveActivity.createStartIntent(this));
                break;
            case R.id.ll_income_list:
                startActivity(GoldIncomeHistoryActivity.createStartIntent(this));
                break;
            case R.id.ll_give_list:
                startActivity(GoldGiveHistoryActivity.createStartIntent(this));
                break;
            case R.id.ll_recharge_list:
                startActivity(GoldRechargeHistoryActivity.createStartIntent(this));
                break;
        }
    }
}
