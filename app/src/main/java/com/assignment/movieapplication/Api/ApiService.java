package com.assignment.movieapplication.Api;

import com.assignment.movieapplication.Model.Result;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiService {

    @GET("discover/movie")
    Observable<Result> getMoviesList();




}
