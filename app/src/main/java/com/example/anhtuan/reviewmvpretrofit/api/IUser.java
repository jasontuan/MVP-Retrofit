package com.example.anhtuan.reviewmvpretrofit.api;

import com.example.anhtuan.reviewmvpretrofit.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by ANH TUAN on 2/1/2018.
 */

public interface IUser {

    String BASE_URL = "https://api.github.com/";

    @GET("users")
    Call<List<Users>> getAllUsers();
}
