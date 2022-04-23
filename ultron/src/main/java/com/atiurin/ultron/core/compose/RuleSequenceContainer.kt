package com.atiurin.ultron.core.compose

import com.atiurin.ultron.testlifecycle.rulesequence.RuleSequence

object RuleSequenceContainer {
    lateinit var ruleSequence: RuleSequence
}

fun createRuleSequence(): RuleSequence{
    RuleSequenceContainer.ruleSequence = RuleSequence()
    return RuleSequenceContainer.ruleSequence
}
