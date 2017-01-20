package cool.proto.surf.robolectrictest;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

/**
 * Created by jonathan on 19/01/17.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class MainActivityRobolectricTest {

    private MainActivity activity;
    private EditText num1, num2;
    private TextView tvNum1, tvNum2;
    private Button btnSubmit;

    @Before
    public void setup() throws Exception {

        activity = Robolectric.buildActivity(MainActivity.class).create().get();

        num1 = (EditText) activity.findViewById(R.id.etNumOne);
        num2 = (EditText) activity.findViewById(R.id.etNumTwo);

        tvNum1 = (TextView) activity.findViewById(R.id.tvNumOne);
        tvNum2 = (TextView) activity.findViewById(R.id.tvNumTwo);

        btnSubmit = (Button) activity.findViewById(R.id.btnSubmit);
    }

    @Test
    public void viewStrings() throws Exception {

        assertTrue("tvNum1 contains incorrect text", tvNum1.getText().equals("Num 1"));
        assertTrue("tvNum2 contains incorrect text", tvNum2.getText().equals(activity.getResources().getString(R.string.str_num_two)));
        assertTrue("btnSubmit contains incorrect text", btnSubmit.getText().equals(activity.getResources().getString(R.string.str_submit)));
    }

    @Test
    public void sumTwoNumbers() throws Exception {

        int value1 = 5;
        int value2 = 6;

        // Sum these numbers
        String valueExpected = Integer.toString(value1 + value2);

        // Set values in EditText
        setValues(value1, value2);


        // Sum these numbers
        String sumExpected = activity.sum();

        assertTrue("Result is incorrect", sumExpected.equals(valueExpected));
    }

    @Test
    public void calculate() throws Exception {

        int value1 = 10;
        int value2 = 10;

        // Sum these numbers
        String valueExpected = Integer.toString(value1 + value2);

        // Set values in EditText
        setValues(value1, value2);

        btnSubmit.performClick();

        // The intent we expect to be launched when a user clicks on the btnSubmit
        Intent expectedIntent = new Intent(activity, ResultActivity.class);

        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        Intent routeDetailIntent = shadowActivity.getNextStartedActivity();

        // Assert True if btnSubmit Click show the ResultActivity
        assertTrue("Intent expected is incorrect", routeDetailIntent.filterEquals(expectedIntent));

        // Get result from ResultActivity
        Bundle bundle = routeDetailIntent.getExtras();

        String result = bundle.getString("RESULT");

        assertTrue("Parameter is incorrect", result.equals(valueExpected));
    }


    public void setValues(int value1, int value2) {
        // Add values
        num1.setText(value1 + "");
        num2.setText(value2 + "");
    }

}
