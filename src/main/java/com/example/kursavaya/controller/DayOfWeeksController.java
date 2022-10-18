package com.example.kursavaya.controller;

import com.example.kursavaya.entity.DayOfWeeks;
import com.example.kursavaya.services.DayOfWeeksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/dayOfWeeks")
public class DayOfWeeksController {
    private final DayOfWeeksService dayOfWeeksService;
    @CrossOrigin
    @GetMapping("/")
    public List<DayOfWeeks> listDayOfWeeks() {
        return dayOfWeeksService.listDayOfWeeks();
    }


}
