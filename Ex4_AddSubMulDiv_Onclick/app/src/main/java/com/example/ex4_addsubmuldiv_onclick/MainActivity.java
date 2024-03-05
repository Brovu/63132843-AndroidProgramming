package com.example.ex4_addsubmuldiv_onclick;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtA;
    private EditText edtB;
    private EditText edtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các EditText
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtRes = findViewById(R.id.edtRes);
    }

    public void cong(View view) {
        double a = Double.parseDouble(edtA.getText().toString());
        double b = Double.parseDouble(edtB.getText().toString());
        double result = a + b;
        edtRes.setText(String.valueOf(result));
    }

    public void tru(View view) {
        double a = Double.parseDouble(edtA.getText().toString());
        double b = Double.parseDouble(edtB.getText().toString());
        double result = a - b;
        edtRes.setText(String.valueOf(result));
    }

    public void nhan(View view) {
        double a = Double.parseDouble(edtA.getText().toString());
        double b = Double.parseDouble(edtB.getText().toString());
        double result = a * b;
        edtRes.setText(String.valueOf(result));
    }

    public void chia(View view) {
        double a = Double.parseDouble(edtA.getText().toString());
        double b = Double.parseDouble(edtB.getText().toString());
        if (b != 0) {
            double result = a / b;
            edtRes.setText(String.valueOf(result));
        } else {
            edtRes.setText("Không thể chia cho 0");
        }
    }
}
