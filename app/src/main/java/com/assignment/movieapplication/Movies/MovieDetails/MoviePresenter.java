package com.assignment.movieapplication.Movies.MovieDetails;

import com.assignment.movieapplication.Api.ApiService;

public class MoviePresenter implements Contracts.Presenter{

    private Contracts.View contraview;

    ApiService apiService;



    MoviePresenter(Contracts.View contraview,ApiService apiService)
    {
        this.contraview=contraview;
        this.apiService=apiService;
    }


}
