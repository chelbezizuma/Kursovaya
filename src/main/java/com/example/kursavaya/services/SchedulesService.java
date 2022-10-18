package com.example.kursavaya.services;

import com.example.kursavaya.entity.Schedules;
import com.example.kursavaya.repository.SchedulesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SchedulesService {
    private final SchedulesRepository schedulesRepository;

    public List<Schedules> listUser() {
        return schedulesRepository.findAll();
    }


    public void saveUser(Schedules schedules) {
        schedulesRepository.save(schedules);
    }

    public void addSchedulesMap(Schedules schedules) {
        schedulesRepository.save(schedules);
    }

    public List<Schedules> findByTeacher(String nameTeacher) {
        return schedulesRepository.findByTeacher(nameTeacher);
    }

}
