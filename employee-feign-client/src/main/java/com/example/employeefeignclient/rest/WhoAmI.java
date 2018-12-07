package com.example.employeefeignclient.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class WhoAmI {
    @Value("${whoami:UNKNOWN-SERVICE}")
    private String whoami;

    @RequestMapping("/whoami")
    String getMessage() {
        return this.whoami;
    }
}
