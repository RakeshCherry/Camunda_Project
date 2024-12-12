package com.project.Controller;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/camunda")
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "Today is a good day!";
    }

    @GetMapping("/execute")
    public String execute(){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("first_bpmn_execute");

        String item = "Computer";

        instance.businessKey("execute-endpoint");

        instance.setVariable("itemName", item);
        instance.executeWithVariablesInReturn();
        return "BPMN has Executed";
    }

    @GetMapping("/tasks")
    public String alltasks(){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("all_tasks");
        instance.executeWithVariablesInReturn();
        return "Tasks has Executed";
    }
}
