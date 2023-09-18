package com.xzg.wlxx.camunda.delegate

import com.xzg.wlxx.common.annotations.Slf4j.Companion.logger
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class DemoDelegate() : JavaDelegate {

    override fun execute(execution: DelegateExecution?) {
        logger.info(execution?.id)
    }
}