package com.project.Delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class subjectDisplayNameAssign implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {

        Map subjectMap = (Map)execution.getVariable("subjectObj");

        String subjectDisplayName = null;

        switch (subjectMap.get("name").toString()){
                case "English":
                    subjectDisplayName = "Eng";
                    break;
                case "Mathematics":
                    subjectDisplayName = "Maths";
                    break;
                case "Science":
                    subjectDisplayName = "Sci";
                    break;
//                case "Social Studies":
//                    subjectDisplayName = "SST";
//                    break;

        }
        subjectMap.put("displayName", subjectDisplayName);
    }
}
