package com.example.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.entity.Teacher;
import com.example.sms.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService service;

    @PostMapping("")
    public ResponseEntity<String> createTeacher(@RequestBody Teacher teacher){
        service.createTeacher(teacher);
        return new ResponseEntity<String>("Teacher registered successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable int id){
        Teacher teacher= service.getTeacher(id);
        return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher){
        Teacher updated_teacher= service.updateTeacher(teacher);
        return new ResponseEntity<Teacher>(updated_teacher, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable int id){
        service.deleteTeacher(id);
        return new ResponseEntity<String>("Teacher deleted successfully", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Teacher>> getAllTeacher(){
        return new ResponseEntity<List<Teacher>>(service.getAllTeacher(), HttpStatus.OK);
    }
}