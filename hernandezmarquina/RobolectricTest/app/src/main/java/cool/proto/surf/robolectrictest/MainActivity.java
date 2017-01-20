package cool.proto.surf.robolectrictest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNumOne, etNumTwo;
    Button btnSubmit;
    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumOne = (EditText) findViewById(R.id.etNumOne);
        etNumTwo = (EditText) findViewById(R.id.etNumTwo);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);

        calculator = new Calculator();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("RESULT", sum());
        startActivity(intent);
    }

    public String sum() {
        return calculator.sum(Integer.parseInt(etNumOne.getText().toString()), Integer.parseInt(etNumTwo.getText().toString()));
    }

}