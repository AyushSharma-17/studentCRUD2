package com.ayush.studentCRUD.Dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class StudentBackup {
    @Id
    private int id;
    private String name;
    private String email;
}
