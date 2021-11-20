package aleksey.vasiliev.lab3_3

import android.content.pm.ActivityInfo
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @get: Rule
    val firstActivityRule: ActivityTestRule<FirstActivity> =
        ActivityTestRule(FirstActivity::class.java)

    @get: Rule
    val secondActivityRule: ActivityTestRule<SecondActivity> =
        ActivityTestRule(SecondActivity::class.java)

    @get: Rule
    val thirdActivityRule: ActivityTestRule<ThirdActivity> =
        ActivityTestRule(ThirdActivity::class.java)

    @get: Rule
    val aboutActivityRule: ActivityTestRule<About> =
        ActivityTestRule(About::class.java)

    @Test
    fun about() {
        launchActivity<About>()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_first)).check(doesNotExist())
        onView(withId(R.id.activity_second)).check(doesNotExist())
        onView(withId(R.id.activity_third)).check(doesNotExist())
        aboutActivityRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        Thread.sleep(1000)
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_first)).check(doesNotExist())
        onView(withId(R.id.activity_second)).check(doesNotExist())
        onView(withId(R.id.activity_third)).check(doesNotExist())
    }

    @Test
    fun firstActivity() {
        launchActivity<FirstActivity>()
        onView(withId(R.id.activity_first)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_about)).check(doesNotExist())
        onView(withId(R.id.activity_second)).check(doesNotExist())
        onView(withId(R.id.activity_third)).check(doesNotExist())
        firstActivityRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        Thread.sleep(1000)
        onView(withId(R.id.activity_first)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_about)).check(doesNotExist())
        onView(withId(R.id.activity_second)).check(doesNotExist())
        onView(withId(R.id.activity_third)).check(doesNotExist())
    }

    @Test
    fun secondActivity() {
        launchActivity<SecondActivity>()
        onView(withId(R.id.activity_second)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_about)).check(doesNotExist())
        onView(withId(R.id.activity_first)).check(doesNotExist())
        onView(withId(R.id.activity_third)).check(doesNotExist())
        secondActivityRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        Thread.sleep(1000)
        onView(withId(R.id.activity_second)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_about)).check(doesNotExist())
        onView(withId(R.id.activity_first)).check(doesNotExist())
        onView(withId(R.id.activity_third)).check(doesNotExist())
    }

    @Test
    fun thirdActivity() {
        launchActivity<ThirdActivity>()
        onView(withId(R.id.activity_third)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_about)).check(doesNotExist())
        onView(withId(R.id.activity_first)).check(doesNotExist())
        onView(withId(R.id.activity_second)).check(doesNotExist())
        thirdActivityRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        Thread.sleep(1000)
        onView(withId(R.id.activity_third)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_about)).check(doesNotExist())
        onView(withId(R.id.activity_first)).check(doesNotExist())
        onView(withId(R.id.activity_second)).check(doesNotExist())
    }
}