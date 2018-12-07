package com.example.bookstoreservice.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookStoreRest {

    protected static Logger logger = LoggerFactory.getLogger(BookStoreRest.class);

    @RequestMapping(value = "/recommended")
    public String readingList()
    {
        logger.info("Invoking readingList");
        return "Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)";
    }
}
