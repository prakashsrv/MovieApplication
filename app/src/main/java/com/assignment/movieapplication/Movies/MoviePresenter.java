package com.assignment.movieapplication.Movies;

import com.assignment.movieapplication.Api.ApiService;
import com.assignment.movieapplication.Constants;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MoviePresenter {
    private Contracts.View movieView;


    private ApiService apiService;


    public MoviePresenter(Contracts.View movieView, ApiService apiService) {

        this.movieView = movieView;
        this.apiService = apiService;

    }


    private void fetchMovieList() {

        apiService.getMoviesList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(movieView::populateData, movieView::onError);

    }
}
