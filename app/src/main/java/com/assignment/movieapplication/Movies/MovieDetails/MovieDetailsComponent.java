package com.assignment.movieapplication.Movies.MovieDetails;


import dagger.Component;
import dagger.Subcomponent;


@MovieDetailsScope
@Subcomponent(modules = MovieDetailsModule.class)
public interface MovieDetailsComponent {


    void inject(MovieDetailsFragment movieDetailsFragment);






}
