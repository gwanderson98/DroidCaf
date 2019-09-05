package com.example.droidcaf.service;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private String baseUrl = "http://angoti.atwebpages.com/droidcafe";
    private ApiEndPoint api;
    private static RetrofitService instancia;
    private Gson gson;

    private RetrofitService() {

        api = criaRetrofit().create(ApiEndPoint.class);
    }

    public static ApiEndPoint getServico() {
        if (instancia == null)
            instancia = new RetrofitService();
        return instancia.api;
    }

    private Retrofit criaRetrofit() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();
    }
}

