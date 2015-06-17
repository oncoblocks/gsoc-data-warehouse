package org.oncoblocks.magpie.test;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collections;

@Configuration
@EnableMongoRepositories("org.oncoblocks.magpie.rest.repositories")
public class MongoTestConfiguration extends AbstractMongoConfiguration {

    @Override
    public String getDatabaseName(){
        return "magpie_test_1_test";
    }

    @Override
    @Bean
    public MongoClient mongo() throws Exception {
        return new MongoClient(Collections.singletonList(new ServerAddress("127.0.0.1", 27017)));
    }
}
