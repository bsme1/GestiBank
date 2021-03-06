package com.example.gestibank.remote;

import com.example.gestibank.models.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AuthService {
    @GET("users/{email}")
    Call<User> getUserByEmail(@Path("email") String email);
}
