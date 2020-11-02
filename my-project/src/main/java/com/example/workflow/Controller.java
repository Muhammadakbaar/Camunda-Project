package com.example.workflow;

import lombok.Getter;
import lombok.Setter;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private ProcessEngine processEngine;

    @PostMapping (path = "/hello",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello(@RequestBody HelloMessage hello){
        ProcessInstanceWithVariables var = this.processEngine.getRuntimeService()
                .createProcessInstanceByKey("payment-retrieval")
                .setVariable("amount",hello.getAmount())
                .setVariable("item",hello.getItem())
                .executeWithVariablesInReturn();

        return (String) var.getVariables().getValueTyped("returnFromCamunda").getValue();
    }

}
    @Getter
    @Setter
    class HelloMessage{
    private Long amount;
    private String item;
}
