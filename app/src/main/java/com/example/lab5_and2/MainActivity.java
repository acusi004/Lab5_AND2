package com.example.lab5_and2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    DrawerLayout daDrawerLayout;

    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        daDrawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigationview);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, daDrawerLayout, toolbar, R.string.open, R.string.close);
        daDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                if (item.getItemId() == R.id.home){
                    toolbar.setTitle("trang chu");
                    fragment = new BlankFragment_trangchu();
                }else if (item.getItemId() == R.id.bookmark){
                    toolbar.setTitle("dau trang");
                    fragment = new BlankFragment_dautrang();
                }else{
                    toolbar.setTitle("cai dat");
                    fragment = new BlankFragmentcaidat();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fragment).commit();
                daDrawerLayout.close();
                return true;
            }
        });


    }
}