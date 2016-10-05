package jp.co.pockeps.rsssmaple.activity;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import jp.co.pockeps.rsssmaple.MyApplication;
import jp.co.pockeps.rsssmaple.R;
import jp.co.pockeps.rsssmaple.di.module.AppModule;
import jp.co.pockeps.rsssmaple.entity.uxmilk.Item;
import jp.co.pockeps.rsssmaple.entity.uxmilk.UxMilkRss;
import jp.co.pockeps.rsssmaple.mock.di.component.DaggerMockAppComponent;
import jp.co.pockeps.rsssmaple.mock.di.module.MockInfraLayerModule;
import jp.co.pockeps.rsssmaple.mock.repository.MockUxMilkRepository;
import jp.co.pockeps.rsssmaple.repository.NetworkListener;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
@SmallTest
public class MainActivityTest {
    @Rule
    public final ActivityTestRule<MainActivity> activityTestRule = new IntentsTestRule<>(MainActivity.class, true, false);

    @Test
    public void validateListItem() throws Throwable {

        //Mock Data セット
        Item item = new Item("タイトル", "http://qiita.com/arenahito/items/d9bbca61c8a67cfad226", "Thu, 29 Sep 2016 22:30:55 +0000", "説明");
        Item item2 = new Item("", "http://qiita.com/arenahito/items/d9bbca61c8a67cfad226", "Thu, 29 Sep 2016 22:30:55 +0000", "説明");
        Item item3 = new Item("タイトル", "http://qiita.com/arenahito/items/d9bbca61c8a67cfad226", "", "説明");
        Item item4 = new Item("タイトル", "http://qiita.com/arenahito/items/d9bbca61c8a67cfad226", "Thu, 29 Sep 2016 22:30:55 +0000", "");
        setSuccessMockComponent(item, item2, item3, item4);

        activityTestRule.launchActivity(new Intent());

        //データ描画確認
        onData(anything()).inAdapterView(withId(android.R.id.list))
                .atPosition(0).onChildView(withId(R.id.title)).check(matches(withText(item.title)));

        onData(anything()).inAdapterView(withId(android.R.id.list))
                .atPosition(0).onChildView(withId(R.id.description)).check(matches(withText(item.description)));

        onData(anything()).inAdapterView(withId(android.R.id.list))
                .atPosition(0).onChildView(withId(R.id.pub_date)).check(matches(withText(item.formatPubDate())));

        //タイトルなし
        onData(anything()).inAdapterView(withId(android.R.id.list))
                .atPosition(1).onChildView(withId(R.id.title)).check(matches(withText("")));

        //PubDateなし
        onData(anything()).inAdapterView(withId(android.R.id.list))
                .atPosition(2).onChildView(withId(R.id.pub_date)).check(matches(withText("")));

        //説明なし
        onData(anything()).inAdapterView(withId(android.R.id.list))
                .atPosition(3).onChildView(withId(R.id.description)).check(matches(withText("")));

        //intent確認
        onData(anything()).inAdapterView(withId(android.R.id.list))
                .atPosition(0)
                .perform(click());

        intended(allOf(
                hasData(item.link),
                toPackage("com.android.chrome")));
    }

    @Test
    public void networkError() throws Exception {
        setFailureMockComponent();
        activityTestRule.launchActivity(new Intent());

        onView(withText(R.string.message_network_failed)).inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));

    }

    private void setSuccessMockComponent(Item... items) {

        List<Item> list = Arrays.asList(items);
        setMockComponent(new MockUxMilkRepository(list) {
            @Override
            public void getUxMilkRss(NetworkListener<UxMilkRss> listener) {
                SuccessCase(listener);
            }
        });
    }

    private void setFailureMockComponent() {
        setMockComponent(new MockUxMilkRepository(null) {
            @Override
            public void getUxMilkRss(NetworkListener<UxMilkRss> listener) {
                failureCase(listener);
            }
        });
    }

    private void setMockComponent(final MockUxMilkRepository repository) {
        getApplication().setAppComponent(
                DaggerMockAppComponent
                        .builder()
                        .appModule(new AppModule(getApplication()))
                        .mockInfraLayerModule(new MockInfraLayerModule(repository))
                        .build()
        );
    }

    private MyApplication getApplication() {
        return (MyApplication) InstrumentationRegistry
                .getInstrumentation()
                .getTargetContext()
                .getApplicationContext();
    }

}