package com.android.chucky.health.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DataService {

    @POST("/auth/register/")
    Call<User> signUp(@Body User user);

    @POST("/auth/jwt-api-token/")
    Call<User> login(@Body User user);

    @GET("/disasters/")
    Call<List<Disease>> getPossibleDisease(@Header ("token") String token,@Query("lat") double lat, @Query("lang") double lang);

}
