package com.zoesap.goodlife.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.zoesap.goodlife.R;
import com.zoesap.goodlife.base.BaseToolbarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoldGiveHistoryActivity extends BaseToolbarActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tb_toolbar)
    Toolbar tbToolbar;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_gold_income_history);
        ButterKnife.bind(this);
        initToolbar(tbToolbar);
        tvTitle.setText(R.string.give_list);
    }

    @Override
    protected void initData() {

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
        Intent intent = new Intent(activity, GoldGiveHistoryActivity.class);
        return intent;
    }
}
