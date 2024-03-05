package com.example.ex5_addsubmuldiv_var;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
2
import com.example.ex5_addsubmuldiv_var.R;

public class MainActivity extends AppCompatActivity {

    private EditText edtA;
    private EditText edtB;
    private EditText edtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtRes = findViewById(R.id.edtRes);
        findViewById(R.id.btnCong).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('+');
            }
        });

        findViewById(R.id.btnTru).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('-');
            }
        });

        findViewById(R.id.btnNhan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('*');
            }
        });

        findViewById(R.id.btnChia).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('/');
            }
        });
    }

 
    private void performOperation(char operator) {
        try {
            double a = Double.parseDouble(edtA.getText().toString());
            double b = Double.parseDouble(edtB.getText().toString());
            double result = 0;

            switch (operator) {
                case '+':
                    result = a + b;
                    break;
                case '-':
                    result = a - b;
                    break;
                case '*':
                    result = a * b;
                    break;
                case '/':
                    if (b != 0) {
                        result = a / b;
                    } else {
                        Toast.makeText(MainActivity.this, "Không thể chia cho 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    break;
            }

            edtRes.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }
}
