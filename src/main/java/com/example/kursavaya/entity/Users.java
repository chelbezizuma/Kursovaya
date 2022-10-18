package com.example.kursavaya.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
    @Column(name = "_id")
    private Long id;
    @Column(name = "group_id")
    private String group_id;
    @Column(name = "role")
    private String role;
    @Column(name = "name")
    private String name;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    public Users(String group_id, String role, String name, String login, String password) {
        this.group_id = group_id;
        this.role = role;
        this.name = name;
        this.login = login;
        this.password = password;
    }
}
