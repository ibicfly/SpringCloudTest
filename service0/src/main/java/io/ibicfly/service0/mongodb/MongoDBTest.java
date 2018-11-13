package io.ibicfly.service0.mongodb;

import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoDBTest {
    @Autowired
    private MongoTemplate mongoTemplate;
}
