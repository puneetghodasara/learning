package me.puneetghodasara.student.business;

import me.puneetghodasara.student.model.Student;

public interface StudentService {

    public Student findByName(String name);

    Student registerStudent(Student student);

}
