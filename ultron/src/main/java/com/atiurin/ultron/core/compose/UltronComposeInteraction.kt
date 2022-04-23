package com.atiurin.ultron.core.compose

import androidx.compose.ui.test.*
import com.atiurin.ultron.core.config.UltronConfig
import com.atiurin.ultron.extensions.getDescription

class UltronComposeInteraction(
    val semanticsNodeInteraction: SemanticsNodeInteraction,
    val timeoutMs: Long? = null,
    val resultHandler: ((ComposeOperationResult<UltronComposeOperation>) -> Unit)? = null
) {
    companion object {
        /**
         * Executes any compose action inside Ultron lifecycle
         */
        fun executeOperation(
            operation: UltronComposeOperation,
            resultHandler: (ComposeOperationResult<UltronComposeOperation>) -> Unit = UltronConfig.Compose.resultHandler
        ) {
            UltronComposeOperationLifecycle.execute(ComposeOperationExecutor(operation), resultHandler)
        }
    }

    fun withResultHandler(resultHandler: (ComposeOperationResult<UltronComposeOperation>) -> Unit) =
        UltronComposeInteraction(semanticsNodeInteraction, this.timeoutMs, resultHandler)

    fun withTimeout(timeoutMs: Long) = UltronComposeInteraction(semanticsNodeInteraction, timeoutMs, this.resultHandler)

    fun click() = apply {
        val timeout = timeoutMs ?: UltronConfig.Compose.OPERATION_TIMEOUT
        executeOperation(
            operation = UltronComposeOperation(
                operationBlock = { semanticsNodeInteraction.performGesture { this.click() } },
                name = "Click to '${semanticsNodeInteraction.getDescription()}'",
                type = ComposeOperationType.CLICK,
                description = "Compose operation '${ComposeOperationType.CLICK}' to '${semanticsNodeInteraction.getDescription()} during $timeout ms",
                timeoutMs = timeout
            ),
            resultHandler = this.resultHandler ?: UltronConfig.Compose.resultHandler
        )
    }

    fun isDisplayed() = apply {
        val timeout = timeoutMs ?: UltronConfig.Compose.OPERATION_TIMEOUT
        executeOperation(
            operation = UltronComposeOperation(
                operationBlock = { semanticsNodeInteraction.assertIsDisplayed() },
                name = "Click to '${semanticsNodeInteraction.getDescription()}.'",
                type = ComposeOperationType.IS_DISPLAYED,
                description = "Compose operation '${ComposeOperationType.IS_DISPLAYED}' to '${semanticsNodeInteraction.getDescription()}' during $timeout ms",
                timeoutMs = timeout
            ),
            resultHandler = this.resultHandler ?: UltronConfig.Compose.resultHandler
        )
    }

    fun isNotDisplayed() = apply {
        val timeout = timeoutMs ?: UltronConfig.Compose.OPERATION_TIMEOUT
        executeOperation(
            operation = UltronComposeOperation(
                operationBlock = { semanticsNodeInteraction.assertIsNotDisplayed() },
                name = "Click to '${semanticsNodeInteraction.getDescription()}.'",
                type = ComposeOperationType.IS_NOT_DISPLAYED,
                description = "Compose operation '${ComposeOperationType.IS_NOT_DISPLAYED}' to '${semanticsNodeInteraction.getDescription()}' during $timeout ms",
                timeoutMs = timeout
            ),
            resultHandler = this.resultHandler ?: UltronConfig.Compose.resultHandler
        )
    }

    fun isExist() = apply {
        val timeout = timeoutMs ?: UltronConfig.Compose.OPERATION_TIMEOUT
        executeOperation(
            operation = UltronComposeOperation(
                operationBlock = { semanticsNodeInteraction.assertExists() },
                name = "Click to '${semanticsNodeInteraction.getDescription()}.'",
                type = ComposeOperationType.EXISTS,
                description = "Compose operation '${ComposeOperationType.EXISTS}' to '${semanticsNodeInteraction.getDescription()}' during $timeout ms",
                timeoutMs = timeout
            ),
            resultHandler = this.resultHandler ?: UltronConfig.Compose.resultHandler
        )
    }

    fun doesNotExist() = apply {
        val timeout = timeoutMs ?: UltronConfig.Compose.OPERATION_TIMEOUT
        executeOperation(
            operation = UltronComposeOperation(
                operationBlock = { semanticsNodeInteraction.assertDoesNotExist() },
                name = "Click to '${semanticsNodeInteraction.getDescription()}.'",
                type = ComposeOperationType.DOES_NOT_EXIST,
                description = "Compose operation '${ComposeOperationType.DOES_NOT_EXIST}' to '${semanticsNodeInteraction.getDescription()}' during $timeout ms",
                timeoutMs = timeout
            ),
            resultHandler = this.resultHandler ?: UltronConfig.Compose.resultHandler
        )
    }

    fun isEnabled() = apply {
        val timeout = timeoutMs ?: UltronConfig.Compose.OPERATION_TIMEOUT
        executeOperation(
            operation = UltronComposeOperation(
                operationBlock = { semanticsNodeInteraction.assertIsEnabled() },
                name = "Click to '${semanticsNodeInteraction.getDescription()}.'",
                type = ComposeOperationType.IS_ENABLED,
                description = "Compose operation '${ComposeOperationType.IS_ENABLED}' to '${semanticsNodeInteraction.getDescription()}' during $timeout ms",
                timeoutMs = timeout
            ),
            resultHandler = this.resultHandler ?: UltronConfig.Compose.resultHandler
        )
    }

    fun isNotEnabled() = apply {
        val timeout = timeoutMs ?: UltronConfig.Compose.OPERATION_TIMEOUT
        executeOperation(
            operation = UltronComposeOperation(
                operationBlock = { semanticsNodeInteraction.assertIsNotEnabled() },
                name = "Click to '${semanticsNodeInteraction.getDescription()}.'",
                type = ComposeOperationType.IS_NOT_ENABLED,
                description = "Compose operation '${ComposeOperationType.IS_NOT_ENABLED}' to '${semanticsNodeInteraction.getDescription()}' during $timeout ms",
                timeoutMs = timeout
            ),
            resultHandler = this.resultHandler ?: UltronConfig.Compose.resultHandler
        )
    }

    fun isFocused() = apply {
        val timeout = timeoutMs ?: UltronConfig.Compose.OPERATION_TIMEOUT
        executeOperation(
            operation = UltronComposeOperation(
                operationBlock = { semanticsNodeInteraction.assertIsEnabled() },
                name = "Click to '${semanticsNodeInteraction.getDescription()}.'",
                type = ComposeOperationType.IS_ENABLED,
                description = "Compose operation '${ComposeOperationType.IS_ENABLED}' to '${semanticsNodeInteraction.getDescription()}' during $timeout ms",
                timeoutMs = timeout
            ),
            resultHandler = this.resultHandler ?: UltronConfig.Compose.resultHandler
        )
    }

    fun isNotFocused() = apply {
        val timeout = timeoutMs ?: UltronConfig.Compose.OPERATION_TIMEOUT
        executeOperation(
            operation = UltronComposeOperation(
                operationBlock = { semanticsNodeInteraction.assertIsNotFocused() },
                name = "Click to '${semanticsNodeInteraction.getDescription()}.'",
                type = ComposeOperationType.IS_NOT_FOCUSED,
                description = "Compose operation '${ComposeOperationType.IS_NOT_FOCUSED}' to '${semanticsNodeInteraction.getDescription()}' during $timeout ms",
                timeoutMs = timeout
            ),
            resultHandler = this.resultHandler ?: UltronConfig.Compose.resultHandler
        )
    }

    fun isSelected() = apply {
        val timeout = timeoutMs ?: UltronConfig.Compose.OPERATION_TIMEOUT
        executeOperation(
            operation = UltronComposeOperation(
                operationBlock = { semanticsNodeInteraction.assertIsSelected() },
                name = "Click to '${semanticsNodeInteraction.getDescription()}.'",
                type = ComposeOperationType.IS_SELECTED,
                description = "Compose operation '${ComposeOperationType.IS_SELECTED}' to '${semanticsNodeInteraction.getDescription()}' during $timeout ms",
                timeoutMs = timeout
            ),
            resultHandler = this.resultHandler ?: UltronConfig.Compose.resultHandler
        )
    }

    fun isNotSelected() = apply {
        val timeout = timeoutMs ?: UltronConfig.Compose.OPERATION_TIMEOUT
        executeOperation(
            operation = UltronComposeOperation(
                operationBlock = { semanticsNodeInteraction.assertIsNotSelected() },
                name = "Click to '${semanticsNodeInteraction.getDescription()}.'",
                type = ComposeOperationType.IS_NOT_SELECTED,
                description = "Compose operation '${ComposeOperationType.IS_NOT_SELECTED}' to '${semanticsNodeInteraction.getDescription()}' during $timeout ms",
                timeoutMs = timeout
            ),
            resultHandler = this.resultHandler ?: UltronConfig.Compose.resultHandler
        )
    }

    fun isSelectable() = apply {
        val timeout = timeoutMs ?: UltronConfig.Compose.OPERATION_TIMEOUT
        executeOperation(
            operation = UltronComposeOperation(
                operationBlock = { semanticsNodeInteraction.assertIsSelectable() },
                name = "Click to '${semanticsNodeInteraction.getDescription()}.'",
                type = ComposeOperationType.IS_SELECTABLE,
                description = "Compose operation '${ComposeOperationType.IS_SELECTABLE}' to '${semanticsNodeInteraction.getDescription()}' during $timeout ms",
                timeoutMs = timeout
            ),
            resultHandler = this.resultHandler ?: UltronConfig.Compose.resultHandler
        )
    }

    fun isOn() = apply {
        val timeout = timeoutMs ?: UltronConfig.Compose.OPERATION_TIMEOUT
        executeOperation(
            operation = UltronComposeOperation(
                operationBlock = { semanticsNodeInteraction.assertIsOn() },
                name = "Click to '${semanticsNodeInteraction.getDescription()}.'",
                type = ComposeOperationType.IS_NOT_SELECTED,
                description = "Compose operation '${ComposeOperationType.IS_NOT_SELECTED}' to '${semanticsNodeInteraction.getDescription()}' during $timeout ms",
                timeoutMs = timeout
            ),
            resultHandler = this.resultHandler ?: UltronConfig.Compose.resultHandler
        )
    }

    fun isOff() = apply {
        val timeout = timeoutMs ?: UltronConfig.Compose.OPERATION_TIMEOUT
        executeOperation(
            operation = UltronComposeOperation(
                operationBlock = { semanticsNodeInteraction.assertIsOff() },
                name = "Click to '${semanticsNodeInteraction.getDescription()}.'",
                type = ComposeOperationType.IS_OFF,
                description = "Compose operation '${ComposeOperationType.IS_OFF}' to '${semanticsNodeInteraction.getDescription()}' during $timeout ms",
                timeoutMs = timeout
            ),
            resultHandler = this.resultHandler ?: UltronConfig.Compose.resultHandler
        )
    }

    fun hasClickAction() = apply {
        val timeout = timeoutMs ?: UltronConfig.Compose.OPERATION_TIMEOUT
        executeOperation(
            operation = UltronComposeOperation(
                operationBlock = { semanticsNodeInteraction.assertHasClickAction() },
                name = "Click to '${semanticsNodeInteraction.getDescription()}.'",
                type = ComposeOperationType.HAS_CLICK_ACTION,
                description = "Compose operation '${ComposeOperationType.HAS_CLICK_ACTION}' to '${semanticsNodeInteraction.getDescription()}' during $timeout ms",
                timeoutMs = timeout
            ),
            resultHandler = this.resultHandler ?: UltronConfig.Compose.resultHandler
        )
    }

    fun hasNoClickAction() = apply {
        val timeout = timeoutMs ?: UltronConfig.Compose.OPERATION_TIMEOUT
        executeOperation(
            operation = UltronComposeOperation(
                operationBlock = { semanticsNodeInteraction.assertHasNoClickAction() },
                name = "Click to '${semanticsNodeInteraction.getDescription()}.'",
                type = ComposeOperationType.HAS_NO_CLICK_ACTION,
                description = "Compose operation '${ComposeOperationType.HAS_NO_CLICK_ACTION}' to '${semanticsNodeInteraction.getDescription()}' during $timeout ms",
                timeoutMs = timeout
            ),
            resultHandler = this.resultHandler ?: UltronConfig.Compose.resultHandler
        )
    }

    fun assertTextEquals(expected: String) = apply {
        val timeout = timeoutMs ?: UltronConfig.Compose.OPERATION_TIMEOUT
        executeOperation(
            operation = UltronComposeOperation(
                operationBlock = { semanticsNodeInteraction.assertTextEquals(expected) },
                name = "Click to '${semanticsNodeInteraction.getDescription()}.'",
                type = ComposeOperationType.TEXT_EQUALS,
                description = "Compose operation '${ComposeOperationType.TEXT_EQUALS}' to '${semanticsNodeInteraction.getDescription()}' during $timeout ms",
                timeoutMs = timeout
            ),
            resultHandler = this.resultHandler ?: UltronConfig.Compose.resultHandler
        )
    }

}