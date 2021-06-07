package com.hongdroid.databindingrecyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hongdroid.databindingrecyclerview.databinding.ListItemMovieBinding;
import com.hongdroid.databindingrecyclerview.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<Movie> movieList;

    MoviesAdapter() {
        this.movieList = new ArrayList<>();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemMovieBinding binding = ListItemMovieBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.bind(movie);
    }

    void setItem(List<Movie> movie) {
        if (movie == null)
            return;
        this.movieList = movie;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ListItemMovieBinding binding;
        public ViewHolder(ListItemMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        void bind(Movie movie) {
            binding.setVariable(BR.movie, movie);
        }
    }
}
