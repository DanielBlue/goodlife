package com.zoesap.goodlife.fragment;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zoesap.goodlife.base.BaseToolbarFragment;
import com.zoesap.goodlife.R;
import com.zoesap.goodlife.activity.BusinessAreaActivity;
import com.zoesap.goodlife.activity.NearCommunityActivity;
import com.zoesap.goodlife.activity.SameCommunityActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by maoqi on 2017/6/1.
 */

public class DiscoverFragment extends BaseToolbarFragment {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tb_toolbar)
    Toolbar tbToolbar;
    @BindView(R.id.ll_business)
    LinearLayout llBusiness;
    @BindView(R.id.ll_same_community)
    LinearLayout llSameCommunity;
    @BindView(R.id.ll_near_community)
    LinearLayout llNearCommunity;
    Unbinder unbinder;

    @Override
    protected void initData() {

    }

    @Override
    protected View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_discover, null);
        unbinder = ButterKnife.bind(this, view);
        initToolbar(tbToolbar);
        tvTitle.setText(R.string.tab_discover);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.ll_business, R.id.ll_same_community, R.id.ll_near_community})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_business:
                activity.startActivity(BusinessAreaActivity.createStartIntent(activity));
                break;
            case R.id.ll_same_community:
                activity.startActivity(SameCommunityActivity.createStartIntent(activity));
                break;
            case R.id.ll_near_community:
                activity.startActivity(NearCommunityActivity.createStartIntent(activity));
                break;
        }
    }
}
