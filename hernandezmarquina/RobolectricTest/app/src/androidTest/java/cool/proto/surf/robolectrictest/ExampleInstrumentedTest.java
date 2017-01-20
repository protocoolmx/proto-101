package cool.proto.surf.robolectrictest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity activity;
    private EditText num1, num2;

    public ExampleInstrumentedTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        activity = getActivity();
    }

    @Test
    public void useAppContext() throws Exception {

        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("cool.proto.surf.robolectrictest", appContext.getPackageName());
    }


    @Test
    public void testDefaultValues() {

        num1 = (EditText) activity.findViewById(R.id.etNumOne);
        num2 = (EditText) activity.findViewById(R.id.etNumTwo);

        assertNotNull(num1);
        assertNotNull(num2);

        assertTrue("op1 is not 0 by default", num1.getText().toString().equals("0"));
        assertTrue("op2 is not 0 by default", num2.getText().toString().equals("0"));
    }
}
