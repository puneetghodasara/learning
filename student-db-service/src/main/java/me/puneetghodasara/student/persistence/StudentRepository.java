package me.puneetghodasara.student.persistence;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import me.puneetghodasara.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Stream<Student> findByName(String name);
}
