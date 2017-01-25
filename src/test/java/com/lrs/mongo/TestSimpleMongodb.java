package com.lrs.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * java driver mongodb简单测试
 * bson依赖是mongoDB提供的BSON操作工具
 * Created by liruishi on 2017/1/25.
 */
public class TestSimpleMongodb {
    private final static Logger log = LoggerFactory.getLogger(TestSimpleMongodb.class);

    private final static String URL  = "192.168.99.100";
    private final static int    PORT = 32768;

    protected MongoClient getMongoClient() {
        MongoClient client = new MongoClient(URL, PORT);
        return client;
    }

    protected MongoDatabase getMongoDatabase(MongoClient client) {
        return client.getDatabase("local");
    }

    @Test
    public void testNeedAuthConnect() {
        ServerAddress serverAddress = new ServerAddress(URL,PORT);
        List<ServerAddress> adds = new ArrayList<>();
        adds.add(serverAddress);
        MongoCredential mongoCredential = MongoCredential.createMongoCRCredential("username","dbname","password".toCharArray());

        List<MongoCredential> credentials = new ArrayList<>();
        credentials.add(mongoCredential);

        MongoClient client = new MongoClient(adds,credentials);
        client.getDatabase("test");
        log.info("connect to mongoDB successfully!");
        client.close();

    }

    @Test
    public void testConnectMongoDb() {
        MongoClient client = getMongoClient();
        MongoCollection<Document> collection = getMongoDatabase(client).getCollection("notice");
        FindIterable<Document> findIterable = collection.find(new Document("siteId", "124"));
        MongoCursor<Document> cursor = findIterable.iterator();
        while (cursor.hasNext()) {
            log.info(cursor.next().toJson());
        }

        client.close();
    }

    @Test
    public void testCreateCollection() {
        MongoClient client = getMongoClient();
        getMongoDatabase(client).createCollection("goods");
        log.info("create collection successfully!");
        client.close();
    }

    @Test
    public void testInsertDoc() {
        MongoClient client = getMongoClient();
        MongoDatabase database = getMongoDatabase(client);
        log.info("connect to Mongodb successfully!");
        MongoCollection<Document> collection = database.getCollection("customers");
        //插入文档
        Document document = new Document("title", "Redis").append("description", "Nosql database cache").append("lke", "100").append("by", "redis");
        List<Document> docs = new ArrayList<>();
        docs.add(document);
        collection.insertMany(docs);
        log.info("insert document successfully");
        client.close();
    }

    /**
     * 检索所有文档
     * <p>
     * 1.获取迭代器FindIterable<Document>
     * 2.获取游标MongoCursor<Document>
     * 3.通过游标遍历检索出文档集合
     */
    @Test
    public void testSearch() {
        MongoClient client = getMongoClient();
        MongoDatabase database = getMongoDatabase(client);

        MongoCollection<Document> collection = database.getCollection("customers");

        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> cursor = findIterable.iterator();
        while (cursor.hasNext()) {
            log.info(cursor.next().toJson());
        }
        client.close();
    }

    @Test
    public void testQueryById() {
        MongoClient client = getMongoClient();
        MongoCollection collection = getCollection(client);
        FindIterable<Document> findIterable = collection.find(new Document("id", "5888143d1c6ec50a70c871a8"));
        MongoCursor<Document> cursor = findIterable.iterator();
        while (cursor.hasNext()) {
            log.info(cursor.next().toJson());
        }
        client.close();
    }

    protected MongoCollection<Document> getCollection(MongoClient client) {
        return getMongoDatabase(client).getCollection("customers");
    }

    @Test
    public void testUpdate() {
        MongoClient client = getMongoClient();
        MongoCollection<Document> collection = getCollection(client);
        collection.updateMany(Filters.eq("id", 2), new Document("id", 9527));
        //结果查询
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> cursor = findIterable.iterator();
        while (cursor.hasNext()) {
            log.info(cursor.next().toJson());
        }
        client.close();
    }

    //删除文档
    @Test
    public void remove() {
        MongoClient client = getMongoClient();
        MongoCollection<Document> collection = getCollection(client);
        //删除符合条件的第一个文档
        collection.deleteOne(Filters.eq("like", 2001));
        //删除所有符合条件的
        collection.deleteMany(Filters.eq("like", 20001));
    }
}
