package com.atiurin.ultron.core.compose

import androidx.compose.ui.test.*
import com.atiurin.ultron.core.config.UltronConfig

class UltronComposeInteractionProxy(
    val matcher: SemanticsMatcher,
    val useUnmergedTree: Boolean = false,
    val timeoutMs: Long? = null,
    val resultHandler: ((ComposeOperationResult<UltronComposeOperation>) -> Unit)? = null
) {
    fun withResultHandler(resultHandler: (ComposeOperationResult<UltronComposeOperation>) -> Unit) =
        UltronComposeInteractionProxy(matcher, useUnmergedTree, this.timeoutMs, resultHandler)

    fun withTimeout(timeoutMs: Long) = UltronComposeInteractionProxy(matcher, useUnmergedTree, timeoutMs, this.resultHandler)

    fun click() = apply {
        getUltronComposeInteraction().click()
    }

    fun isDisplayed() = apply {
        getUltronComposeInteraction().isDisplayed()
    }

    fun assertTextEquals(expected: String) = apply { getUltronComposeInteraction().assertTextEquals(expected) }

    fun getUltronComposeInteraction() = UltronComposeInteraction(getComposeRule().onNode(matcher, useUnmergedTree), timeoutMs, resultHandler)
}