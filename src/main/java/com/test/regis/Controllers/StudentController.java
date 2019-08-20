package com.test.regis.Controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.test.regis.Entities.Student;
import com.test.regis.Services.StudentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String test(){
        return "Hello";
    }

    @PostMapping("/save")
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        Student std = studentService.creatStudent(student);
        return new ResponseEntity<Student>(std,HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getStudentByName(@PathVariable String name){
        Student std = studentService.getStudentByName(name);
        if(std != null){
            return new ResponseEntity<Student>(std,HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Can not find student name: '"+name+"'",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getStudent(@PathVariable(required = true) long id){
        Student std = studentService.getStudentById(id);
        if(std != null){
            return new ResponseEntity<Student>(std,HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Can not find student id: "+id,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(required = true) long id){
        if(studentService.getStudentById(id) != null){
            studentService.delete(id);
            return new ResponseEntity<String>("Student id '"+"' is deleted",HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Can not find student id: "+id+" to delete",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<?> deleteAllStudent(){
        studentService.deleteAll();
        return new ResponseEntity<String>("Delete all student sucess",HttpStatus.OK);
    }



}
