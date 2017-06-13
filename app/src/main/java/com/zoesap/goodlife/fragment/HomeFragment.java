package com.zoesap.goodlife.fragment;

import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zoesap.goodlife.activity.BusinessAreaActivity;
import com.zoesap.goodlife.base.BaseFragment;
import com.zoesap.goodlife.R;
import com.zoesap.goodlife.activity.AboutGoldActivity;
import com.zoesap.goodlife.activity.EPassActivity;
import com.zoesap.goodlife.activity.FurnitureRepairsActivity;
import com.zoesap.goodlife.activity.GoldMallActivity;
import com.zoesap.goodlife.activity.GoodLifeHouseActivity;
import com.zoesap.goodlife.activity.GuardActivity;
import com.zoesap.goodlife.activity.HouseManagerActivity;
import com.zoesap.goodlife.activity.MessageActivity;
import com.zoesap.goodlife.activity.MoreActivity;
import com.zoesap.goodlife.activity.MyGoldActivity;
import com.zoesap.goodlife.activity.OpinionActivity;
import com.zoesap.goodlife.activity.ParkingActivity;
import com.zoesap.goodlife.activity.SaveMoneyActivity;
import com.zoesap.goodlife.activity.TreasureLifeActivity;
import com.zoesap.goodlife.adapter.HomeBannerAdapter;
import com.zoesap.goodlife.util.TimerUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class HomeFragment extends BaseFragment {
    @BindView(R.id.vp_banner)
    ViewPager vpBanner;
    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout srlRefresh;

    Unbinder unbinder;
    @BindView(R.id.tv_about_gold)
    TextView tvAboutGold;
    @BindView(R.id.tv_save_money)
    TextView tvSaveMoney;
    @BindView(R.id.tv_my_gold)
    TextView tvMyGold;
    private List<ImageView> list;

    @Override
    protected void initData() {
        list = new ArrayList<>();

        for (int x = 0; x < 3; x++) {
            ImageView view = new ImageView(getActivity());
            view.setImageResource(R.drawable.banner);
            list.add(view);
        }
    }

    @Override
    protected View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        unbinder = ButterKnife.bind(this, view);
        initRefreshLayout();
        HomeBannerAdapter adapter = new HomeBannerAdapter(list);
        vpBanner.setAdapter(adapter);
        return view;
    }

    private void initRefreshLayout() {
        srlRefresh.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        srlRefresh.setNestedScrollingEnabled(false);
        srlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                TimerUtils.getInstance().addTimerTask(new Runnable() {
                    @Override
                    public void run() {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                srlRefresh.setRefreshing(false);
                            }
                        });
                    }
                }, 2000);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        if (srlRefresh.isRefreshing()) {
            TimerUtils.getInstance().removeTimerAllTask();
            srlRefresh.setRefreshing(false);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tv_about_gold, R.id.tv_save_money, R.id.tv_my_gold,
            R.id.tv_more, R.id.tv_open_door, R.id.iv_notify,
            R.id.tv_message, R.id.rl_treasure_life, R.id.tv_gold_mall,
            R.id.tv_parking, R.id.tv_furniture_repairs, R.id.tv_e_pass,
            R.id.tv_opinion,R.id.rl_good_life_house,R.id.rl_house_manager,
            R.id.round})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_more:
                activity.startActivity(MoreActivity.createStartIntent(activity));
                break;
            case R.id.tv_about_gold:
                activity.startActivity(AboutGoldActivity.createStartIntent(activity));
                break;
            case R.id.tv_save_money:
                activity.startActivity(SaveMoneyActivity.createStartIntent(activity));
                break;
            case R.id.tv_my_gold:
                activity.startActivity(MyGoldActivity.createStartIntent(activity));
                break;
            case R.id.tv_open_door:
                activity.startActivity(GuardActivity.createStartIntent(activity));
                break;
            case R.id.iv_notify:
            case R.id.tv_message:
                activity.startActivity(MessageActivity.createStartIntent(activity));
                break;
            case R.id.rl_treasure_life:
                activity.startActivity(TreasureLifeActivity.createStartIntent(activity));
                break;
            case R.id.tv_gold_mall:
                activity.startActivity(GoldMallActivity.createStartIntent(activity));
                break;
            case R.id.tv_furniture_repairs:
                activity.startActivity(FurnitureRepairsActivity.createStartIntent(activity));
                break;
            case R.id.tv_parking:
                activity.startActivity(ParkingActivity.createStartIntent(activity));
                break;
            case R.id.tv_e_pass:
                activity.startActivity(EPassActivity.createStartIntent(activity));
                break;
            case R.id.tv_opinion:
                activity.startActivity(OpinionActivity.createStartIntent(activity));
                break;
            case R.id.rl_good_life_house:
                activity.startActivity(GoodLifeHouseActivity.createStartIntent(activity));
                break;
            case R.id.rl_house_manager:
                activity.startActivity(HouseManagerActivity.createStartIntent(activity));
                break;
            case R.id.round:
                activity.startActivity(BusinessAreaActivity.createStartIntent(activity));
                break;
        }
    }
}
