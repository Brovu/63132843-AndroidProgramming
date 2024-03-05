package com.example.ex3_simplesumapp;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void XuLyCong(View view){
        EditText editTextA = findViewById(R.id.edtA);
        EditText editTextB = findViewById(R.id.edtB);
        EditText editTextRes = findViewById(R.id.edtRes);

        String strA = editTextA.getText().toString();
        String strB = editTextB.getText().toString();

        int a = Integer.parseInt(strA);
        int b = Integer.parseInt(strB);

        int sum = a+b;

        String strSum = String.valueOf(sum);

        editTextRes.setText(strSum);
    }
}