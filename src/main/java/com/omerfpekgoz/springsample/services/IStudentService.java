package com.omerfpekgoz.springsample.services;

import java.util.List;
import java.util.Optional;

import com.omerfpekgoz.springsample.dtos.StudentRequest;
import com.omerfpekgoz.springsample.model.Student;

public interface IStudentService {

	List<Student> getAllStudent();

	Student addStudent(StudentRequest request);

	Optional<Student> findById(Long id);

	Student updatedStudent(Long id, StudentRequest request);

	void deleteStudent(Long id);

}
