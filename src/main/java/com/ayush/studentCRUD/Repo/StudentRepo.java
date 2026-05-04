package com.ayush.studentCRUD.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayush.studentCRUD.Dao.student;
@Repository
public interface StudentRepo extends JpaRepository<student,Integer> {
    
}
