package com.example.recycleviewexam;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.List;

public class ExamActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageGalleryAdapter2 adapter;
    RecyclerView recyclerView;
    ClickListiner listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        List<examData> list = getData();

        recyclerView = findViewById(R.id.recyclerView);
        listener = new ClickListiner() {
            @Override
            public void click(int index) {
                Toast.makeText(ExamActivity.this, "clicked item index is " + index, Toast.LENGTH_LONG).show();
            }
        };
        adapter = new ImageGalleryAdapter2(list, getApplication(), listener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    // Sample data for RecyclerView
    private List<examData> getData() {
        List<examData> list = new ArrayList<>();
        list.add(new examData("Giữa kì", "Ngày 25/3/2024", "Best Of Luck"));
        list.add(new examData("Cuối kì", "Ngày 13/5/2024", "b of l"));
        list.add(new examData("Kiểm tra", "Ngày 20/4/2024", "This is testing exam .."));
        return list;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Xử lý các sự kiện khi người dùng chọn các mục trong NavigationView
        return true;
    }
}
