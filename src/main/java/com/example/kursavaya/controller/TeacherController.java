package com.example.kursavaya.controller;

import com.example.kursavaya.entity.FacultysAndSpecialitys;
import com.example.kursavaya.entity.Teacher;
import com.example.kursavaya.repository.TeacherRepository;
import com.example.kursavaya.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    private final TeacherRepository teacherRepository;
    @CrossOrigin
    @GetMapping("/")
    public List<Teacher> getAllTeacher() {
        return teacherService.listTeacher();
    }

    @CrossOrigin
    @GetMapping("/subject")
    public List<String> getSubject() {
        return teacherService.listSubject();
    }

    @CrossOrigin
    @GetMapping("/teacherSubject")
    public List<String> getTeacherSubject(@RequestParam() String subject) {
        return teacherService.listTeacherSubject(subject);
    }
    @CrossOrigin
    @GetMapping("/teacherName")
    public List<Teacher> getTeacher(@RequestParam() String teacher) {
        return teacherRepository.findByName(teacher);
    }


    @CrossOrigin
    @GetMapping("/filterTeachers")
    public List<String> listTeacherFaculty(@RequestParam() String faculty) {
        return teacherRepository.findByFaculty(faculty);
    }

    @CrossOrigin
    @PostMapping("/postTeacher")
    public void post(@RequestParam Map<String, String> teacherMap) {
        Teacher teacher = new Teacher(
                teacherMap.get("name"),
                teacherMap.get("faculty"),
                teacherMap.get("subject")
        );
        System.out.println("POST \n " +teacherMap);
        teacherRepository.save(teacher);
    }

    @CrossOrigin
    @RequestMapping(value = "/putTeacher/{id}", method = RequestMethod.PUT)
    public void put(@PathVariable Long id,
                    @RequestParam Map<String, String> teacherMap) {
        System.out.println("PUT map \n"+teacherMap.toString());

        Teacher teacher = new Teacher(
                id,
                teacherMap.get("name"),
                teacherMap.get("faculty"),
                teacherMap.get("subject")
        );
        System.out.println("PUT \n " +teacher);
        teacherRepository.save(teacher);
    }
}
