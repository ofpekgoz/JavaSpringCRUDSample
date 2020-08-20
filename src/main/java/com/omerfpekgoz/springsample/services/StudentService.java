package com.omerfpekgoz.springsample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omerfpekgoz.springsample.dtos.StudentRequest;
import com.omerfpekgoz.springsample.model.Student;
import com.omerfpekgoz.springsample.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	public Optional<Student> findById(Long id) {
		return studentRepository.findById(id);
	}

	public Student addStudent(StudentRequest request) {
		Student student = new Student();
		student.setName(request.getName());
		student.setSurname(request.getSurname());
		return studentRepository.save(student);
	}

	public Student updatedStudent(Long id, StudentRequest request) {
		Student updatedStudent = Optional.ofNullable(studentRepository.findOne(id)).map(student -> {
			student.setName(request.getName());
			student.setSurname(request.getSurname());
			return student;
		}).get();
		return studentRepository.save(updatedStudent);
	}

	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
}
