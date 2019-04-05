package com.assignment.movieapplication.Movies.MovieDetails;


import com.assignment.movieapplication.Api.ApiService;

import dagger.Module;
import dagger.Provides;

@Module
public class MovieDetailsModule {



    private Contracts.View contraView;


    MovieDetailsModule(Contracts.View view)
    {
        this.contraView=view;
    }



    @Provides
    @MovieDetailsScope
    MoviePresenter getMoviePresenter(ApiService apiService)
    {
        return new MoviePresenter(contraView,apiService);
    }


}
