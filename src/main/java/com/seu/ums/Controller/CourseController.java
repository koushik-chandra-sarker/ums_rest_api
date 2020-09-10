package com.seu.ums.Controller;

import com.seu.ums.Entity.Course;
import com.seu.ums.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController 
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    //Fetch all
    @RequestMapping("/")
    public List<Course> getAllCourse(){

        return courseService.getAllCourse();
    }

    //Fetch one
    @RequestMapping("/{code}")
    public Optional<Course> getCourse(@PathVariable String code){
        return courseService.getCourse(code);

    }
    //Insert
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addCourse(@RequestBody Course course){
        courseService.addCourse(course);
    }

    //Update
    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public void updateCourse(@RequestBody Course course){
        courseService.updateCourse(course);
    }
    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{code}")
    public void deleteCourse(@PathVariable String code){
        courseService.deleteCourse(code);
    }


}
