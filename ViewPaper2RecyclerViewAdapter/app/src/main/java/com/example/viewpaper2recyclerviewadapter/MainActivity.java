package com.example.viewpaper2recyclerviewadapter;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> viewPPDatas;
    ViewPager2 viewPager2Land;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPPDatas = getRecyclerViewPaper();
        viewPager2Land = findViewById(R.id.vpland2);
        landScapeAdapter = new LandScapeAdapter(this, viewPPDatas);
        viewPager2Land.setAdapter(landScapeAdapter);
        viewPager2Land.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    ArrayList<LandScape> getRecyclerViewPaper() {
        ArrayList<LandScape> dsDuLieu = new ArrayList<>();
        dsDuLieu.add(new LandScape("thaptokyo", "Tháp Tokyo"));
        dsDuLieu.add(new LandScape("thapnghieng", "Tháp Nghiêng"));
        dsDuLieu.add(new LandScape("chualongson", "Tượng Phật Trắng"));
        dsDuLieu.add(new LandScape("thaptokyo", "Tháp Tokyo"));
        dsDuLieu.add(new LandScape("thapnghieng", "Tháp Nghiêng"));
        dsDuLieu.add(new LandScape("chualongson", "Tượng Phật Trắng"));
        return dsDuLieu;
    }
}