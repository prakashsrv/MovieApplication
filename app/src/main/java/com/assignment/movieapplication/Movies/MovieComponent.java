package com.assignment.movieapplication.Movies;

import dagger.Subcomponent;

@MovieScope
@Subcomponent(modules = {MovieModule.class})
public interface MovieComponent {
    void inject(MovieFragment movieListFragment);
}