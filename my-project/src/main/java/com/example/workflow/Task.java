package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class Task implements JavaDelegate {


    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Long amount = (Long) execution.getVariable("amount");
    execution.setVariable("returnFromCamunda","hallo lagi"+ amount);


    }
}
