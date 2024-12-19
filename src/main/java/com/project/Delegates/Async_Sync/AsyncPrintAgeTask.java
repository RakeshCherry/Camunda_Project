package com.project.Delegates.Async_Sync;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class AsyncPrintAgeTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Print Age :: " + execution.getVariable("username").toString());

    }
}
