package com.example.kursavaya.services;

import com.example.kursavaya.entity.FacultysAndSpecialitys;
import com.example.kursavaya.repository.FacultysAndSpecialitysRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FacultysAndSpecialitysService {
    private final FacultysAndSpecialitysRepository facultysAndSpecialitysRepository;

    public List<FacultysAndSpecialitys> listFacultysAndSpecialitys() {
        return facultysAndSpecialitysRepository.findAll();
    }
}
