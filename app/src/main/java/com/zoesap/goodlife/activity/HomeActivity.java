package com.zoesap.goodlife.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.zoesap.goodlife.base.BaseActivity;
import com.zoesap.goodlife.R;
import com.zoesap.goodlife.adapter.HomeTabPagerAdapter;
import com.zoesap.goodlife.fragment.CommunityFragment;
import com.zoesap.goodlife.fragment.DiscoverFragment;
import com.zoesap.goodlife.fragment.HomeFragment;
import com.zoesap.goodlife.fragment.ProfileFragment;
import com.zoesap.goodlife.view.NoScrollViewpager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private static final int REQUEST_CODE = 10086;
    @BindView(R.id.vp_tab)
    NoScrollViewpager vpTab;
    @BindView(R.id.rb_home)
    RadioButton rbHome;
    @BindView(R.id.rb_community)
    RadioButton rbCommunity;
    @BindView(R.id.rb_saoyisao)
    RadioButton rbSaoyisao;
    @BindView(R.id.rb_discover)
    RadioButton rbDiscover;
    @BindView(R.id.rb_profile)
    RadioButton rbProfile;
    @BindView(R.id.rg_group)
    RadioGroup rgGroup;
    private int preRbId = 0;
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void initView() {
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        rgGroup.setOnCheckedChangeListener(this);
        vpTab.setAdapter(new HomeTabPagerAdapter(getSupportFragmentManager(), fragmentList));
    }

    @Override
    protected void initData() {
        HomeFragment homeFragment = new HomeFragment();
        CommunityFragment communityFragment = new CommunityFragment();
        DiscoverFragment discoverFragment = new DiscoverFragment();
        ProfileFragment profileFragment = new ProfileFragment();
        fragmentList.add(homeFragment);
        fragmentList.add(communityFragment);
        fragmentList.add(discoverFragment);
        fragmentList.add(profileFragment);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                vpTab.setCurrentItem(0);
                preRbId = 0;
                break;
            case R.id.rb_community:
                vpTab.setCurrentItem(1);
                preRbId = 1;
                break;
            case R.id.rb_saoyisao:
                Intent intent = new Intent(this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.rb_discover:
                vpTab.setCurrentItem(2);
                preRbId = 3;
                break;
            case R.id.rb_profile:
                vpTab.setCurrentItem(3);
                preRbId = 4;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }

            }
            rgGroup.getChildAt(preRbId).performClick();
        }
    }

    public static Intent createStartIntent(Activity activity) {
        Intent intent = new Intent(activity, HomeActivity.class);
        return intent;
    }

}
