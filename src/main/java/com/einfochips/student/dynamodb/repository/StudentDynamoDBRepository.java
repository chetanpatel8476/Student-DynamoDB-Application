package com.einfochips.student.dynamodb.repository;

import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import com.einfochips.student.dynamodb.entity.StudentDynamoDB;

@EnableScan
public interface StudentDynamoDBRepository extends DynamoDBCrudRepository<StudentDynamoDB, String> {

}
