package com.einfochips.student.dynamodb.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.einfochips.student.dynamodb.repository")
public class DynamoDBConfig {

	@Value("${amazon.dynamodb.endpoint}")
	private String dBEndpoint;

	@Value("${amazon.aws.accesskey}")
	private String accessKey;

	@Value("${amazon.aws.secretkey}")
	private String secretKey;

	//@Bean
	//public DynamoDBMapper dynamoDBMapper() {
		//return new DynamoDBMapper(amazonDynamoDB());
	//}

	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		// AmazonDynamoDB dynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials());
		AmazonDynamoDB dynamoDB = AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dBEndpoint, "eu-west-1"))
				.withCredentials(amazonAWSCredentials()).build();

		return dynamoDB;
	}

	@Bean
	public AWSCredentialsProvider amazonAWSCredentials() {
		return new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey));
	}

}
