package com.einfochips.student.dynamodb.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einfochips.student.dynamodb.entity.StudentDynamoDB;
import com.einfochips.student.dynamodb.exception.EntityNotFoundException;
import com.einfochips.student.dynamodb.repository.StudentDynamoDBRepository;

@Service
public class StudentDynamoDBServiceImpl implements StudentDynamoDBService {

	@Autowired
	private StudentDynamoDBRepository studentDynamoDBRepository;

	public StudentDynamoDB findById(String id) {
		Optional<StudentDynamoDB> studentDynamoDB = studentDynamoDBRepository.findById(id);
		if (studentDynamoDB.isPresent()) {
			return studentDynamoDB.get();
		} else {
			throw new EntityNotFoundException("Can't find student under given ID");
		}
	}

	public StudentDynamoDB create(StudentDynamoDB studentDynamoDB) {
		StudentDynamoDB std = new StudentDynamoDB();
		BeanUtils.copyProperties(studentDynamoDB, std);
		return studentDynamoDBRepository.save(std);
	}

	public StudentDynamoDB update(String id, StudentDynamoDB studentDynamoDB) {
		Optional<StudentDynamoDB> optUpdateStudent = studentDynamoDBRepository.findById(id);
		if (optUpdateStudent.isPresent()) {
			StudentDynamoDB updateStudent = optUpdateStudent.get();
			updateStudent.setFirstName(studentDynamoDB.getFirstName());
			updateStudent.setLastName(studentDynamoDB.getLastName());
			updateStudent.setEmail(studentDynamoDB.getEmail());
			updateStudent.setPhoneNumber(studentDynamoDB.getPhoneNumber());
			studentDynamoDBRepository.save(studentDynamoDB);
			return updateStudent;
		} else {
			throw new EntityNotFoundException("Student not present in the database");
		}
	}

	public void delete(String id) {
		Optional<StudentDynamoDB> studentDynamoDB = studentDynamoDBRepository.findById(id);
		if(studentDynamoDB.isPresent()) {
			studentDynamoDBRepository.deleteById(id);
		} else {
			throw new EntityNotFoundException("Student not present in the database");
		}
	}

	public Iterable<StudentDynamoDB> findAll() {
		return studentDynamoDBRepository.findAll();
	}

}
