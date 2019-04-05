package com.assignment.movieapplication;

import com.assignment.movieapplication.Api.ApiModule;
import com.assignment.movieapplication.Movies.MovieComponent;
import com.assignment.movieapplication.Movies.MovieDetails.MovieDetailsComponent;
import com.assignment.movieapplication.Movies.MovieDetails.MovieDetailsFragment;
import com.assignment.movieapplication.Movies.MovieDetails.MovieDetailsModule;
import com.assignment.movieapplication.Movies.MovieModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {


    void inject(BaseApplication baseApplication);
    MovieComponent newMovieComponent(MovieModule movieModule);
    MovieDetailsComponent newMovieDetailsComponent(MovieDetailsModule movieDetailsModule);

}
