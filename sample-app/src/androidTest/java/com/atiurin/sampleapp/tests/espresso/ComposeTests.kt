package com.atiurin.sampleapp.tests.espresso

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.atiurin.sampleapp.activity.ComposeActivity
import com.atiurin.ultron.core.compose.*
import com.atiurin.ultron.extensions.assertTextEquals
import com.atiurin.ultron.extensions.click
import com.atiurin.ultron.extensions.isDisplayed
import org.junit.Rule
import org.junit.Test

class ComposeTests {

    @get:Rule
    val composeRule = createUltronComposeRule<ComposeActivity>()

    @Test
    fun firstTest(){
        hasText("Like count = 0").click()
        hasText("Like count = 1").isDisplayed()
    }

    @Test
    fun contentDescTest(){
        hasContentDescription("likes_counter").click()
        hasText("Like count = 1").isDisplayed()
    }

    @Test
    fun testTagTest(){
        hasTestTag("likes_counter").click()
        hasTestTag("text_container").assertTextEquals("Like count = 1").isDisplayed()
    }
}