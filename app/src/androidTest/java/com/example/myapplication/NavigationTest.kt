package com.example.myapplication

import android.content.pm.ActivityInfo
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.NoActivityResumedException
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Assert.fail
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun testAbout() {
        launchActivity<MainActivity>()
        openAbout()
        Espresso.onView(ViewMatchers.withId(R.id.activity_about))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun validateFragment1() { // TODO add nav arrow check
        onView(withId(R.id.nav_view)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
    }

    private fun validateFragment2() {
        onView(withId(R.id.nav_view)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).perform(click())
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
    }

    private fun validateFragment3() {
        onView(withId(R.id.nav_view)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).perform(click())
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
    }

    private fun rotatePortrait() {
        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        Thread.sleep(1000)
    }

    private fun rotateLandscape() {
        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(1000)
    }

    @Test
    fun checkNavigation1() {
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
    }

    @Test
    fun checkNavigation2() {
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
    }

    @Test
    fun checkBackstack1() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        openAbout()
        pressBack()
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }

    @Test
    fun checkBackstack2() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        pressBack()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }

    @Test
    fun checkRotationState1() {
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        rotatePortrait()
        rotateLandscape()
        validateFragment2()
        pressBack()
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        rotatePortrait()
        pressBack()
        validateFragment2()
        rotateLandscape()
        pressBack()
        validateFragment1()
    }

    @Test
    fun checkRotationState2() {
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        openAbout()
        rotatePortrait()
        pressBack()
        validateFragment2()
        onView(withId(R.id.bnToThird)).perform(click())
        validateFragment3()
        pressBack()
        pressBack()
        validateFragment1()
        rotateLandscape()
        openAbout()
        pressBack()
        validateFragment1()
    }

    @Test
    fun checkBackArrow() {
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withContentDescription("Navigate up")).perform(click())
        validateFragment1()
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withContentDescription("Navigate up")).perform(click())
        validateFragment2()
        onView(withContentDescription("Navigate up")).perform(click())
        validateFragment1()
    }

    @Test
    fun checkBackstackCloseApp() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        pressBack()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        pressBackUnconditionally()
        Assert.assertTrue(activityRule.scenario.state.isAtLeast(Lifecycle.State.DESTROYED))
    }
}