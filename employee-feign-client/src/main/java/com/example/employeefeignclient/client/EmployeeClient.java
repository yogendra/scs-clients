package com.example.employeefeignclient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "EMPLOYEE-SERVICE")
public interface EmployeeClient {

    @GetMapping(value="/employees", consumes="application/json")
    String getEmployees();
}
