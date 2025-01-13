package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents = new ArrayList<>();

    // Define @PostConstruct to load the student data ... only once!

    @PostConstruct
    public void loadData(){
        theStudents.add(new Student("Vlad","Ecobescu"));
        theStudents.add(new Student("Anisia","Love"));
        theStudents.add(new Student("Bogdan","Vasi"));
    }


    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // check the studentId

        if(studentId >= theStudents.size() || studentId < 0){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }


    // define endpoint for "/students" - return list of students

    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }
}
