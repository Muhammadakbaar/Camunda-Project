package com.example.workflow;


import lombok.extern.log4j.Log4j2;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.net.URI;

@Service("chargeCreditCard")
@Log4j2
public class ChargeCreditCard implements JavaDelegate {


    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String item = (String) execution.getVariable("item");
        Long amount = (Long) execution.getVariable("amount");

        log.info("Charging credit card with an amount of '" + amount + "'€ for the item '" + item + "'...");

//        try {
//            Desktop.getDesktop().browse(new URI("https://docs.camunda.org/get-started/quick-start/complete"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
