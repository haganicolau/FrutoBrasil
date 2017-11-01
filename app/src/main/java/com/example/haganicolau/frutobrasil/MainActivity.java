package com.example.haganicolau.frutobrasil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent it = new Intent(this, LoginActivity.class);
        startActivity(it);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
