package com.xzg.wlxx.camunda.delegate

import com.xzg.wlxx.common.log.WlxxLog.Companion.log
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class DemoDelegate : JavaDelegate {
    @Throws(Exception::class)
    override fun execute(execution: DelegateExecution) {
        log.info(execution.id)
    }
}
