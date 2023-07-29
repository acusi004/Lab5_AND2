package com.example.lab5_and2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MenuBottom extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_bottom);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                if (item.getItemId() == R.id.chat){
                    fragment = new BlankFragment_trangchu();
                }else if(item.getItemId()==R.id.map){
                    fragment = new BlankFragment_dautrang();
                }else{
                    fragment = new BlankFragmentcaidat();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout2, fragment).commit();
                return true;

            }
        });

    }
}