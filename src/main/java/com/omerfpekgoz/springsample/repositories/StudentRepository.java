package com.omerfpekgoz.springsample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.omerfpekgoz.springsample.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findOne(Long id);

}
