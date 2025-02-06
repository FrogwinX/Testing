package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController

public class Main {

    @Autowired
    private DatabaseHandler dbHandler;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @CrossOrigin
    @GetMapping("/query")
    public String queryDatabase(@RequestParam String id) {
        return dbHandler.getNameById(id);
    }
}
