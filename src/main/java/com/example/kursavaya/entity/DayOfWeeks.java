package com.example.kursavaya.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "dayOfWeeks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayOfWeeks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dayOfWeeksSEQUENCE")
    @Column(name = "_id")
    private Long id;
    @Column(name = "name")
    private String name;
}
