package com.atiurin.ultron.core.compose

import com.atiurin.ultron.core.common.Operation
import com.atiurin.ultron.core.common.OperationExecutor
import com.atiurin.ultron.core.common.OperationIterationResult
import com.atiurin.ultron.core.config.UltronConfig

internal class ComposeOperationExecutor(
    override val operation: UltronComposeOperation
) : OperationExecutor<UltronComposeOperation, ComposeOperationResult<UltronComposeOperation>> {
    override val pollingTimeout: Long
        get() = UltronConfig.Compose.COMPOSE_OPERATION_POLLING_TIMEOUT

    override fun generateResult(
        success: Boolean,
        exceptions: List<Throwable>,
        description: String,
        operationIterationResult: OperationIterationResult?
    ): ComposeOperationResult<UltronComposeOperation> {
        return ComposeOperationResult(
            operation = operation,
            success = success,
            exception = exceptions.lastOrNull(),
            description = description,
            operationIterationResult = operationIterationResult
        )
    }

    override fun getAllowedExceptions(operation: Operation): List<Class<out Throwable>> {
        return UltronConfig.Compose.allowedExceptions
    }
}