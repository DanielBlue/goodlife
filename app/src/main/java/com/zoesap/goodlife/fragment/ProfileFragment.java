package com.zoesap.goodlife.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.zoesap.goodlife.BaseToolbarFragment;
import com.zoesap.goodlife.R;
import com.zoesap.goodlife.activity.BusinessOrderActivity;
import com.zoesap.goodlife.activity.InviteFriendActivity;
import com.zoesap.goodlife.activity.MessageActivity;
import com.zoesap.goodlife.activity.MyCardActivity;
import com.zoesap.goodlife.activity.MyGoldActivity;
import com.zoesap.goodlife.activity.MyHouseActivity;
import com.zoesap.goodlife.activity.MyMoneyManagerActivity;
import com.zoesap.goodlife.activity.PayHistoryActivity;
import com.zoesap.goodlife.activity.RechargeHistoryActivity;
import com.zoesap.goodlife.activity.SettingActivity;
import com.zoesap.goodlife.activity.YourOpinionActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by maoqi on 2017/6/1.
 */

public class ProfileFragment extends BaseToolbarFragment {
    Unbinder unbinder;

    @BindView(R.id.tb_toolbar)
    Toolbar tbToolbar;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_profile, null);
        unbinder = ButterKnife.bind(this, view);
        tbToolbar.inflateMenu(R.menu.menu_profile);
        initToolbar(tbToolbar, R.drawable.e0_message);
        tvTitle.setText(R.string.tab_profile);
        tbToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(MessageActivity.createStartIntent(activity));
            }
        });

        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_profile, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting:
                activity.startActivity(SettingActivity.createStartIntent(activity));
                break;
        }
        return true;
    }

    @OnClick({R.id.ll_recharge_history, R.id.ll_my_gold,R.id.ll_my_house,
            R.id.ll_order_record,R.id.ll_business_order,R.id.ll_my_card,
            R.id.ll_my_money_manager,R.id.ll_your_opinion,R.id.ll_invite})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_recharge_history:
                startActivity(RechargeHistoryActivity.createStartIntent(activity));
                break;
            case R.id.ll_my_gold:
                startActivity(MyGoldActivity.createStartIntent(activity));
                break;
            case R.id.ll_my_house:
                startActivity(MyHouseActivity.createStartIntent(activity));
                break;
            case R.id.ll_order_record:
                startActivity(PayHistoryActivity.createStartIntent(activity));
                break;
            case R.id.ll_business_order:
                startActivity(BusinessOrderActivity.createStartIntent(activity));
                break;
            case R.id.ll_my_card:
                startActivity(MyCardActivity.createStartIntent(activity));
                break;
            case R.id.ll_my_money_manager:
                startActivity(MyMoneyManagerActivity.createStartIntent(activity));
                break;
            case R.id.ll_your_opinion:
                startActivity(YourOpinionActivity.createStartIntent(activity));
                break;
            case R.id.ll_invite:
                startActivity(InviteFriendActivity.createStartIntent(activity));
                break;
        }
    }
}
