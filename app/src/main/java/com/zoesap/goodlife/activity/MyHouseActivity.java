package com.zoesap.goodlife.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.zoesap.goodlife.BaseToolbarActivity;
import com.zoesap.goodlife.R;
import com.zoesap.goodlife.adapter.MyHouseListAdapter;
import com.zoesap.goodlife.adapter.SpacesItemDecoration;
import com.zoesap.goodlife.util.DensityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyHouseActivity extends BaseToolbarActivity {

    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tb_toolbar)
    Toolbar tbToolbar;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_my_house);
        ButterKnife.bind(this);
        initToolbar(tbToolbar);
        tvTitle.setText(R.string.my_house);

        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.addItemDecoration(new SpacesItemDecoration(DensityUtils.dp2px(this,5)));
        rvList.setAdapter(new MyHouseListAdapter());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_house,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            case R.id.add_house:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initData() {

    }

    public static Intent createStartIntent(Activity activity) {
        Intent intent = new Intent(activity, MyHouseActivity.class);
        return intent;
    }
}
