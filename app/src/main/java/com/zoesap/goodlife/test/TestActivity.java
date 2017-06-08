package com.zoesap.goodlife.test;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.zoesap.goodlife.R;
import com.zoesap.goodlife.adapter.SpacesItemDecoration;
import com.zoesap.goodlife.base.BaseToolbarActivity;
import com.zoesap.goodlife.model.bean.RechargeHistoryBean;
import com.zoesap.goodlife.util.DensityUtils;
import com.zoesap.goodlife.util.TimerUtils;
import com.zoesap.goodlife.view.LoadMoreRecyclerView.LoadMoreScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends BaseToolbarActivity {

    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tb_toolbar)
    Toolbar tbToolbar;
    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout srlRefresh;


    private boolean isLoading = false;
    private List<RechargeHistoryBean> data = new ArrayList<>();
    private RechargeHistoryBean bean;
    private int num = 0;
    private TestAdapter adapter;
    private LoadMoreScrollListener listener;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_recharge_history);
        ButterKnife.bind(this);
        initRefreshLayout();
        initToolbar(tbToolbar);
        tvTitle.setText(R.string.recharge_history);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        adapter = new TestAdapter(this, data, true);
        listener = new LoadMoreScrollListener(manager) {
            @Override
            public void onLoadMore(int currentPage) {
                if (!srlRefresh.isRefreshing()){
                    isLoading = true;
                    if (num++ < 1) {
                        adapter.setHasMoreData(true);
                        TimerUtils.getInstance().addTimerTask(new Runnable() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        initData();
                                        adapter.notifyDataSetChanged();
                                        isLoading = false;
                                    }
                                });
                            }
                        }, 2000);
                    } else {
                        adapter.setHasMoreData(false);
                        adapter.notifyDataSetChanged();
                        isLoading = false;
                    }
                }
            }
        };
        rvList.setLayoutManager(manager);
        rvList.addItemDecoration(new SpacesItemDecoration(DensityUtils.dp2px(this, 5)));
        rvList.addOnScrollListener(listener);
        rvList.setAdapter(adapter);
    }

    private void initRefreshLayout() {
        srlRefresh.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        srlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (!isLoading){
                    TimerUtils.getInstance().addTimerTask(new Runnable() {
                        @Override
                        public void run() {
                            data.clear();
                            num = 0;
                            adapter.setHasMoreData(true);
                            listener.setPreviousTotal(0);
                            initData();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    adapter.notifyDataSetChanged();
                                    srlRefresh.setRefreshing(false);
                                }
                            });
                        }
                    }, 2000);
                }else {
                    srlRefresh.setRefreshing(false);
                }
            }
        });
    }

    @Override
    protected void initData() {
        for (int x = 0; x < 10; x++) {
            bean = new RechargeHistoryBean("充值中" + x, "10.22", "充值号码 : 1523365974412", "下单时间 : 2017-6-5");
            data.add(bean);
        }
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
        Intent intent = new Intent(activity, TestActivity.class);
        return intent;
    }

}
