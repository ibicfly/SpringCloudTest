package io.ibicfly.service0;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.netflix.discovery.converters.Auto;
import com.netflix.discovery.util.StringUtil;
import io.swagger.annotations.Api;
import org.bson.Document;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@RestController
@ComponentScan
@EnableSwagger2
@EnableAsync
@Api("service0API")
public class Service0Application {
    @Autowired
    private AsyncTask asyncTask;
//    @Autowired
//    MongoTemplate mongoTemplate;
    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("service0")
    public String service0() {
        return "service0";
    }

    public static void main(String[] args) {
        SpringApplication.run(Service0Application.class, args);
    }

    @GetMapping("doTask")
    public String doTask() throws InterruptedException {
        long start = System.currentTimeMillis();
        asyncTask.task1();
        asyncTask.task2();
        long end = System.currentTimeMillis();
        System.out.println("task 耗时" + (end - start) + "ms");
        return "task 耗时" + (end - start) + "ms";
    }

    @PostMapping("sendEmail")
    public void sendEmail(String emailAddress, String content, String username, String password) {

    }

    @GetMapping("testMongo")
    @ResponseBody
    public Map<String, Object> testMongo(String collectionName, String docName) {
        Map<String, Object> res = new HashMap<String, Object>();
        MongoCollection<Document> collection = null;
        Document document = new Document();
        if (collectionName != null && !collectionName.equals(""))
//            collection = mongoTemplate.getCollection(collectionName);
//        System.out.println(document=collection.find().first());
        res.put("data", document);
        return res;
    }

    @PostMapping("rabbitProducer")
    @ResponseBody
    public Map<String, Object> rabbitProducer(String message) {
        Map<String, Object> res = new HashMap<String, Object>();
        String resStr = "发送消息" + message + "现在时间" + new Date();
        amqpTemplate.convertAndSend("test", resStr);
        res.put("data", resStr);
        return res;
    }

    @PostMapping("/topicSend1")
    public void send(String message) {
        System.out.println("topicSend1 : " + message);
        this.amqpTemplate.convertAndSend("topicExchange", "topic.1", message);
    }

    @PostMapping("/topicSend2")
    public void send1(String message) {
        System.out.println("topicSend2 : " + message);
        this.amqpTemplate.convertAndSend("topicExchange", "topic.message", message);
    }

    @PostMapping("/topicSend3")
    public void send2(String message) {
        System.out.println("topicSend3 : " + message);
        this.amqpTemplate.convertAndSend("topicExchange", "topic.messages", message);
    }

}
