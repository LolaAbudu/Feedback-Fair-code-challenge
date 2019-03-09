package org.pursuit.feedbackfaircodechallenge.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private static Retrofit oneInstance;

    public static Retrofit getOneInstance() {
        if (oneInstance != null) {
            return oneInstance;
        }
        oneInstance = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        return oneInstance;
    }

    private RetrofitSingleton() {
    }
}
