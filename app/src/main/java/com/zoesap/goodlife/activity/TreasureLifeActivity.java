package com.zoesap.goodlife.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.zoesap.goodlife.BaseToolbarActivity;
import com.zoesap.goodlife.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TreasureLifeActivity extends BaseToolbarActivity {

    @BindView(R.id.tb_toolbar)
    Toolbar tbToolbar;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_my_property_num)
    TextView tvMyPropertyNum;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_treasure_life);
        ButterKnife.bind(this);
        initToolbar(tbToolbar);
        tvTitle.setText(R.string.treasure_life);

        tvMyPropertyNum.setText("0.00");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_treasurelife_activity,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public static Intent createStartIntent(Activity activity){
        Intent intent = new Intent(activity,TreasureLifeActivity.class);
        return intent;
    }
}
