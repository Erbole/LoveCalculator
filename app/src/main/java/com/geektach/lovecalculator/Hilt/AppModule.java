package com.geektach.lovecalculator.Hilt;

import com.geektach.lovecalculator.Prefs;
import com.geektach.lovecalculator.network.LoveApi;
import com.geektach.lovecalculator.repository.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public LoveApi provideApi() {
        return new Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(LoveApi.class);
    }

    @Provides
    public Repository provideRepository() {
        return new Repository(provideApi());
    }

    @Provides
    @Singleton
    public Prefs providePrefs() {
        return new Prefs();
    }
}
