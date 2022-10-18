package com.example.kursavaya.repository;

import com.example.kursavaya.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TasksRepository extends JpaRepository<Tasks,Long> {
    @Query(value = "SELECT * FROM tasks WHERE tasks.id_schedule = :idSchedule ;"
            , nativeQuery = true)
    List<Tasks> findByScheduleId(Long idSchedule);


}
