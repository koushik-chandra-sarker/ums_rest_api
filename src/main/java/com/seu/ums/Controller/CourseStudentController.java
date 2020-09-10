package com.seu.ums.Controller;

import com.seu.ums.Entity.Course_Student;
import com.seu.ums.Service.CourseStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/student_courses")
public class CourseStudentController {
    @Autowired
    private CourseStudentService courseStudentService;

    //Fetch all
    @RequestMapping("/")
    public List<Course_Student> getAllCourse_Student(){
        return courseStudentService.getAllCourse_Student();
    }

    //Fetch one
    @RequestMapping("/{ssn}")
    public Optional<Course_Student> getCourse_Student(@PathVariable String ssn){
        return courseStudentService.getCourse_Student(ssn);

    }
    //Fetch one
    @RequestMapping("/std/{sid}")
    public List<Course_Student> getAllCourse_StudentBySId(@PathVariable int sid){
        return courseStudentService.getAllCourse_StudentBySId(sid);

    }

    //Insert
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addCourse_Student(@RequestBody Course_Student Course_Student){

        String CCode=Course_Student.getCourses().getSsn();
        Long LId = Course_Student.getStudent().getId();
        Course_Student.setSsn(LId+"-"+CCode);
        courseStudentService.addCourse_Student(Course_Student);
    }

    //Update
    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public void updateCourse_Student(@RequestBody Course_Student Course_Student){
        courseStudentService.updateCourse_Student(Course_Student);
    }

    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{ssn}")
    public void deleteCourse_Student(@PathVariable String ssn){
        courseStudentService.deleteCourse_Student(ssn);
    }
}
