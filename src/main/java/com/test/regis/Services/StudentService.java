package com.test.regis.Services;

import com.test.regis.Entities.Student;
import com.test.regis.Repositories.StudentRepository;
import javassist.NotFoundException;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sun.security.provider.certpath.OCSPResponse;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void save(Student student){
        studentRepository.save(student);
    }

    public void update(long id , Student student){
        studentRepository.save(student);
    }

    public Optional<Student> getStudentById(long id) {
        return studentRepository.findById(id);
    }

    public void delete(long id){
        studentRepository.deleteById(id);
    }
}
