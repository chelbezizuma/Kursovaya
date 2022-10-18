package com.example.kursavaya.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "facultysAndSpecialitys")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultysAndSpecialitys {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facultysAndSpecialitysSEQUENCE")
    @Column(name = "_id")
    private Long id;
    @Column(name = "facultys")
    private String facultys;
    @Column(name = "specialitys")
    private String specialitys;

    public FacultysAndSpecialitys(String facultys, String specialitys) {
        this.facultys = facultys;
        this.specialitys = specialitys;
    }
}
