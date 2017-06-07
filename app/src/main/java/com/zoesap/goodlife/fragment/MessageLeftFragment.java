package com.zoesap.goodlife.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.zoesap.goodlife.base.BaseFragment;
import com.zoesap.goodlife.R;
import com.zoesap.goodlife.adapter.MessageListAdapter;
import com.zoesap.goodlife.adapter.SpacesItemDecoration;
import com.zoesap.goodlife.model.bean.NotifyMessageBean;
import com.zoesap.goodlife.util.DensityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 毛琦 on 2017/6/3.
 */

public class MessageLeftFragment extends BaseFragment {
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    Unbinder unbinder;

    List<NotifyMessageBean> data = new ArrayList<>();

    @Override
    protected void initData() {
        NotifyMessageBean bean ;
        for (int x=0;x<30;x++){
            bean = new NotifyMessageBean("标题"+x,"2017-6-3","00000000000000000000000000000000000000000000000000");
            data.add(bean);
        }
    }

    @Override
    protected View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_message_left, null);
        unbinder = ButterKnife.bind(this, view);
        rvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvList.addItemDecoration(new SpacesItemDecoration(DensityUtils.dp2px(getActivity(),10),0));
        rvList.setAdapter(new MessageListAdapter(data));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
