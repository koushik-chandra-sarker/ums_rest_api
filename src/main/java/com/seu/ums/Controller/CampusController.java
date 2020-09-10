package com.seu.ums.Controller;

import com.seu.ums.Entity.Campus;
import com.seu.ums.Service.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/campuses")
public class CampusController {
    @Autowired
    private CampusService campusService;

    @RequestMapping("/")
    public List<Campus> getAllCampus(){
        return campusService.getAllCampus();
    }

    @RequestMapping("/{id}")
    public Optional<Campus> getCampus(@PathVariable int id){
        return campusService.getCampus(id);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addCampus(@RequestBody Campus campus){
        campusService.addCampus(campus);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public void updateCampus(@RequestBody Campus campus){
        campusService.updateCampus(campus);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteCampus(@PathVariable int id){
        campusService.deleteCampus(id);
    }
}
