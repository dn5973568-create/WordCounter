
package com.example.wordcounter;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.containsString;

@RunWith(AndroidJUnit4.class)
public class WordCounterUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void COUNT_WORDS_DISPLAY_RESULT() {
        Espresso.onView(ViewMatchers.withId(R.id.textInput))
                .perform(ViewActions.typeText("Hello world Android"),
                        ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.countSpinner))
                .perform(ViewActions.click());

        Espresso.onData(containsString("Words"))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.countButton))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(
                        ViewMatchers.withText(containsString("3"))));
    }

    @Test
    public void COUNT_CHARS_DISPLAY_RESULT() {
        Espresso.onView(ViewMatchers.withId(R.id.textInput))
                .perform(ViewActions.typeText("Hello"),
                        ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.countSpinner))
                .perform(ViewActions.click());

        Espresso.onData(containsString("Chars"))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.countButton))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(
                        ViewMatchers.withText(containsString("5"))));
    }
}
