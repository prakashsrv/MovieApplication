package com.assignment.movieapplication;

import com.assignment.movieapplication.Api.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {


    void inject(BaseApplication baseApplication);
}
