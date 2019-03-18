package com.ssheld.giflib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Author: Stephen Sheldon 3/18/2019
 */

@EnableAutoConfiguration
@ComponentScan // Scan for controller
public class AppConfig {

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }
}
