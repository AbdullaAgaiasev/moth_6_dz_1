package com.example.moth_6_dz_1

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class ActivityTest {

    @Rule
    @JvmField
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun simpleAdd() {
        runBlocking {
            Espresso.onView(withId(R.id.edit_text)).perform(ViewActions.typeText("24"))
            Espresso.onView(withId(R.id.edit_text)).perform(ViewActions.closeSoftKeyboard())
            delay(1000)
            Espresso.onView(withId(R.id.edit_text)).perform(ViewActions.typeText("6"))
            Espresso.onView(withId(R.id.edit_text)).perform(ViewActions.closeSoftKeyboard())
            delay(1000)
            Espresso.onView(withId(R.id.button)).perform(ViewActions.click())
            delay(1000)
//            Espresso.onView(withId(R.id.tv_result)).check(ViewAssertions.matches(ViewMatchers.withText("30")))
//            delay(2000)
        }
    }
}