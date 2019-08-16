package com.test.regis.Repositories;

import com.test.regis.Entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
    public Student getStudentById(Long id);
    public Student getStudentByName(String name);
}
