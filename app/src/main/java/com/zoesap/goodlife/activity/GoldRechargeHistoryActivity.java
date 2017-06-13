package com.zoesap.goodlife.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.zoesap.goodlife.R;
import com.zoesap.goodlife.base.BaseToolbarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoldRechargeHistoryActivity extends BaseToolbarActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tb_toolbar)
    Toolbar tbToolbar;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_gold_recharge_history);
        ButterKnife.bind(this);
        initToolbar(tbToolbar);
        tvTitle.setText(R.string.recharge_history);
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.tv_go_recharge)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.tv_go_recharge:
                startActivity(GoldRechargeActivity.createStartIntent(this));
                break;
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
        Intent intent = new Intent(activity, GoldRechargeHistoryActivity.class);
        return intent;
    }
}
