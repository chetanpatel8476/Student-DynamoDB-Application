package com.einfochips.student.dynamodb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.einfochips.student.dynamodb.entity.StudentDynamoDB;
import com.einfochips.student.dynamodb.service.StudentDynamoDBServiceImpl;

@RestController
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
public class StudentDynamoDBController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentDynamoDBController.class);

	// @Autowired
	// private StudentDynamoDBRepository studentDynamoDBRepository;
	@Autowired
	private StudentDynamoDBServiceImpl studentDynamoDBServiceImpl;

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ResponseEntity<Iterable<StudentDynamoDB>> listAllStudents() {
		ResponseEntity<Iterable<StudentDynamoDB>> response = null;
		try {
			Iterable<StudentDynamoDB> students = studentDynamoDBServiceImpl.findAll();
			if (!students.iterator().hasNext()) {
				response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				response = new ResponseEntity<>(students, HttpStatus.OK);
			}
		} catch (Exception exception) {
			LOGGER.error("Exception in listAllStudnets method: {}", exception);
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("listAllStudents: response={} ", response);
		return response;
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public ResponseEntity<StudentDynamoDB> findStudentById(@PathVariable("id") String id) {
		ResponseEntity<StudentDynamoDB> response = null;
		try {
			StudentDynamoDB student = studentDynamoDBServiceImpl.findById(id);
			if (student == null) {
				response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				response = new ResponseEntity<>(student, HttpStatus.OK);
			}
		} catch (Exception exception) {
			LOGGER.error("Exception in findStudentById method: {}", exception);
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("findStudentById: response={} ", response);
		return response;
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentDynamoDB> createStudent(@RequestBody StudentDynamoDB studentDynamoDB) {
		ResponseEntity<StudentDynamoDB> response = null;
		try {
			StudentDynamoDB student = studentDynamoDBServiceImpl.create(studentDynamoDB);
			if (student == null) {
				response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				response = new ResponseEntity<>(student, HttpStatus.OK);
			}
		} catch (Exception exception) {
			LOGGER.error("Exception in createStudent method: {}", exception);
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("createStudent: response={} ", response);
		return response;
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentDynamoDB> updateStudent(@PathVariable("id") String id,
			@RequestBody StudentDynamoDB studentDynamoDB) {
		ResponseEntity<StudentDynamoDB> response = null;
		try {
			StudentDynamoDB student = studentDynamoDBServiceImpl.update(id, studentDynamoDB);
			response = new ResponseEntity<>(student, HttpStatus.OK);
		} catch (Exception exception) {
			LOGGER.error("Exception in updateStudent method: {}", exception);
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("createStudent: response={} ", response);
		return response;
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StudentDynamoDB> deleteStudent(@PathVariable("id") String id) {
		ResponseEntity<StudentDynamoDB> response = null;
		try {
			studentDynamoDBServiceImpl.delete(id);
			response = new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception exception) {
			LOGGER.error("Exception in deleteStudent method: {}", exception);
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("deleteStudent: response={} ", response);
		return response;
	}
}
