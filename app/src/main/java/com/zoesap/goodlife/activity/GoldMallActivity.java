package com.zoesap.goodlife.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.widget.TextView;

import com.zoesap.goodlife.Constants;
import com.zoesap.goodlife.R;
import com.zoesap.goodlife.base.BaseToolbarWebActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoldMallActivity extends BaseToolbarWebActivity {
    final String url = "http://api.xiami.com/web?v=2.0&app_key=1&key=liudehua&page=1&limit=50&callback=jsonp154&r=search/songs";

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tb_toolbar)
    Toolbar tbToolbar;
    @BindView(R.id.wv_web)
    WebView wvWeb;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_gold_mall);
        ButterKnife.bind(this);
        initToolbar(tbToolbar);
        tvTitle.setText(R.string.gold_store);
        loadWeb();
    }

    private void loadWeb() {
        initWeb(wvWeb);
//        setCookie();
//        wvWeb.loadUrl("http://ticketmall.colourlife.com/?bno=test&bsecret=abcd&userid=2899331&username=%E8%AE%BF%E5%AE%A2150%2A%2A%2A%2A6127&mobile=15072616127&password=3213538fe6d69140def4ddf371a75089&cid=585&cname=%E4%BD%93%E9%AA%8C%E5%B0%8F%E5%8C%BA&caddress=%E5%8C%97%E4%BA%AC%E5%B8%82-%E5%8C%97%E4%BA%AC%E5%B8%82-%E4%B8%9C%E5%9F%8E%E5%8C%BA-%E4%BD%93%E9%AA%8C%E5%B0%8F%E5%8C%BA-%E5%BD%A9%E7%94%9F%E6%B4%BB%E6%9C%8D%E5%8A%A1%E9%9B%86%E5%9B%A2&sign=89C65B1F6023A4C5B84D771E224F294F");
        wvWeb.loadUrl(Constants.GOLD_MALL_URL);
    }

    private void setCookie() {
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.removeSessionCookie();
        cookieManager.removeAllCookie();
        cookieManager.setCookie(url, "_unsign_token=f8322aaf9c002f881a4ce5219b4043a3");
        cookieManager.setCookie(url, "_xiamitoken=9a036aa74582b6ac80fac7d91ef1fbd6");
        cookieManager.setCookie(url, "cna=3TrFETrczSsCAduL/GvdNO2V");
        cookieManager.setCookie(url, "gid=149725513795119");
        cookieManager.setCookie(url, "isg=Ajo6URM_N4stWbtnOHmvQ6KYi2CcQ76_1B35o0Qzbk2YN9pxLHsO1QBH8_QR");
        cookieManager.setCookie(url, "UM_distinctid=15c9b5c44bc7da-0d1205a09a398e-551b3517-15f900-15c9b5c44bd686");
        CookieSyncManager.getInstance().sync();
    }

    @Override
    protected void initData() {

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
        Intent intent = new Intent(activity, GoldMallActivity.class);
        return intent;
    }
}
