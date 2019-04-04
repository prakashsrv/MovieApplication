package com.assignment.movieapplication.Movies;

import com.assignment.movieapplication.Api.ApiService;

import dagger.Module;
import dagger.Provides;

@Module
public class MovieModule {

    private final Contracts.View movieView;

    public MovieModule(Contracts.View movieView) {
        this.movieView = movieView;
    }

    @Provides
    @MovieScope
    MoviePresenter provideMovieListPresenter(ApiService apiService) {
        return new MoviePresenter(movieView, apiService);
    }
}