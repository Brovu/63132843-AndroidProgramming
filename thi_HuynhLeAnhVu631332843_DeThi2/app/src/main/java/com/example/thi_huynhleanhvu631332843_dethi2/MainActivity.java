package com.example.thi_huynhleanhvu631332843_dethi2;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    WelcomeFragment welcomeFragment = new WelcomeFragment();
    UniConverterFragment uniConverterFragment = new UniConverterFragment();

    WelknownCoffeeFragment welknownCoffeeFragment = new WelknownCoffeeFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, welcomeFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.welcome_fragment) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, welcomeFragment).commit();
                    return true;
                } else if (itemId == R.id.uniconverter_fragment) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, uniConverterFragment).commit();
                    return true;
                } else if (itemId == R.id.welknowncoffe_fragment) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, welknownCoffeeFragment).commit();
                    return true;
                }
                return false;
            }
        });
    }
}