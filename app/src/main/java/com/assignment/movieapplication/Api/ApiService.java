package com.assignment.movieapplication.Api;

import com.assignment.movieapplication.Model.DiscoverResponse;
import com.assignment.movieapplication.Model.Result;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiService {

    @GET("discover/movie?api_key=21642e7bd66fbfce8376d2d3c5b2272c&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    Observable<DiscoverResponse>getMoviesList();




}
