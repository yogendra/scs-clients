package com.example.bookstoreuiresttemplatehystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@RefreshScope
@Service
public class BookService {

    protected static Logger logger = LoggerFactory.getLogger(BookService.class);
    private final BookClient bookClient;

    @Value("${store-service:bookstore-service}")
    private String storeService;

    public BookService(BookClient bookClient) {
        this.bookClient = bookClient;
    }

    @HystrixCommand(fallbackMethod = "reliable")
    public String readingList() {
       return bookClient.whichbook();
    }

    public String reliable() {
        logger.info("In fallback method, something is WRONG!!!!!");
        return "Cloud Native Java (O'Reilly)";
    }
}
