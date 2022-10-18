package com.example.kursavaya.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "schedules")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedules {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedulesSEQUENCE")
    @Column(name = "_id")
    private Long id;
    @Column(name = "groups")
    private String groups;
    @Column(name = "dayOfWeek")
    private String dayOfWeek;
    @Column(name = "time")
    private String time;
    @Column(name = "subject")
    private String subject;
    @Column(name = "teacher")
    private String teacher;

    @Column(name = "parityOfWeek")
    private String parityOfWeek;

    @Column(name = "typeOfActivity")
    private String typeOfActivity;

    @Column(name = "office")
    private String office;


    public Schedules(String groups, String dayOfWeek, String time, String subject, String teacher, String parityOfWeek, String typeOfActivity, String office) {
        this.groups = groups;
        this.dayOfWeek = dayOfWeek;
        this.time = time;
        this.subject = subject;
        this.teacher = teacher;
        this.parityOfWeek = parityOfWeek;
        this.typeOfActivity = typeOfActivity;
        this.office = office;
    }
}
