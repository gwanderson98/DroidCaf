package com.example.droidcaf.service;

import com.example.droidcaf.entidades.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiEndPoint {
    @GET("products")
    Call<List<Products>> obterProdutos();

    @POST("products")
    Call<Products> createPost(@Body Products post);
}
