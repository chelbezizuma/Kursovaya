package com.example.kursavaya.repository;

import com.example.kursavaya.entity.DayOfWeeks;
import com.example.kursavaya.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayOfWeeksRepository extends JpaRepository<DayOfWeeks,Long> {
}
