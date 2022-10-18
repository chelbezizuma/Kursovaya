package com.example.kursavaya.repository;

import com.example.kursavaya.entity.Times;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimesRepository extends JpaRepository<Times,Long> {
}