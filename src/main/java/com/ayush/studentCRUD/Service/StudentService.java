package com.ayush.studentCRUD.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayush.studentCRUD.Dao.student;
import com.ayush.studentCRUD.Repo.StudentRepo;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public List<student> saveStudent(List<student> students){
        return studentRepo.saveAll(students);
    }

    public List<student> getAllStudent(){
        return studentRepo.findAll();
    }

    public student getStudentById(int id) {
        return studentRepo.findById(id).get();
    }

    public student updateStudent(int id, student student){
        return studentRepo.findById(id).map(stu->{
            stu.setName(student.getName());
            stu.setEmail(student.getEmail());
            return studentRepo.save(stu);
        }).orElse(null);
    }

    public student DeleteStudentById(int id) {
       return studentRepo.findById(id).map(stu->{
        studentRepo.delete(stu);
        return stu;
       }).orElse(null);
    }
}
