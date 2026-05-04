package com.ayush.studentCRUD.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayush.studentCRUD.Dao.StudentBackup;

@Repository
public interface StudentBackupRepo extends JpaRepository<StudentBackup, Integer> {
    
}
