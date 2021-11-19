package com.vinylsMobile.espressoTestSprint1

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.vinylsMobile.vinylsApplication.R
import com.vinylsMobile.vinylsApplication.ui.main.view.MainActivity
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    @Test
    fun test_isMainActivityInView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isPoeta_PuebloInView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        Thread.sleep(4000)
        onView(ViewMatchers.withText("Poeta del pueblo")).check(matches(isDisplayed()))
    }
    @Test
    fun test_isNBuscandoAmericaInView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        Thread.sleep(4000)
        onView(ViewMatchers.withText("Buscando América")).check(matches(isDisplayed()))
    }

}