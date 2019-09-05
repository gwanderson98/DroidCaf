package com.example.droidcaf.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.droidcaf.entidades.Products;
import com.example.droidcaf.service.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView campo;

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buscaDados();
    }

    private void buscaDados() {
        RetrofitService.getServico().obterProdutos().enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                List<Products> lista = response.body();
                for (Products products : lista) {
                    campo.append("Nome: " + products.getName() +
                            "\nDescricao: " + products.getDescription()+
                            "\nValor: " + products.getPrice() );
                }
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                Log.e("RestApp", t.getStackTrace().toString());
            }
        });
    }

    public void navegar(View view) {
        startActivity(new Intent(this, PostActivity.class));
    }
}