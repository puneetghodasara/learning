package me.puneetghodasara.student.business;

import me.puneetghodasara.student.model.Student;
import me.puneetghodasara.student.persistence.StudentRepository;
import org.apache.log4j.Logger;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
// @CacheConfig()
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = Logger.getLogger(StudentServiceImpl.class);

    @Resource
    private StudentRepository studentRepository;

    @Override
    @Cacheable(key = "#name", cacheNames = "StudentCache")
    public Student findByName(String name) {
        logger.info("Querying DB to find student by name " + name);
        return studentRepository.findByName(name)
                .findFirst()
                .orElse(null);
    }

    @Override
    @CachePut(key = "#student.name", cacheNames = "StudentCache")
    public Student registerStudent(Student student) {
        logger.info("Creating new student " + student);
        return studentRepository.save(student);
    }

}
