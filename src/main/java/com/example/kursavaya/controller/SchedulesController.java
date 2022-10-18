package com.example.kursavaya.controller;

import com.example.kursavaya.entity.Schedules;
import com.example.kursavaya.repository.SchedulesRepository;
import com.example.kursavaya.services.SchedulesService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/schedules")
public class SchedulesController {
    private final SchedulesService schedulesService;
    private final SchedulesRepository schedulesRepository;
    @CrossOrigin
    @GetMapping("/")
    public List<Schedules> getAllSchedules() {
        return schedulesService.listUser();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Schedules getSchedulesById(@PathVariable Long id) {
        System.out.println("    @GetMapping(\"/{id}\")\n");
        return schedulesRepository.findById(id).orElse(null);
    }

//    @CrossOrigin
//    @GetMapping("/getSchedules")
//    public Schedules getSchedules(@RequestParam() String login) {
//        if (schedulesService.getSchedules(login) != null)
//            return schedulesService.getSchedules(login);
//        else
//            return new Schedules(-1L,"Пользоватлеь не найден","Пользоватлеь не найден","Пользоватлеь не найден","Пользоватлеь не найден","Пользоватлеь не найден");
//    }

    @CrossOrigin
    @GetMapping("/teacherSchedules")
    public List<Schedules> findByTeacher(@RequestParam() String nameTeacher) {
        return schedulesService.findByTeacher(nameTeacher);
    }

    @CrossOrigin
    @GetMapping("/fizra")
    public List<Schedules> findByFizra() {
        return schedulesRepository.findByFizra();
    }

    @CrossOrigin
    @GetMapping("/zanyatost")
    public Boolean findByZanyatost(@RequestParam() String time, @RequestParam()String groups,
                                           @RequestParam()String day_of_week, @RequestParam()String parity_of_week) {
        System.out.println(time+" "+groups+" "+day_of_week+" "+parity_of_week);
        System.out.println(schedulesRepository.findByZanyatost(time,groups,day_of_week,parity_of_week));
        return schedulesRepository.findByZanyatost(time,groups,day_of_week,parity_of_week);
    }
    @CrossOrigin
    @PostMapping("/postSchedules")
    public void post(@RequestParam Map<String, String> schedulesMap) {
        Schedules users = new Schedules(
                schedulesMap.get("groups"),
                schedulesMap.get("dayOfWeek"),
                schedulesMap.get("time"),
                schedulesMap.get("subject"),
                schedulesMap.get("teacher"),
                schedulesMap.get("parity_of_week"),
                schedulesMap.get("typeOfActivity"),
                schedulesMap.get("office")

        );
        System.out.println("POST \n " +schedulesMap);
        schedulesService.addSchedulesMap(users);
    }

//    @CrossOrigin
//    @PostMapping("/putSchedules/{id}")
//    public void put(@RequestParam Map<String, String> schedulesMap) {
//        Schedules users = new Schedules(
//                schedulesMap.get("dayOfWeek"),
//                schedulesMap.get("groups"),
//                schedulesMap.get("time"),
//                schedulesMap.get("subject"),
//                schedulesMap.get("teacher")
//        );
//        System.out.println("POST \n"+schedulesMap);
////        schedulesService.addSchedulesMap(users);
//    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void put(@PathVariable Long id,
                    @RequestParam Map<String, String> schedulesMap) {
        Schedules users = new Schedules(
                id,
                schedulesMap.get("groups"),
                schedulesMap.get("dayOfWeek"),
                schedulesMap.get("time"),
                schedulesMap.get("subject"),
                schedulesMap.get("teacher"),
                schedulesMap.get("parity_of_week"),
                schedulesMap.get("typeOfActivity"),
                schedulesMap.get("office")
        );
        System.out.println("PUT \n"+users.toString());
        schedulesRepository.save(users);
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        schedulesRepository.delete(id);
    }
}
