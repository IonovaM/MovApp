package cf.vandit.movie_app;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import cf.vandit.movie_app.R;
import cf.vandit.movie_app.activities.MainActivity;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testBottomNavigation() {
        // Первоначально отображается фрагмент MovieFragment
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()));
        onView(withId(R.id.toolbar_main)).check(matches(hasDescendant(withText("Movies"))));

        // Нажимаем на элемент навигации для фрагмента SeriesFragment
        onView(withId(R.id.nav_series)).perform(click());
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()));
        onView(withId(R.id.toolbar_main)).check(matches(hasDescendant(withText("Series"))));

        // Нажимаем на элемент навигации для фрагмента SearchFragment
        onView(withId(R.id.nav_search)).perform(click());
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()));
        onView(withId(R.id.toolbar_main)).check(matches(hasDescendant(withText("Search"))));

        // Нажимаем на элемент навигации для фрагмента FavouritesFragment
        onView(withId(R.id.nav_favourites)).perform(click());
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()));
        onView(withId(R.id.toolbar_main)).check(matches(hasDescendant(withText("Favourites"))));
    }
}
