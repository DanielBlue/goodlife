package com.zoesap.goodlife.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.zoesap.goodlife.base.BaseToolbarActivity;
import com.zoesap.goodlife.R;
import com.zoesap.goodlife.adapter.MessagePagerAdapter;
import com.zoesap.goodlife.fragment.MessageLeftFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageActivity extends BaseToolbarActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tb_toolbar)
    Toolbar tbToolbar;
    @BindView(R.id.tl_tab)
    TabLayout tlTab;
    @BindView(R.id.vp_pager)
    ViewPager vpPager;
    List<Fragment> data = new ArrayList<>();
    String[] titles={"系统通知","商家消息"};

    @Override
    protected void initView() {
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        initToolbar(tbToolbar);
        tvTitle.setText(R.string.notify);
        vpPager.setAdapter(new MessagePagerAdapter(getSupportFragmentManager(),data,titles));
        tlTab.setupWithViewPager(vpPager);
    }

    @Override
    protected void initData() {
        data.add(new MessageLeftFragment());
        data.add(new MessageLeftFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_message_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.readed_all:
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public static Intent createStartIntent(Activity activity) {
        Intent intent = new Intent(activity, MessageActivity.class);
        return intent;
    }
}
