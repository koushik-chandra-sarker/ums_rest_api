package com.seu.ums.Controller;

import com.seu.ums.Entity.Lecturer_Course;
import com.seu.ums.Service.Lecturer_CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/lecturer_courses")
public class LecturerCourseController {
    @Autowired
    private Lecturer_CourseService lecturer_courseService;

    //Fetch all
    @RequestMapping("/")
    public List<Lecturer_Course> getAllLecturer_Course(){
        return lecturer_courseService.getAllLecturer_Course();
    }

    //Fetch one
    @RequestMapping("/{ssn}")
    public Optional<Lecturer_Course> getLecturer_Course(@PathVariable String ssn){
        return lecturer_courseService.getLecturer_Course(ssn);

    }
    @RequestMapping("/lec/{lid}")
    public List<Lecturer_Course> getLecturer_Course(@PathVariable int lid){
        return lecturer_courseService.getAllLecturer_CourseByLId(lid);

    }
    //Insert
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addLecturer_Course(@RequestBody Lecturer_Course Lecturer_Course){
        String CCode=Lecturer_Course.getCourse().getCode();
        Long LId = Lecturer_Course.getLecturer().getId();
        Lecturer_Course.setSsn(LId+CCode);
        lecturer_courseService.addLecturer_Course(Lecturer_Course);
    }

    //Update
    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public void updateLecturer_Course(@RequestBody Lecturer_Course Lecturer_Course){
        lecturer_courseService.updateLecturer_Course(Lecturer_Course);
    }

    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{ssn}")
    public void deleteLecturer_Course(@PathVariable String ssn){
        lecturer_courseService.deleteLecturer_Course(ssn);
    }
}
