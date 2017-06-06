package com.zoesap.goodlife.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;

import com.zoesap.goodlife.BaseToolbarWebActivity;
import com.zoesap.goodlife.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by maoqi on 2017/6/6.
 */

public class EPassActivity extends BaseToolbarWebActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tb_toolbar)
    Toolbar tbToolbar;
    @BindView(R.id.wv_web)
    WebView wvWeb;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_about_gold);
        ButterKnife.bind(this);
        initToolbar(tbToolbar);
        tvTitle.setText(R.string.e_pass);
        loadWeb();
    }

    private void loadWeb() {
        initWeb(wvWeb);
        wvWeb.loadUrl("http://eft.colourlife.com/?platform=colourlife&userid=2899331&username=user_15072616127&mobile=15072616127&password=3a018596eeaad1cc0d18b05e6fbcbc65&cid=585&cname=%E4%BD%93%E9%AA%8C%E5%B0%8F%E5%8C%BA&caddress=%E5%8C%97%E4%BA%AC%E5%B8%82-%E5%8C%97%E4%BA%AC%E5%B8%82-%E4%B8%9C%E5%9F%8E%E5%8C%BA&cname=%E4%BD%93%E9%AA%8C%E5%B0%8F%E5%8C%BA&caddress=%E5%8C%97%E4%BA%AC%E5%B8%82-%E5%8C%97%E4%BA%AC%E5%B8%82-%E4%B8%9C%E5%9F%8E%E5%8C%BA-%E4%BD%93%E9%AA%8C%E5%B0%8F%E5%8C%BA&sign=73CDAC12A78401940C9BE3C7AAB0F257");
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
        Intent intent = new Intent(activity, EPassActivity.class);
        return intent;
    }
}
