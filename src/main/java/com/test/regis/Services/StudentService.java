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

    public Student creatStudent(Student student){
        return studentRepository.save(student);
    }

    public Student getStudentById(long id) {
        return studentRepository.getStudentById(id);
    }

    public Student getStudentByName(String name){
        return studentRepository.getStudentByName(name);
    }

    public Iterable<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public void delete(long id){
        studentRepository.deleteById(id);
    }

    public void deleteAll(){
        studentRepository.deleteAll();
    }
}
