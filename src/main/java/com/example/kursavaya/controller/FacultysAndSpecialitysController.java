package com.example.kursavaya.controller;

import com.example.kursavaya.entity.DayOfWeeks;
import com.example.kursavaya.entity.FacultysAndSpecialitys;
import com.example.kursavaya.entity.Tasks;
import com.example.kursavaya.repository.FacultysAndSpecialitysRepository;
import com.example.kursavaya.services.DayOfWeeksService;
import com.example.kursavaya.services.FacultysAndSpecialitysService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/facultysAndSpecialitys")
public class FacultysAndSpecialitysController {
    private final FacultysAndSpecialitysService facultysAndSpecialitysService;
    private final FacultysAndSpecialitysRepository facultysAndSpecialitysRepository;

    @CrossOrigin
    @GetMapping("/")
    public List<FacultysAndSpecialitys> listFacultysAndSpecialitys() {
        return facultysAndSpecialitysService.listFacultysAndSpecialitys();
    }

    @CrossOrigin
    @GetMapping("/facultys")
    public List<String> listFacultys() {
        return facultysAndSpecialitysRepository.findDistinctByFacultys();
    }

    @CrossOrigin
    @GetMapping("/specialitys")
    public List<String> listSpecialitys() {
        return facultysAndSpecialitysRepository.findDistinctBySpecialitys();
    }

    @CrossOrigin
    @PostMapping("/postFacultysAndSpecialitys")
    public void post(@RequestParam Map<String, String> facultysAndSpecialitysMap) {
        FacultysAndSpecialitys facultysAndSpecialitys = new FacultysAndSpecialitys(
                facultysAndSpecialitysMap.get("facultys"),
                facultysAndSpecialitysMap.get("specialitys")
        );
        System.out.println("POST \n " +facultysAndSpecialitysMap);
        facultysAndSpecialitysRepository.save(facultysAndSpecialitys);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void put(@PathVariable Long id,
                    @RequestParam Map<String, String> facultysAndSpecialitysMap) {
        System.out.println("PUT map \n"+facultysAndSpecialitysMap.toString());

        FacultysAndSpecialitys facultysAndSpecialitys = new FacultysAndSpecialitys(
                id,
                facultysAndSpecialitysMap.get("facultys"),
                facultysAndSpecialitysMap.get("specialitys")
        );
        System.out.println("POST \n " +facultysAndSpecialitysMap);
        facultysAndSpecialitysRepository.save(facultysAndSpecialitys);
    }
}
