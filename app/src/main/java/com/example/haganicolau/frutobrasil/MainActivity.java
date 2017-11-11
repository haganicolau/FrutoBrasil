package com.example.haganicolau.frutobrasil;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import util.Database;

public class MainActivity extends AppCompatActivity {

    Database db = new Database(this);
    String token;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        token = db.recoverToken();
        if(token == null) {
            Intent it = new Intent(this, LoginActivity.class);
            startActivity(it);
        }

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.containerMap,
                new MapsFragment(),
                "MapsFragment");

        fragmentTransaction.commitAllowingStateLoss();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
}
