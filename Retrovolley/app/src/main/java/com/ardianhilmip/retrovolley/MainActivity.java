package com.ardianhilmip.retrovolley;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ardianhilmip.retrovolley.retrofit.activity.RetrofitActivity;
import com.ardianhilmip.retrovolley.volley.LoginVolleyActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void actionRetrofit(View view) {
        Intent retro = new Intent(this, RetrofitActivity.class);
        startActivity(retro);
    }

    public void actionVolley(View view) {
        Intent volley = new Intent(this, LoginVolleyActivity.class);
        startActivity(volley);
    }
}