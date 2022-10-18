package com.example.kursavaya.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "times")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Times {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timesSEQUENCE")
    @Column(name = "_id")
    private Long id;
    @Column(name = "name")
    private String name;
}
