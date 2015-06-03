package org.oncoblocks.magpie.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tewei on 6/2/15.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MagpieApplication {
    public static void main(String[] args){
        SpringApplication.run(MagpieApplication.class, args);
    }
}
