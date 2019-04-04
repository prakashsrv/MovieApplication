package com.assignment.movieapplication.Movies;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.assignment.movieapplication.BaseApplication;
import com.assignment.movieapplication.Model.Result;
import com.assignment.movieapplication.R;

import dagger.Component;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment implements Contracts.View {


    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApplication)getActivity().getApplication())
                .getAppComponent()
                .newMovieComponent(new MovieModule(this))
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_movie, container, false);

        return view;
    }

    @Override
    public void initView() {

    }

    @Override
    public void populateData(Result resultList) {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
