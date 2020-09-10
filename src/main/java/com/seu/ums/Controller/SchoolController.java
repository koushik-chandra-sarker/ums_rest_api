package com.seu.ums.Controller;

import com.seu.ums.Entity.School;
import com.seu.ums.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @RequestMapping("/")
    public List<School> getAllSchool(){
        return schoolService.getAllSchool();
    }

    @RequestMapping("/{id}")
    public Optional<School> getSchool(@PathVariable int id){
        return schoolService.getSchool(id);

    }

    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public void addSchool(@RequestBody School school){
        System.out.println(school);
        schoolService.addSchool(school);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public void updateSchool(@RequestBody School school){
        schoolService.updateSchool(school);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteSchool(@PathVariable int id){
        schoolService.deleteSchool(id);
    }

}
