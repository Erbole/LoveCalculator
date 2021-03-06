package com.geektach.lovecalculator.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.geektach.lovecalculator.network.LoveApi;
import com.geektach.lovecalculator.network.LoveModel;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    LoveApi api;
    final String HOST = "love-calculator.p.rapidapi.com";
    final String KEY = "745b860fc3mshea20254d4d9f2cbp1bfcf7jsn40737c729ffd";

    @Inject
    public Repository(LoveApi loveApi) {
        api = loveApi;
    }

    public MutableLiveData<LoveModel> getData(String first, String second) {
        MutableLiveData<LoveModel> localMutableLiveData = new MutableLiveData<>();
        api.loveCalculate(first, second, HOST, KEY).enqueue(new Callback<LoveModel>() {
            @Override
            public void onResponse(@NonNull Call<LoveModel> call, @NonNull Response<LoveModel> response) {
                if (response.isSuccessful()) {
                    localMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoveModel> call, @NonNull Throwable t) {
                Log.e("ololol", "onFailure: " + t.getMessage());
            }
        });
        return localMutableLiveData;
    }
}
