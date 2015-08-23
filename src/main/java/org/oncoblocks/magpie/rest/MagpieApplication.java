package org.oncoblocks.magpie.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration//(exclude = { JacksonAutoConfiguration.class })
@ComponentScan(basePackages = "org.oncoblocks.magpie.rest")
public class MagpieApplication {
    public static void main(String[] args) throws Exception{
        ApplicationContext applicationContext = SpringApplication.run(MagpieApplication.class, args);
    }
}
