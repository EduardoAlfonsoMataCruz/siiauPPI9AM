package org.udg.siiau.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.udg.siiau.models.StudentModel;
import org.udg.siiau.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    //obtener todos los alumnos
    public ArrayList<StudentModel> getAllStudents(){
        return (ArrayList<StudentModel>) studentRepository.findAll();
    }
    //guardar estudiante
    public StudentModel saveStudent(StudentModel studentModel){
        //TODO: validate if code is unique
        //llamar a getStudentById
        if((studentRepository.findStudentModelByCode(studentModel.getCode()).isEmpty()) && (studentRepository.findStudentModelByEmail(studentModel.getEmail()).isEmpty())){
            return studentRepository.save(studentModel);
        } else if((studentRepository.findStudentModelByCode(studentModel.getCode()).isPresent())) {
            StudentModel studentErrorCode = new StudentModel();
            studentErrorCode.setId(-1L);
            return studentErrorCode;
        } else if((studentRepository.findStudentModelByEmail(studentModel.getEmail()).isPresent())){
            StudentModel studentErrorEmail = new StudentModel();
            studentErrorEmail.setEmail("-1L");
            return studentErrorEmail;
        }
        else{
            return null;
        }
    }
    //eliminar estudiante
    public String deleteStudent(Long id){
        //vamos a buscar si existe un estudiante con ese id
        if(studentRepository.findById(id).isPresent()) {
            //si existe lo eliminamos
            studentRepository.deleteById(id);
            return "student delete successfully";
        }
        else{
            //si no mandamos mensaje de error
            return "student not found with id="+id;
        }
    }
    //buscar por id
    public Optional<StudentModel> findStudentById(Long id){
        return studentRepository.findById(id);
    }
    //editar por id
    public StudentModel editById(StudentModel studentModel){
        return studentRepository.save(studentModel);
    }
    //buscar por code
    public Optional<StudentModel> findStudentByCode(String code){
        return studentRepository.findStudentModelByCode(code);
    }

    public Optional<StudentModel> findStudentByName(String name){
        return  studentRepository.findStudentModelByName(name);
    }
}
