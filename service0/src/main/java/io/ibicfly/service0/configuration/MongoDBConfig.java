package io.ibicfly.service0.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MongoDBConfig {
    //    <bean id="mongoManager" class="com.woshou.credit.mongo.MongoManager"
//    init-method="init">
//	    <property name="host" value="${mongo.host}"/>
//	    <property name="dbName" value="${mongo.dbName}"/>
//	    <property name="uname" value="${mongo.uname}"/>
//	    <property name="pwd" value="${mongo.pwd}"/>
//	    <property name="poolSize" value="${mongo.poolSize}"/>
//	    <property name="blockSize" value="${mongo.blockSize}"/>
//	</bean>
    private MongoClient client = null;
    private String host = "localhost:27107";// host
    private String dbName;//库名
    private String uname;//用户名
    private String pwd;//密码
    private int poolSize = 100;// 连接数量
    private int blockSize = 100; // 等待队列长度
    private int maxWaitTime = 1000 * 60 * 2; // 等待队列长度
    private int connectTimeout = 1000 * 60 * 1; // 连接超时
    private MongoDatabase db;

    public void init() {
        MongoClientOptions.Builder build = new MongoClientOptions.Builder();
        build.connectionsPerHost(poolSize); // 与目标数据库能够建立的最大connection数量为50
        build.threadsAllowedToBlockForConnectionMultiplier(blockSize); // 如果当前所有的connection都在使用中，则每个connection上可以有50个线程排队等待
        /*
         * 一个线程访问数据库的时候，在成功获取到一个可用数据库连接之前的最长等待时间为2分钟
         * 这里比较危险，如果超过maxWaitTime都没有获取到这个连接的话，该线程就会抛出Exception
         * 故这里设置的maxWaitTime应该足够大，以免由于排队线程过多造成的数据库访问失败
         */
        build.maxWaitTime(maxWaitTime);
        build.connectTimeout(connectTimeout); // 与数据库建立连接的timeout设置为1分钟
        MongoClientOptions myOptions = build.build();

        MongoCredential credential = MongoCredential.createCredential(uname, dbName, pwd.toCharArray());
        List<MongoCredential> credentials = new ArrayList<MongoCredential>();
        credentials.add(credential);
        try {
            client = new MongoClient(new ServerAddress(host), credentials, myOptions);
            db = client.getDatabase(dbName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("init end" + new Date());
    }
}
