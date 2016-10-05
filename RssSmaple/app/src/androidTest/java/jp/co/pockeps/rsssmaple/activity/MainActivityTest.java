package jp.co.pockeps.rsssmaple.activity;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;


@RunWith(AndroidJUnit4.class)
@SmallTest
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void validateListItem() throws Throwable {
        onData(anything()).inAdapterView(withId(android.R.id.list))
                .atPosition(0)
                .perform(click());
    }


}