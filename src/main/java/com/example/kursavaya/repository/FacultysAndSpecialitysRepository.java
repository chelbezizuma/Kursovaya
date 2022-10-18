package com.example.kursavaya.repository;

import com.example.kursavaya.entity.DayOfWeeks;
import com.example.kursavaya.entity.FacultysAndSpecialitys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FacultysAndSpecialitysRepository extends JpaRepository<FacultysAndSpecialitys,Long> {
    @Query(value = "SELECT DISTINCT facultys_and_specialitys.facultys FROM facultys_and_specialitys; "
            , nativeQuery = true)
    List<String> findDistinctByFacultys();

    @Query(value = "SELECT DISTINCT facultys_and_specialitys.specialitys FROM facultys_and_specialitys; "
            , nativeQuery = true)
    List<String> findDistinctBySpecialitys();
}
