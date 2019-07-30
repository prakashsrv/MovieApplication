package com.assignment.movieapplication.Movies.MovieDetails;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.assignment.movieapplication.Constants;
import com.assignment.movieapplication.Model.Result;
import com.assignment.movieapplication.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailsActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;


    @BindView(R.id.container)
    LinearLayout container;
    @BindView(R.id.overviewHeader)
    TextView overviewHeader;
    @BindView(R.id.overviewTextView)
    TextView overviewTextView;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.rating)
    TextView rating;
    @BindView(R.id.votes_total)
    TextView votesTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        ButterKnife.bind(this);

        Result result = getIntent().getExtras().getParcelable("movieDetails");

        putData(result);
    }


    void putData(Result result) {

        Glide.with(this).load(Constants.IMAGE_URL_BASE + result.getPosterPath())
                .apply(new RequestOptions()
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .dontAnimate())
                .into(imageView);

        overviewTextView.setText(result.getOverview());

        votesTotal.setText(String.valueOf(result.getVoteCount()));
        rating.setText(String.valueOf(result.getVoteAverage()));


    }
}
