package com.dbeqiraj.testapp.http_rest_utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by d.beqiraj on 10/26/2016.
 */
public class ApiClient {
    private static APIPlug REST_CLIENT;
    private static final String API_URL = "http://jsonplaceholder.typicode.com/";

    static {
        setupRestClient();
    }

    private ApiClient() {}

    public static APIPlug get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        REST_CLIENT = retrofit.create(APIPlug.class);
    }
}