package com.zoesap.goodlife.model.net;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.zoesap.goodlife.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/5/5.
 */

public class RetrofitHelper {
    private static RetrofitHelper helper;
    private Context context;

    private RetrofitHelper(Context context) {
        this.context = context;
    }

    public static RetrofitHelper getInstance(Context context) {
        if (helper == null) {
            helper = new RetrofitHelper(context);
        }
        return helper;
    }

    /**
     * 默认BaseUrl为/new/
     */
    public <T> T simpleRequest(Class<T> serviceClass) {
        return simpleRequest(Constants.BaseUrl, serviceClass);
    }

    public <T> T simpleRequest(String baseUrl, Class<T> serviceClass) {

        OkHttpClient client = setClient();
        Retrofit retrofit = simpleBuilder(baseUrl, client)
                .build();
        T t = retrofit.create(serviceClass);
        return t;
    }

    private Retrofit.Builder simpleBuilder(String baseUrl, OkHttpClient client) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client);
        return builder;
    }

    public <T> T RxJavaRequest(String baseUrl, Class<T> serviceClass) {

        OkHttpClient client = setClient();
        Retrofit retrofit = RxJavaBuilder(baseUrl, client)
                .build();
        T t = retrofit.create(serviceClass);
        return t;
    }

    public <T> T RxJavaRequest(Class<T> serviceClass) {

        OkHttpClient client = setClient();
        Retrofit retrofit = RxJavaBuilder(Constants.BaseUrl, client)
                .build();
        T t = retrofit.create(serviceClass);
        return t;
    }

    private Retrofit.Builder RxJavaBuilder(String baseUrl, OkHttpClient client) {

        return simpleBuilder(baseUrl, client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }


    private OkHttpClient setClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new SaveCookiesInterceptor(context))
                .addInterceptor(new AddCookiesInterceptor(context))
                .build();
        return client;
    }
}
