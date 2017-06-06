package com.zoesap.goodlife.util;

import android.widget.Toast;

import com.zoesap.goodlife.GoodLifeApplication;

/**
 * Created by maoqi on 2017/5/31.
 * Toast工具类
 */

public class TUtils {
    private TUtils()
    {
		/* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isShow = true;

    /**
     * 短时间显示Toast
     *
     * @param message
     */
    public static void showShort(CharSequence message)
    {
        if (isShow)
            Toast.makeText(GoodLifeApplication.appContext, message, Toast.LENGTH_SHORT).show();
    }

    public static void showShort(int message)
    {
        if (isShow)
            Toast.makeText(GoodLifeApplication.appContext, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 长时间显示Toast
     * @param message
     */
    public static void showLong(CharSequence message)
    {
        if (isShow)
            Toast.makeText(GoodLifeApplication.appContext, message, Toast.LENGTH_LONG).show();
    }

    public static void showLong(int message)
    {
        if (isShow)
            Toast.makeText(GoodLifeApplication.appContext, message, Toast.LENGTH_LONG).show();
    }
}
