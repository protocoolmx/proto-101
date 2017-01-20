package cool.proto.surf.robolectrictest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        tvResult = (TextView) findViewById(R.id.tvResult);


        // Get result from MainActivity
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String result = bundle.getString("RESULT");
            tvResult.setText("RESULT: " + result);
        }
    }
}
