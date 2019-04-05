package com.assignment.movieapplication.Movies.MovieDetails;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.assignment.movieapplication.BaseApplication;
import com.assignment.movieapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailsFragment extends Fragment implements Contracts.View {


    public MovieDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApplication)getActivity().getApplication()).getAppComponent()
                .newMovieDetailsComponent(new MovieDetailsModule(this))
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_movie_details, container, false);
        return view;




    }

}
