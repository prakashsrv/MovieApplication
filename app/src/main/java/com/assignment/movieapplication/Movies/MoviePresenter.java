package com.assignment.movieapplication.Movies;

import android.annotation.SuppressLint;

import com.assignment.movieapplication.Api.ApiService;
import com.assignment.movieapplication.Constants;
import com.assignment.movieapplication.Model.DiscoverResponse;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MoviePresenter implements Contracts.Presenter {
    private Contracts.View movieView;


    private ApiService apiService;


    public MoviePresenter(Contracts.View movieView, ApiService apiService) {

        this.movieView = movieView;
        this.apiService = apiService;

    }




    @SuppressLint("CheckResult")
    @Override
    public void fetchMovieList() {

        apiService.getMoviesList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(DiscoverResponse::getResults)
                .subscribe(movieView::populateData, movieView::onError);

    }
}
