package com.example.employeefeignclient.rest;

import com.example.employeefeignclient.client.EmployeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvokeEmployeeService {
    private final EmployeeClient client;

    @Autowired
    public InvokeEmployeeService(EmployeeClient client) {
        this.client = client;
    }

    @RequestMapping("/emps")
    String getEmps() {
        String emps = client.getEmployees();
        return emps;
    }
}
