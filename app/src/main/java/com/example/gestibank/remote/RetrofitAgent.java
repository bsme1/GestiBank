package com.example.gestibank.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAgent {
    private static Retrofit retrofit = null;

    public static Retrofit getAgent(String url) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
