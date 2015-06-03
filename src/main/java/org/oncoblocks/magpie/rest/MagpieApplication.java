package org.oncoblocks.magpie.rest;
import java.util.Arrays;
import org.springframework.context.ApplicationContext;
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


//        ApplicationContext ctx = SpringApplication.run(MagpieApplication.class, args);

//        System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
    }
}
