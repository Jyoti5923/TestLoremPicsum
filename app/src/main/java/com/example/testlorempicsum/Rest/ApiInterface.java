package com.example.testlorempicsum.Rest;

import com.example.testlorempicsum.Model.Picsum;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("list")
    Call<List<Picsum>> getPicsum();
}
