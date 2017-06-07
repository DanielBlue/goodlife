package com.zoesap.goodlife.base;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.zoesap.goodlife.GoodLifeApplication;
import com.zoesap.goodlife.R;
import com.zoesap.goodlife.util.LUtils;

/**
 * Created by maoqi on 2017/5/31.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog loadingDialog;
    private AlertDialog.Builder builder;

    protected abstract void initView();
    protected abstract void initData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GoodLifeApplication.addActivity(this);
        LUtils.d("BaseActivity", getClass().getSimpleName());
        initData();
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GoodLifeApplication.removeActivity(this);
    }

    //----------------dialog相关--------------------//

    protected AlertDialog.Builder createDialogBuilder(String title, String message, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, listener)
                .setCancelable(false)
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        return builder;
    }

    protected AlertDialog.Builder createDialogBuilder(String title, DialogInterface.OnClickListener listener) {
        return createDialogBuilder(title, "", listener);
    }

    protected AlertDialog.Builder createDialogBuilder(String title) {
        builder = new AlertDialog.Builder(this)
                .setTitle(title)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(false);
        return builder;
    }

    protected ProgressDialog createLoadingDialog(){
        loadingDialog = new ProgressDialog(this);
        loadingDialog.setCanceledOnTouchOutside(false);
        return loadingDialog;
    }

    protected ProgressDialog createProgressDialog(String message){
        createLoadingDialog().setMessage(message);
        return loadingDialog;
    }

    protected ProgressDialog createProgressDialog(@StringRes int message){
        createLoadingDialog().setMessage(getResources().getString(message));
        return loadingDialog;
    }

    protected void progressLoading(){
        createLoadingDialog().show();
    }

    protected void progressDismiss(){
        if (loadingDialog!=null&&loadingDialog.isShowing()){
            loadingDialog.dismiss();
        }
    }

    //----------------dialog相关--------------------//


}
