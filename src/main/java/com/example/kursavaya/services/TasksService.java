package com.example.kursavaya.services;

import com.example.kursavaya.entity.Tasks;
import com.example.kursavaya.repository.TasksRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TasksService {
    private final TasksRepository tasksRepository;

    public List<Tasks> listTasks() {
        return tasksRepository.findAll();
    }

    public void addTasksMap(Tasks tasks) {
        tasksRepository.save(tasks);
    }
}