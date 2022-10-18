package com.example.kursavaya.controller;

import com.example.kursavaya.entity.Schedules;
import com.example.kursavaya.entity.Tasks;
import com.example.kursavaya.repository.TasksRepository;
import com.example.kursavaya.services.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/tasksSchedules")
public class TasksController {
    private final TasksService tasksService;
    private final TasksRepository tasksRepository;

    @CrossOrigin
    @GetMapping("/")
    public List<Tasks> getAllTasks() {
        return tasksService.listTasks();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Tasks getSchedulesById(@PathVariable Long id) {
        System.out.println("@GetMapping(\"/{id}\")\n");
        return tasksRepository.findById(id).orElse(null);
    }

    @CrossOrigin
    @GetMapping("/taskForSubject/{id}")
    public List<Tasks> getAllTasksInSubject(@PathVariable Long id) {
        return tasksRepository.findByScheduleId(id);
    }

    @CrossOrigin
    @PostMapping("/postTasks")
    public void post(@RequestParam Map<String, String> tasksMap) {
        Tasks task = new Tasks(
                Long.valueOf(tasksMap.get("id_schedule")),
                tasksMap.get("subject"),
                tasksMap.get("groups"),
                tasksMap.get("task"),
                tasksMap.get("deadline_start"),
                tasksMap.get("deadline_end")
        );
        System.out.println("POST \n " +tasksMap);
        tasksService.addTasksMap(task);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void put(@PathVariable Long id,
                    @RequestParam Map<String, String> tasksMap) {
        Tasks task = new Tasks(
                id,
                Long.valueOf(tasksMap.get("id_schedule")),
                tasksMap.get("subject"),
                tasksMap.get("groups"),
                tasksMap.get("task"),
                tasksMap.get("deadline_start"),
                tasksMap.get("deadline_end")
        );
        System.out.println("PUT map \n"+tasksMap.toString());
        System.out.println("PUT \n"+task.toString());
        tasksRepository.save(task);
    }

}
