package com.atiurin.ultron.core.compose

import androidx.compose.ui.test.SemanticsMatcher

class UltronComposeCollectionInteraction(
    val matcher: SemanticsMatcher,
    val useUnmergedTree: Boolean = false
) {
    companion object {
        fun allNodes(matcher: SemanticsMatcher, useUnmergedTree: Boolean = false): UltronComposeCollectionInteraction {
            return UltronComposeCollectionInteraction(matcher, useUnmergedTree)
        }
    }

    fun get(index: Int) = UltronComposeInteraction(getComposeRule().onAllNodes(matcher, useUnmergedTree)[index])

    fun fetchSemanticNodes() = getComposeRule().onAllNodes(matcher, useUnmergedTree).fetchSemanticsNodes()
}