package com.example.kursavaya.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teachersSEQUENCE")
    @Column(name = "_id")
    private Long id;
        @Column(name = "name")
        private String name;
        @Column(name = "faculty")
        private String faculty;
        @Column(name = "subject")
        private String subject;

    public Teacher(String name, String faculty, String subject) {
        this.name = name;
        this.faculty = faculty;
        this.subject = subject;
    }
}
