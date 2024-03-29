package com.example.pagingexample.service;

import com.example.pagingexample.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("users")
    Call<UserResponse> getUsers(@Query("page") long page);

}
