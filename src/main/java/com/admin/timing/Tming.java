package com.admin.timing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Tming implements CommandLineRunner {

    @Autowired
    LoadScheduler loadScheduler;


    @Override
    public void run(String... args) throws Exception {
        loadScheduler.load();
    }
}