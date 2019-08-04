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
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String test(){
        return "Hello";
    }

    @PostMapping("/save")
    public ResponseEntity<Object> createStudent(@RequestBody Student student){
        studentService.save(student);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getStudent(@PathVariable(required = true) long id){
        Optional<Student> std = studentService.getStudentById(id);
        if(std.isPresent()){
            return ResponseEntity.ok().body(std.get());
        }else{
            return new ResponseEntity("Can not find student id: "+id,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable(required = true) long id){
        if(studentService.getStudentById(id).isPresent()){
            studentService.delete(id);
            return ResponseEntity.ok().build();
        }else{
            return new ResponseEntity("Can not find student id: "+id+" to delete",HttpStatus.NOT_FOUND);
        }
    }



}
