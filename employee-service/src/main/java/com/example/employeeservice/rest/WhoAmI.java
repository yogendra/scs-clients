package com.example.employeeservice.rest;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class WhoAmI {

    private EurekaClient eurekaClient;

    @Autowired
    @Lazy
    public WhoAmI(EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    @Value("${whoami:UNKNOWN-SERVICE}")
    private String whoami;

    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/whoami")
    String getMessage() {
        return this.whoami;
    }

    @RequestMapping("/name")
    public String greeting() {
        return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
    }
}
