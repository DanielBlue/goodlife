package com.zoesap.goodlife.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.zoesap.goodlife.BaseToolbarActivity;
import com.zoesap.goodlife.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PayHistoryActivity extends BaseToolbarActivity {

    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tb_toolbar)
    Toolbar tbToolbar;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_pay_history);
        ButterKnife.bind(this);
        initToolbar(tbToolbar);
        tvTitle.setText(R.string.record_all);
    }

    @Override
    protected void initData() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pay_history,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            case R.id.record_all:
                tvTitle.setText(R.string.record_all);
                return true;
            case R.id.record_electricity:
                tvTitle.setText(R.string.record_electricity);
                return true;
            case R.id.record_house:
                tvTitle.setText(R.string.record_house);
                return true;
            case R.id.record_store:
                tvTitle.setText(R.string.record_store);
                return true;
            case R.id.record_park:
                tvTitle.setText(R.string.record_park);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static Intent createStartIntent(Activity activity) {
        Intent intent = new Intent(activity, PayHistoryActivity.class);
        return intent;
    }
}
