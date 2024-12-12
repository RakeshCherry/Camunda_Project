package com.project.Services;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Component;

@Component
public class UserDepartmentService {

    public String getUserDepartment(){

        System.out.println("Coming from getUserDepartment method of UserDepartment Service");
        return "Accounts";
    }

}
