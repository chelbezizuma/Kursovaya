package com.example.kursavaya.repository;

import com.example.kursavaya.entity.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface SchedulesRepository extends JpaRepository<Schedules,Long> {
    @Query(value = "SELECT * FROM schedules WHERE schedules.teacher = :nameTeacher ;"
            , nativeQuery = true)
    List<Schedules> findByTeacher(String nameTeacher);


    @Query(value = "SELECT * FROM schedules WHERE schedules.subject = 'Физкультура';"
            , nativeQuery = true)
    List<Schedules> findByFizra();
    @Modifying
    @Transactional
    @Query(value = "delete  from schedules where schedules._id = :id"
            , nativeQuery = true)
    void delete(Long id);

    @Query(value = "select exists(select * from schedules\n" +
            "where \n" +
            "        time = :time and " +
            "        groups = :groups and " +
            "        day_of_week = :day_of_week " +
            "        and (parity_of_week = 'Р' " +
            "        or parity_of_week = :parity_of_week))"
            , nativeQuery = true)
    Boolean findByZanyatost(String time,String groups,String day_of_week,String parity_of_week);
}
