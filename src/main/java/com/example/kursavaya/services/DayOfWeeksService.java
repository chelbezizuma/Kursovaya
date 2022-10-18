package com.example.kursavaya.services;

import com.example.kursavaya.entity.DayOfWeeks;
import com.example.kursavaya.repository.DayOfWeeksRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DayOfWeeksService {
    private final DayOfWeeksRepository dayOfWeeksRepository;

    public List<DayOfWeeks> listDayOfWeeks() {
        return dayOfWeeksRepository.findAll();
    }
}
