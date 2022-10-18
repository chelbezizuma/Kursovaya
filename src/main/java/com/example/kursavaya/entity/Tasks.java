package com.example.kursavaya.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TasksSEQUENCE")
    @Column(name = "_id")
    private Long id;
    @Column(name = "idSchedule")
    private Long idSchedule;
    @Column(name = "subject")
    private String subject;
    @Column(name = "groups")
    private String groups;
    @Column(name = "task")
    private String task;
    @Column(name = "deadlineStart")
    private String deadlineStart;
    @Column(name = "deadlineEnd")
    private String deadlineEnd;


    public Tasks(Long idSchedule, String subject, String groups, String task, String deadlineStart, String deadlineEnd) {
        this.idSchedule = idSchedule;
        this.subject = subject;
        this.groups = groups;
        this.task = task;
        this.deadlineStart = deadlineStart;
        this.deadlineEnd = deadlineEnd;
    }
}
