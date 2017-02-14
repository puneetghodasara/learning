package me.puneetghodasara.student.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import me.puneetghodasara.boot.exception.CustomException;
import me.puneetghodasara.student.business.StudentService;
import me.puneetghodasara.student.model.Student;
import me.puneetghodasara.student.persistence.StudentRepository;
import me.puneetghodasara.validation.service.ValidatorService;

@Component("studentEndpoint")
public class StudentEndpointImpl implements StudentEndpoint {

	private static final Logger logger = Logger.getLogger(StudentEndpointImpl.class);

	@Resource
	private StudentService studentService;

	@Resource
	private StudentRepository studentRepository;

	@Resource
	private ValidatorService validatorService;

	@Override
	public Student registerStudent(Student student) {
		List<String> problems = validatorService.validate(student);
		if (problems != null && !problems.isEmpty()) {
			throw CustomException.getCMSException(problems);
		}

		return studentService.registerStudent(/* student.getName(), */student);
	}

	@Override
	public List<Student> listStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student listStudent(Long id) {
		return studentRepository.findOne(id);
	}

	@Override
	public Student listStudent(String name) {
		return studentService.findByName(name);
	}

}
