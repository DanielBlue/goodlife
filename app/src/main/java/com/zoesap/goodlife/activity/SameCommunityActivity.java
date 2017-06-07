package com.zoesap.goodlife.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.zoesap.goodlife.base.BaseToolbarActivity;
import com.zoesap.goodlife.R;
import com.zoesap.goodlife.adapter.SameCommunityAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SameCommunityActivity extends BaseToolbarActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tb_toolbar)
    Toolbar tbToolbar;
    @BindView(R.id.rv_list)
    RecyclerView rvList;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_same_community);
        ButterKnife.bind(this);
        initToolbar(tbToolbar);
        tvTitle.setText(R.string.same_community);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(new SameCommunityAdapter());

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
        Intent intent = new Intent(activity, SameCommunityActivity.class);
        return intent;
    }
}
