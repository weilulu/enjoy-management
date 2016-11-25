package com.enjoy.management.mongo.config;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.enjoy.management.mongo.entity.EmployeeRepository;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages="com.enjoy.management.mongo")
public class MongoDBConfig {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Bean
	public MongoDbFactory mongoDbFactory() throws UnknownHostException{
		MongoClient mongoClient = new MongoClient("localhost",27017);
		UserCredentials credentials = new UserCredentials("","");
		return new SimpleMongoDbFactory(mongoClient,"concretepage",credentials);
	}
	
	@Bean
	public MongoTemplate mongoTemplate() throws UnknownHostException{
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		return mongoTemplate;
	}
}
