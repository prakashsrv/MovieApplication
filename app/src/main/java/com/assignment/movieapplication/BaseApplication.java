package com.assignment.movieapplication;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
public class BaseApplication extends Application {

    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();


        appComponent=DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        appComponent.inject(this);

    }



    public AppComponent getAppComponent() {
        return appComponent;
    }

}
