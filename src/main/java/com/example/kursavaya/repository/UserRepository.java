package com.example.kursavaya.repository;

import com.example.kursavaya.entity.Schedules;
import com.example.kursavaya.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByLogin(String login);

    @Query(value = "SELECT DISTINCT users.group_id FROM users ;"
            , nativeQuery = true)
    List<String> distinctByGroup_id();

}
