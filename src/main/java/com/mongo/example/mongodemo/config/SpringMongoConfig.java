//package com.mongo.example.mongodemo.config;
//
//
//import org.springframework.context.annotation.Bean;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
////import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
//import org.springframework.data.mongodb.core.MongoTemplate;
//
//
//@Configuration
//public class SpringMongoConfig extends AbstractMongoClientConfiguration {
//
//	public String getDatabaseName() {
//		return "restdemo";
//	}
//
//	public @Bean
//	MongoTemplate mongoTemplate() throws Exception {
//		
//		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
//				
//		return mongoTemplate;
//		
//	}
//	
//}
//
////@Configuration
////public class SpringMongoConfig {
////
////		@SuppressWarnings("deprecation")
////		public @Bean
////		MongoDbFactory mongoDbFactory() throws Exception {
////			return new SimpleMongoDbFactory(new MongoClient(), "restdemo");
////		}
////
////		public @Bean
////		MongoTemplate mongoTemplate() throws Exception {
////			
////			MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
////					
////			return mongoTemplate;
////			
////		}
////	}
