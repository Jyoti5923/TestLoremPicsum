package com.example.testlorempicsum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testlorempicsum.Model.Picsum;
import com.example.testlorempicsum.Rest.ApiClient;
import com.squareup.picasso.Picasso;

public class PicsumDetailsActivity extends AppCompatActivity {
    TextView tvAuther;
    ImageView imageView;
    Picsum picsum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picsum_details);

        tvAuther = findViewById(R.id.tv_Author);
        imageView = findViewById(R.id.img_Detail);

        picsum = (Picsum) getIntent().getSerializableExtra("data");

        if (picsum!=null)
        {
            tvAuther.setText(picsum.getAuthor());
            Picasso.get().load(ApiClient.BASE_URL + "300/300?image=" + picsum.getId()).placeholder(R.drawable.ic_android_black_24dp).into(imageView);
        }
    }

}

