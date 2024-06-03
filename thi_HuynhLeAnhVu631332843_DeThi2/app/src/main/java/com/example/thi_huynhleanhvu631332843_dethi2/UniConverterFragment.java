package com.example.thi_huynhleanhvu631332843_dethi2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class UniConverterFragment extends Fragment {

    private EditText inputValue;
    private Spinner inputUnit;
    private Spinner outputUnit;
    private Button convertButton;
    private TextView resultText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_uni_converter, container, false);

        inputValue = view.findViewById(R.id.input_value);
        inputUnit = view.findViewById(R.id.spinner_input);
        outputUnit = view.findViewById(R.id.spinner_output);
        convertButton = view.findViewById(R.id.convert_button);
        resultText = view.findViewById(R.id.result_text);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertUnits();
            }
        });

        return view;
    }

    private void convertUnits() {
        String input = inputValue.getText().toString();
        if (input.isEmpty()) {
            Toast.makeText(getActivity(), "Vui lòng nhập giá trị", Toast.LENGTH_SHORT).show();
            return;
        }

        double value = Double.parseDouble(input);
        String fromUnit = inputUnit.getSelectedItem().toString();
        String toUnit = outputUnit.getSelectedItem().toString();
        double result = 0;

        if (fromUnit.equals("Km") && toUnit.equals("m")) {
            result = value * 1000;
        } else if (fromUnit.equals("Kg") && toUnit.equals("g")) {
            result = value * 1000;
        } else if (fromUnit.equals("Byte") && toUnit.equals("Bit")) {
            result = value * 8;
        } else {
            Toast.makeText(getActivity(), "Đơn vị chuyển đổi không hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }

        resultText.setText("Kết quả: " + result);
    }
}
