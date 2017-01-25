package com.lrs.mongo;

import com.lrs.common.mongo.Notice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;


/**
 * Mongodb 测试类
 * Created by liruishi on 2017/1/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/mongodb-config.xml")
public class TestMongoTemplate {
    @Resource
    private MongoOperations mongoOperations;

    @Test
    public void testSave() {
        Date now = new Date();
        Notice notice = new Notice();
        notice.setSiteId(124);
        notice.setCreateTime(now);
        notice.setUpdateTime(now);
        notice.setCreator("liruishi");
        notice.setContent("mongodb test content");

        mongoOperations.insert(notice);

        System.out.println(notice.getId());

    }
}
