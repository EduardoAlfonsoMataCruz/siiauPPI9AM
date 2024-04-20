package org.udg.siiau.controllers;

import org.hibernate.tool.schema.spi.SchemaTruncator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.udg.siiau.models.StudentModel;
import org.udg.siiau.services.StudentService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/students") //localhost:8080/students
public class StudentController {

    //crear instancia de Student Service
    @Autowired
    StudentService studentService;

    //get
    @GetMapping()
    public ArrayList<StudentModel> getAllStudents(){
        return studentService.getAllStudents();
    }

    //post
    @PostMapping()
    public StudentModel saveStudent(@RequestBody StudentModel student){
        return studentService.saveStudent(student);
    }

    //delete
    @DeleteMapping("/delete-student-by-id")
    public String deleteStudentById(@RequestParam("id") Long id){
        return studentService.deleteStudent(id);
    }

    @PutMapping()
    public StudentModel editStudent(@RequestBody StudentModel student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/findStudentById/{id}")
    public Optional<StudentModel> findStudentById(@PathVariable Long id){
        return studentService.findStudentById(id);
    }
    @GetMapping("/findStudentByCode/{code}")
    public Optional<StudentModel> findStudentByCode(@PathVariable String code){
        return studentService.findStudentByCode(code);
    }
    @GetMapping("/findStudentByName/{name}")
    public Optional<StudentModel> findStudentByName(@PathVariable String name){
        return  studentService.findStudentByName(name);
    }
}
