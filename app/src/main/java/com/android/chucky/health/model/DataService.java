package com.android.chucky.health.model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface DataService {

    @POST("/auth/register/")
    Call<User> signUp(@Body User user);

    @POST("/auth/jwt-api-token/")
    Call<User> login(@Body User user);
}
