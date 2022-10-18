package com.example.kursavaya.repository;

import com.example.kursavaya.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    @Query(value = "SELECT DISTINCT teachers.subject FROM teachers; "
            , nativeQuery = true)
    List<String> findSubject();

    List<Teacher> findByName(String teacher);

    @Query(value = "SELECT teachers.name " +
                    " FROM  teachers" +
                    " WHERE teachers.subject = :subject ;"
            , nativeQuery = true)
    List<String> findTeacherSubject(String subject);

    @Query(value = "SELECT teachers.name " +
            " FROM  teachers" +
            " WHERE teachers.faculty = :faculty ;"
            , nativeQuery = true)
    List<String> findByFaculty(String faculty);
}
