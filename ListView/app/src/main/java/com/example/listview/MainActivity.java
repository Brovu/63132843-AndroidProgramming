package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edtThongTin;
    private ListView lsvTen;
    private ArrayList<String> listTen;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listTen = new ArrayList<>();
        listTen.add("Vũ");
        listTen.add("Tquynh");
        listTen.add("Cầu Vồng");
        // Khởi tạo EditText và ListView
        edtThongTin = findViewById(R.id.edtThongTin);
        lsvTen = findViewById(R.id.lsvTen);
        // Khởi tạo Adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listTen);
        lsvTen.setAdapter(adapter);
    }

    public void themTen(View view) {
        String tenMoi = edtThongTin.getText().toString();
        if (!tenMoi.isEmpty()) {
            listTen.add(tenMoi);
            adapter.notifyDataSetChanged();
            edtThongTin.setText("");
        }
    }
}
