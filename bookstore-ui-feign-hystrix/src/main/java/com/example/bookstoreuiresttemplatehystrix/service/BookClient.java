package com.example.bookstoreuiresttemplatehystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("BOOKSTORE-SERVICE")
public interface BookClient {
    @RequestMapping("/recommended")
    String whichbook();
}

