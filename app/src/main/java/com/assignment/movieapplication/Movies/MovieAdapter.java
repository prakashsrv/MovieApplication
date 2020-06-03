package com.assignment.movieapplication.Movies;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.assignment.movieapplication.Constants;
import com.assignment.movieapplication.Model.Result;
import com.assignment.movieapplication.Movies.MovieDetails.MovieDetailsActivity;
import com.assignment.movieapplication.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    List<Result> data;
    Context context;



    public MovieAdapter(List<Result>  data) {
        this.data = data;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.movie_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(holder.itemView.getContext()).load(Constants.IMAGE_URL_BASE+data.get(holder.getAdapterPosition()).getPosterPath())
                .apply(new RequestOptions()
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .dontAnimate())
                .into(holder.movieImage);

        holder.title.setText(data.get(holder.getAdapterPosition()).getTitle());

        context=holder.itemView.getContext();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //moviedetailstest
                Intent i=new Intent(context, MovieDetailsActivity.class);
                i.putExtra("movieDetails",data.get(holder.getAdapterPosition()));
                context.startActivity(i);


            }
        });




        System.out.print(data.get(position).getTitle());



    }

    @Override
    public int getItemCount() {
        return data.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movieImage)
        ImageView movieImage;
        @BindView(R.id.title)
        TextView title;



        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            ButterKnife.bind(this, itemView);


        }
    }
}
