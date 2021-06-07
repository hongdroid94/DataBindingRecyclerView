package com.hongdroid.databindingrecyclerview;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;

import com.hongdroid.databindingrecyclerview.model.Movie;

public class AdapterBinding {
    @BindingAdapter("bind:item")
    public static void bindItem(RecyclerView recyclerView, ObservableArrayList<Movie> movie) {
        MoviesAdapter adapter = (MoviesAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setItem(movie);
        }
    }
}
