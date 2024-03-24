package ntu_63132843.cau2_ungdungdongho;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.activity.EdgeToEdge;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private TextView hourDisplay;
    private TextView minuteDisplay;
    private TextView secondDisplay;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        hourDisplay = findViewById(R.id.hour_display);
        minuteDisplay = findViewById(R.id.minute_display);
        secondDisplay = findViewById(R.id.second_display);

        updateTime();

        StopwatchFragment stopwatchFragment = new StopwatchFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, stopwatchFragment);
        transaction.commit();
    }

    private void updateTime() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat sdfHour = new SimpleDateFormat("HH", Locale.getDefault());
                SimpleDateFormat sdfMinute = new SimpleDateFormat("mm", Locale.getDefault());
                SimpleDateFormat sdfSecond = new SimpleDateFormat("ss", Locale.getDefault());

                String currentHour = sdfHour.format(new Date());
                String currentMinute = sdfMinute.format(new Date());
                String currentSecond = sdfSecond.format(new Date());

                hourDisplay.setText(currentHour);
                minuteDisplay.setText(currentMinute);
                secondDisplay.setText(currentSecond);

                updateTime(); // Lặp lại sau mỗi giây
            }
        }, 1000); // Mỗi giây
    }
}
