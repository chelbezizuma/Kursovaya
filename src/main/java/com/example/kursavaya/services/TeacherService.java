package com.example.kursavaya.services;

import com.example.kursavaya.entity.Teacher;
import com.example.kursavaya.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> listTeacher() {
        return teacherRepository.findAll();
    }

    public List<String> listSubject() {
        return teacherRepository.findSubject();
    }

    public List<String> listTeacherSubject(String subject) {
        return teacherRepository.findTeacherSubject(subject);
    }
}
