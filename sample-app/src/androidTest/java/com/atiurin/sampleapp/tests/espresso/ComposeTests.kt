package com.atiurin.sampleapp.tests.espresso

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.atiurin.sampleapp.activity.ComposeActivity
import com.atiurin.sampleapp.data.repositories.CONTACTS
import com.atiurin.ultron.core.compose.*
import com.atiurin.ultron.extensions.assertTextEquals
import com.atiurin.ultron.extensions.click
import com.atiurin.ultron.extensions.getText
import com.atiurin.ultron.extensions.isDisplayed
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class ComposeTests {

    @get:Rule
    val composeRule = createUltronComposeRule<ComposeActivity>()
    val initialText = "Like count = 0"
    val expectedText = "Like count = 1"
    @Test
    fun firstTest(){
        hasText(initialText).click()
        hasText(expectedText).isDisplayed()
    }

    @Test
    fun contentDescTest(){
        hasContentDescription("likes_counter").click()
        hasText(expectedText).isDisplayed()
    }

    @Test
    fun testTagTest(){
        hasTestTag("likes_counter").click()
        hasTestTag("likes_counter").assertTextEquals(expectedText).isDisplayed()
    }

    @Test
    fun getTextTest(){
        hasTestTag("likes_counter").click()
        val text = hasTestTag("likes_counter").getText()
        Assert.assertEquals(expectedText, text)
    }

    @ExperimentalTestApi
    @Test
    fun scrollListTest(){
        Thread.sleep(2000)
        composeRule.onNode(hasContentDescription("contacts_list")).performScrollToKey(CONTACTS.last().name)
        Thread.sleep(2000)
        composeRule.onNode(hasContentDescription("contacts_list")).performScrollToKey(CONTACTS.first().name)
        Thread.sleep(2000)
    }
}