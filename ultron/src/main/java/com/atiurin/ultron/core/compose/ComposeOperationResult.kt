package com.atiurin.ultron.core.compose

import com.atiurin.ultron.core.common.Operation
import com.atiurin.ultron.core.common.OperationIterationResult
import com.atiurin.ultron.core.common.OperationResult

class ComposeOperationResult <T : Operation>(
    override val operation: T,
    override val success: Boolean,
    override val exception: Throwable?,
    override var description: String,
    override var operationIterationResult: OperationIterationResult?
) : OperationResult<T>