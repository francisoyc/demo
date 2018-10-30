package com.oyc.util;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

@Configuration
public class MongoGridFsTemplate  extends AbstractMongoConfiguration{
	
	@Value("${jsa.mongo.address}")
	private String mongoAddress;
	
	@Value("${jsa.mongo.database}")
	private String mongoDatabase;

	public MongoGridFsTemplate(){

	}
	/*public MongoGridFsTemplate(String mongoAddress, String mongoDatabase){
		this.mongoAddress = mongoAddress;
		this.mongoDatabase = mongoDatabase;
	}*/

	@Bean
	public GridFsTemplate gridFsTemplate() throws Exception {
	    return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter(), "xml");
	}
	
	@Override
	protected String getDatabaseName() {
		return mongoDatabase;
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient(mongoAddress);
	}
}
