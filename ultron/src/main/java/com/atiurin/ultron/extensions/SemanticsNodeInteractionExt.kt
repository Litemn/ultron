package com.atiurin.ultron.extensions

import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.SemanticsSelector

fun SemanticsNodeInteraction.getDescription() = this.getProperty<SemanticsSelector>("selector")?.description