package com.assignment.movieapplication;


import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {


    BaseApplication application;

    AppModule(BaseApplication application)
    {
        this.application=application;
    }

    @Provides
    @Singleton
    BaseApplication provideBaseApplication(){

        return new BaseApplication();
    }
}
