package com.assignment.movieapplication.Movies;

import com.assignment.movieapplication.Model.Result;

import java.util.List;

public interface Contracts {

    interface  View{


        void initView();

        void populateData(List<Result>  resultList);


        void onError(Throwable throwable);




    }


    interface Presenter{


        void fetchMovieList();




    }



}
