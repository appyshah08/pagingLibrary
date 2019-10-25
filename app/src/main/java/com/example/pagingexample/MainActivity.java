package com.example.pagingexample;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pagingexample.adapter.UserAdapter;
import com.example.pagingexample.model.User;
import com.example.pagingexample.viewmodel.SampleDoc;
import com.example.pagingexample.viewmodel.UserViewModel;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import static com.google.gson.reflect.TypeToken.get;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
         UserAdapter adapter = new UserAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        UserViewModel userViewModel= ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.userPagedList.observe(this, new Observer<PagedList<User>>() {
            @Override public void onChanged(PagedList<User> users) {
                adapter.submitList(users);
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
