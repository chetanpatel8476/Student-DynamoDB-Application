package com.einfochips.student.dynamodb.service;

import com.einfochips.student.dynamodb.entity.StudentDynamoDB;

public interface StudentDynamoDBService {

	public StudentDynamoDB findById(String id);

	public StudentDynamoDB create(StudentDynamoDB studentDynamoDB);

	public StudentDynamoDB update(String id, StudentDynamoDB studentDynamoDB);

	public void delete(String id);

	public Iterable<StudentDynamoDB> findAll();
}
