package com.ayush.studentCRUD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.studentCRUD.Dao.StudentBackup;
import com.ayush.studentCRUD.Dao.student;
import com.ayush.studentCRUD.Service.StudentBackupService;
import com.ayush.studentCRUD.Service.StudentService;





@RestController
@RequestMapping("/students")
public class studentController {
    @Autowired
    StudentService studentService;
    @Autowired
    StudentBackupService studentBackupService;

    @PostMapping("/addstudent")
    public List<student> addStudent(@RequestBody List<student> students) {
        
        return studentService.saveStudent(students);
    }

    @GetMapping("/getstudent")
    public List<student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/getstudent/{id}")
    public student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/updatestudent/{id}")
    public student updateStudent(@PathVariable int id, @RequestBody student student) { 
        return studentService.updateStudent(id,student);
    }
    
    @DeleteMapping("/deletestudent/{id}")
    public student deleteStudentById(@PathVariable int id){
        return studentService.DeleteStudentById(id);
    }
    
    @DeleteMapping("/deletestudentbyid/{id}")
    public String deleteStudentByIdwithBackup(@PathVariable int id){
     studentBackupService.deleteStudentById(id);
        return "Student with id "+id+" deleted successfully";
    }

    @GetMapping("/getstudentbackup")
    public List<StudentBackup> getAllStudentBackup(){
        return studentBackupService.getAllStudent();
    }
}
