package me.puneetghodasara.student.persistence;

import me.puneetghodasara.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Stream<Student> findByName(String name);
}
