package com.hongdroid.databindingrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hongdroid.databindingrecyclerview.databinding.Main;
import com.hongdroid.databindingrecyclerview.model.Movie;

public class MainActivity extends AppCompatActivity {

    private ObservableArrayList<Movie> movieList; // 리스트의 변화값을 즉각 반영하기 위해서 옵저러블 리스트 사용

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Main binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);
//        setContentView(R.layout.activity_main);

        movieList = new ObservableArrayList<>();
        binding.rvMain.setAdapter(new MoviesAdapter());
        binding.setMovieList(movieList);

        prepareMovieData();
    }

    /**
     * 리스트 아이템 제거 버튼 리스너 (끝에서 부터 지움)
     * @param view
     */
    public void setDeleteItem(View view) {
        Log.i(getClass().getSimpleName(), "setDeleteItem");
        if (movieList.size() == 0) {
            Toast.makeText(this, "더이상 제거할 아이템이 없습니다..", Toast.LENGTH_SHORT).show();
            return;
        }
        movieList.remove(movieList.size() - 1);
    }

    /**
     * 리스트 아이템 추가 버튼 (최상위에서 부터 추가)
     * @param view
     */
    public void setAddItem(View view) {
        Log.i(getClass().getSimpleName(), "setAddItem");
        movieList.add(0, new Movie("Mad Max: Fury Road", "Action & Adventure", "2015"));
    }

    private void prepareMovieData() {
        movieList.add(new Movie("Mad Max: Fury Road", "Action & Adventure", "2015"));
        movieList.add(new Movie("Inside Out", "Animation, Kids & Family", "2015"));
        movieList.add(new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015"));
        movieList.add(new Movie("Shaun the Sheep", "Animation", "2015"));
    }
}