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

    }
}