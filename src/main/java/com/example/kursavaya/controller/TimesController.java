package com.example.kursavaya.controller;

import com.example.kursavaya.entity.DayOfWeeks;
import com.example.kursavaya.entity.Times;
import com.example.kursavaya.services.DayOfWeeksService;
import com.example.kursavaya.services.TimesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/times")
public class TimesController {
    private final TimesService timesService;
    @CrossOrigin
    @GetMapping("/")
    public List<Times> listDayOfWeeks() {
        return timesService.listDayOfWeeks();
    }
}
