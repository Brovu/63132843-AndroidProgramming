package ntu_63132843.cau2_ungdungdongho;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StopwatchFragment extends Fragment {

    private TextView stopwatchDisplay;
    private Button startButton, resetButton;
    private Handler handler = new Handler();
    private int seconds = 0;

    private Runnable updateTimer = new Runnable() {
        @Override
        public void run() {
            seconds++;
            int hours = seconds / 3600;
            int minutes = (seconds % 3600) / 60;
            int secs = seconds % 60;

            stopwatchDisplay.setText(String.format("%02d:%02d:%02d", hours, minutes, secs));
            handler.postDelayed(this, 1000);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stopwatch, container, false);

        stopwatchDisplay = view.findViewById(R.id.stopwatch_display);
        startButton = view.findViewById(R.id.start_button);
        resetButton = view.findViewById(R.id.reset_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startButton.getText().equals("Start")) {
                    startButton.setText("Stop");
                    handler.post(updateTimer);
                } else {
                    startButton.setText("Start");
                    handler.removeCallbacks(updateTimer);
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startButton.setText("Start");
                handler.removeCallbacks(updateTimer);
                seconds = 0;
                stopwatchDisplay.setText("00:00:00");
            }
        });

        return view;
    }
}
