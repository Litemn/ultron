package com.atiurin.ultron.extensions

import androidx.compose.ui.test.SemanticsMatcher
import com.atiurin.ultron.core.compose.UltronComposeInteractionProxy

fun SemanticsMatcher.click() = UltronComposeInteractionProxy(this).click()
fun SemanticsMatcher.isDisplayed() = UltronComposeInteractionProxy(this).isDisplayed()
fun SemanticsMatcher.assertTextEquals(expected: String) = UltronComposeInteractionProxy(this).assertTextEquals(expected)