package com.zoesap.goodlife.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.zoesap.goodlife.R;
import com.zoesap.goodlife.base.BaseToolbarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YourOpinionActivity extends BaseToolbarActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tb_toolbar)
    Toolbar tbToolbar;
    @BindView(R.id.tv_option1)
    TextView tvOption1;
    @BindView(R.id.tv_option2)
    TextView tvOption2;
    @BindView(R.id.tv_option3)
    TextView tvOption3;
    @BindView(R.id.tv_option4)
    TextView tvOption4;
    @BindView(R.id.tv_option5)
    TextView tvOption5;
    @BindView(R.id.tv_option6)
    TextView tvOption6;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_your_opinion);
        ButterKnife.bind(this);
        initToolbar(tbToolbar);
        tvTitle.setText(R.string.your_opinion);
    }

    @Override
    protected void initData() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opinion, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static Intent createStartIntent(Activity activity) {
        Intent intent = new Intent(activity, YourOpinionActivity.class);
        return intent;
    }

    @OnClick({R.id.tv_option1, R.id.tv_option2, R.id.tv_option3, R.id.tv_option4, R.id.tv_option5, R.id.tv_option6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_option1:
                initOnClickStatus();
                tvOption1.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
            case R.id.tv_option2:
                initOnClickStatus();
                tvOption2.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
            case R.id.tv_option3:
                initOnClickStatus();
                tvOption3.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
            case R.id.tv_option4:
                initOnClickStatus();
                tvOption4.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
            case R.id.tv_option5:
                initOnClickStatus();
                tvOption5.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
            case R.id.tv_option6:
                initOnClickStatus();
                tvOption6.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
        }
    }

    private void initOnClickStatus() {
        tvOption1.setBackgroundColor(getResources().getColor(R.color.white));
        tvOption2.setBackgroundColor(getResources().getColor(R.color.white));
        tvOption3.setBackgroundColor(getResources().getColor(R.color.white));
        tvOption4.setBackgroundColor(getResources().getColor(R.color.white));
        tvOption5.setBackgroundColor(getResources().getColor(R.color.white));
        tvOption6.setBackgroundColor(getResources().getColor(R.color.white));
    }
}
