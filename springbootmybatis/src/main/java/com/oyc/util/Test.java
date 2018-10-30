package com.oyc.util;

import com.oyc.SpringbootmybatisApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//@SpringApplicationConfiguration(classes = SpringbootmybatisApplication.class)
@WebAppConfiguration
public class Test {

    // 获得SpringBoot提供的mongodb的GridFS对象
    private GridFsTemplate gridFsTemplate;

    @Autowired
    MongoGridFsTemplate mongoGridFsTemplate;





    @org.junit.Test
    public void testMongoDb() {

        // 测试一下 11234台台湾也给我
        
        // 获取链接
      //  MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        // 获取数据库
      //  MongoDatabase database = mongoClient.getDatabase("test");
        // 进入某个文档集
      //  MongoCollection<Document> collection = database.getCollection("fs.files");

      //  DB db = mongoClient.getDB("test");
     //   GridFS gridFS = new GridFS(db, "fs");
     //   GridFSDBFile gridFSDBFile = gridFS.findOne("test.xml");

        //MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClient, "test");
       /* GridFsResource[] txtFiles = new GridFsResource[]{};
        try {
            gridFsTemplate = mongoGridFsTemplate.gridFsTemplate();
            txtFiles = gridFsTemplate.getResources("*.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(GridFsResource txtFile : txtFiles) {
        }*/



       /* ParseXML parseXML = new ParseXML();
        Map<String, Object> map = parseXML.parse(gridFSDBFile.getInputStream());
        if(map != null) {
            FundPortfolio fundPortfolio = (FundPortfolio) map.get("fundPortfolio");
            System.out.println(fundPortfolio.getFundCode());
        }*/

    }
}
