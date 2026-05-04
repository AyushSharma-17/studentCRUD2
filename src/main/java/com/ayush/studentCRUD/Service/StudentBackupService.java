package com.ayush.studentCRUD.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayush.studentCRUD.Dao.StudentBackup;
import com.ayush.studentCRUD.Repo.StudentBackupRepo;
import com.ayush.studentCRUD.Repo.StudentRepo;

import jakarta.transaction.Transactional;

@Service
public class StudentBackupService {
    @Autowired
    StudentBackupRepo studentBackupRepo;
    @Autowired
    StudentRepo studentRepo;

    @Transactional
    public void deleteStudentById(int id){
        studentRepo.findById(id).ifPresent(stu->{
            StudentBackup stuBackup= new StudentBackup();
            stuBackup.setId(stu.getId());
            stuBackup.setName(stu.getName());
            stuBackup.setEmail(stu.getEmail());
            studentBackupRepo.save(stuBackup);
            studentRepo.deleteById(id);
        });
    }

    public List<StudentBackup> getAllStudent() {
        return studentBackupRepo.findAll();
    }
}
