package com.zoesap.goodlife;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by maoqi on 2017/5/31.
 */

public class GoodLifeApplication extends Application {
    public static Context appContext;
    //维护一个线程池
    public static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
    //当前list列表
    private static List<Activity> activityList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
        ZXingLibrary.initDisplayOpinion(this);
    }

    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    private static void finishAllActivity() {
        for (Activity activity : activityList)
            activity.finish();
    }

    public static void exitApp() {
        finishAllActivity();
        System.exit(0);
    }
}
