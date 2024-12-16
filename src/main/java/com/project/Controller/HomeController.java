package com.project.Controller;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/camunda")
public class HomeController {

    private static final Map<String, String> processKeyMap = new HashMap<>();

    static {
        processKeyMap.put("home", "first_bpmn_execute");
        processKeyMap.put("tasks", "all_tasks");
        processKeyMap.put("sequence", "sequence_flows_execute");
        processKeyMap.put("gateways", "gateway_execute");
        processKeyMap.put("subprocess", "subprocess_execute");
        processKeyMap.put("dmns", "dmns_execute");
    }

    @GetMapping("/home")
    public String home() {
        return "Today is a good day!";
    }
        @GetMapping("/execute/{key}")
        public String executeProcess(@PathVariable("key") String key) {
            String processKey = processKeyMap.get(key);

            if (processKey == null) {
                return "Invalid process key: " + key;
            }
            ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
            ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey(processKey);

            // Optionally set a business key or variables dynamically based on logic
            instance.businessKey("dynamic-execution");
            instance.executeWithVariablesInReturn();

            return processKey + " has executed.";
        }
    }
