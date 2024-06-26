package com.springboot.reactive.app.health;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HealthController.class);

    @GetMapping("/")
    public String health() {
        LOGGER.info("Health controller ...");
        return "Health";
    }

}