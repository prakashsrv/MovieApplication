package com.assignment.movieapplication.Movies;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.assignment.movieapplication.BaseApplication;
import com.assignment.movieapplication.Model.Result;
import com.assignment.movieapplication.R;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment implements Contracts.View {

    @Inject
    MoviePresenter moviePresenter;
    @BindView(R.id.categories_recycler)
    RecyclerView movieRecycler;
    @BindView(R.id.otherevents_layout)
    RelativeLayout othereventsLayout;
    Unbinder unbinder;
    MovieAdapter movieAdapter;


    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApplication) getActivity().getApplication())
                .getAppComponent()
                .newMovieComponent(new MovieModule(this))
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        moviePresenter.fetchMovieList();

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initView() {

    }

    @Override
    public void populateData(List<Result> resultList) {



        movieAdapter = new MovieAdapter(resultList);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        movieRecycler.setLayoutManager(layoutManager2);
        movieRecycler.setItemAnimator(new DefaultItemAnimator());
        movieRecycler.setAdapter(movieAdapter);


    }

    @Override
    public void onError(Throwable throwable) {



        System.out.print(throwable.toString());

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
