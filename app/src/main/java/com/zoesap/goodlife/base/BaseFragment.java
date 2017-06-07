package com.zoesap.goodlife.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zoesap.goodlife.util.LUtils;

/**
 * Created by maoqi on 2017/6/2.
 */

public abstract class BaseFragment extends Fragment {
    protected AppCompatActivity activity;

    protected abstract void initData();

    protected abstract View initView(LayoutInflater inflater);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LUtils.d("BaseFragment", getClass().getSimpleName());
        activity = (AppCompatActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initData();
        return initView(inflater);
    }
}
