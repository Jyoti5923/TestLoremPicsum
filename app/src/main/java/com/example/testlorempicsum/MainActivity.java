package com.example.testlorempicsum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.testlorempicsum.Adapter.PicsumAdapter;
import com.example.testlorempicsum.Model.Picsum;
import com.example.testlorempicsum.Rest.ApiClient;
import com.example.testlorempicsum.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Context context;
    RecyclerView rvRecycler;
    ArrayList<Picsum> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvRecycler= findViewById(R.id.recycler);
        rvRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        rvRecycler.setHasFixedSize(true);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Picsum>> call = apiInterface.getPicsum();
        call.enqueue(new Callback<List<Picsum>>() {

            @Override
            public void onResponse(Call<List<Picsum>> call, Response<List<Picsum>> response) {
                arrayList = new ArrayList<>(response.body());
                PicsumAdapter picsumAdapter = new PicsumAdapter(MainActivity.this,arrayList);
                rvRecycler.setAdapter(picsumAdapter);
            }
            @Override
            public void onFailure(Call<List<Picsum>> call, Throwable t) {

            }
        });
    }
}