package com.example.kursavaya.services;

import com.example.kursavaya.entity.DayOfWeeks;
import com.example.kursavaya.entity.Times;
import com.example.kursavaya.repository.TimesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TimesService {

    private final TimesRepository timesRepository;

    public List<Times> listDayOfWeeks() {
        return timesRepository.findAll();
    }
}
