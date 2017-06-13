package com.zoesap.goodlife.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zoesap.goodlife.R;
import com.zoesap.goodlife.base.BaseToolbarActivity;
import com.zoesap.goodlife.util.TUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoldRechargeActivity extends BaseToolbarActivity implements TextWatcher {

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
    @BindView(R.id.et_recharge_limit)
    EditText etRechargeLimit;
    @BindView(R.id.tv_ok)
    TextView tvOk;
    @BindView(R.id.tv_top_limit)
    TextView tvTopLimit;
    @BindView(R.id.tv_bottom_limit)
    TextView tvBottomLimit;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_gold_recharge);
        ButterKnife.bind(this);
        initToolbar(tbToolbar);
        tvTitle.setText(R.string.recharge);
        etRechargeLimit.addTextChangedListener(this);
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.tv_option1, R.id.tv_option2, R.id.tv_option3, R.id.tv_option4, R.id.tv_option5, R.id.tv_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_option1:
                initOnClickStatus();
                tvOption1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                setLimitText("50");
                break;
            case R.id.tv_option2:
                initOnClickStatus();
                tvOption2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                setLimitText("100");
                break;
            case R.id.tv_option3:
                initOnClickStatus();
                tvOption3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                setLimitText("200");
                break;
            case R.id.tv_option4:
                initOnClickStatus();
                tvOption4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                setLimitText("500");
                break;
            case R.id.tv_option5:
                initOnClickStatus();
                tvOption5.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                setLimitText("1000");
                break;
            case R.id.tv_ok:
                break;
        }
    }

    private void setLimitText(String s) {
        tvTopLimit.setVisibility(View.VISIBLE);
        tvBottomLimit.setVisibility(View.VISIBLE);
        tvTopLimit.setText("¥" + s);
        tvBottomLimit.setText("可获得饭票" + s + "元");
    }

    private void initOnClickStatus() {
        tvOption1.setBackgroundColor(getResources().getColor(R.color.white));
        tvOption2.setBackgroundColor(getResources().getColor(R.color.white));
        tvOption3.setBackgroundColor(getResources().getColor(R.color.white));
        tvOption4.setBackgroundColor(getResources().getColor(R.color.white));
        tvOption5.setBackgroundColor(getResources().getColor(R.color.white));
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
        Intent intent = new Intent(activity, GoldRechargeActivity.class);
        return intent;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.length()>0){
            if (s.charAt(0) == '0') {
                TUtils.showShort(R.string.illegal_argument);
                for (int x = 0; x < s.length(); x++) {
                    if (!(s.charAt(x) == '0')) {
                        setLimitText(s.subSequence(x, s.length()).toString());
                        break;
                    }
                }
            } else {
                setLimitText(s.toString());
            }
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
