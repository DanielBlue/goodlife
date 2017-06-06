package com.zoesap.goodlife.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.zoesap.goodlife.BaseToolbarActivity;
import com.zoesap.goodlife.R;

import java.lang.reflect.Method;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuardActivity extends BaseToolbarActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tb_toolbar)
    Toolbar tbToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_guard);
        ButterKnife.bind(this);
        initToolbar(tbToolbar);
        tvTitle.setText(R.string.door_scan);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_door_guard, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (menu != null) {
            if (menu.getClass() == MenuBuilder.class) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                }
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    }

    ;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.item_menu_saoyisao:
                break;
            case R.id.item_menu_apply_permission:
                break;
            case R.id.item_menu_accredit_permission:
                break;
            case R.id.item_menu_edit_door_scan:
                break;
            case R.id.item_menu_door_scan_help:
                break;
        }
        return true;
    }

    @Override
    protected void initData() {

    }


    public static Intent createStartIntent(Activity activity) {
        Intent intent = new Intent(activity, GuardActivity.class);
        return intent;
    }
}
