package com.zoesap.goodlife.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;

import com.zoesap.goodlife.Constants;
import com.zoesap.goodlife.R;
import com.zoesap.goodlife.base.BaseToolbarWebActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by maoqi on 2017/6/6.
 */

public class ParkingActivity extends BaseToolbarWebActivity {
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
        tvTitle.setText(R.string.parking);

        loadWeb();
    }

    private void loadWeb() {
        initWeb(wvWeb);
//        wvWeb.loadUrl("http://t.aparcar.cn/service/parking/index/?bno=test&bsecret=abcd&userid=2899331&username=%E8%AE%BF%E5%AE%A2150%2A%2A%2A%2A6127&mobile=15072616127&password=3213538fe6d69140def4ddf371a75089&cid=585&cname=%E4%BD%93%E9%AA%8C%E5%B0%8F%E5%8C%BA&caddress=%E5%8C%97%E4%BA%AC%E5%B8%82-%E5%8C%97%E4%BA%AC%E5%B8%82-%E4%B8%9C%E5%9F%8E%E5%8C%BA-%E4%BD%93%E9%AA%8C%E5%B0%8F%E5%8C%BA-%E5%BD%A9%E7%94%9F%E6%B4%BB%E6%9C%8D%E5%8A%A1%E9%9B%86%E5%9B%A2&sign=832DBA5D3B1A8F420E922375C95ED484");
        wvWeb.loadUrl(Constants.ASSET_FILE_PREFIXION+"parking.html");
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
        Intent intent = new Intent(activity, ParkingActivity.class);
        return intent;
    }
}
