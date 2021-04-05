package com.up.cleanarchitecture.ui

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.up.cleanarchitecture.R
import kotlinx.android.synthetic.main.fragment_second2.*


import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class Second2FragmentTest {

    @Before
    fun before(){
        val fragmentArgs = bundleOf("name" to "john", "gender" to "male",
                "species" to "human", "status" to "yes")

        launchFragmentInContainer<Second2Fragment>(fragmentArgs)
    }

    @Test
    fun species_updated_correctly(){
        onView(withId(R.id.species1)).check(matches(withText("Species: human")))
    }

    @Test
    fun name_updated_correctly(){
        onView(withId(R.id.name1)).check(matches(withText("Name: john")))
    }

    @Test
    fun gender_updated_correctly(){
        onView(withId(R.id.gender1)).check(matches(withText("Gender: male")))
    }

    @Test
    fun status_updated_correctly(){
        onView(withId(R.id.status1)).check(matches(withText("Status: yes")))
    }


}