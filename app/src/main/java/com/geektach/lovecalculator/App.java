package com.geektach.lovecalculator;

import android.app.Application;

import com.geektach.lovecalculator.network.LoveApi;
import com.geektach.lovecalculator.network.RetrofitService;

public class App extends Application {

    public static LoveApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitService retrofitService = new RetrofitService();
        api = retrofitService.getLoveApi();
    }
}
