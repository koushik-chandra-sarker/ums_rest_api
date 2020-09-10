package com.seu.ums.Controller;

import com.seu.ums.Entity.Student;
import com.seu.ums.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController 
@RequestMapping("/students")
public class StudentController{
    @Autowired
    private StudentService studentService;

    //Fetch all
    @RequestMapping("/")
    public List<Student> getAllStudent(){

        return studentService.getAllStudent();
    }

    //Fetch one
    @RequestMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable Long id){
        return studentService.getStudent(id);

    }
    //Insert
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addStudent(@RequestBody Student Student){
        studentService.addStudent(Student);
    }

    //Update
    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public void updateStudent(@RequestBody Student Student){
        studentService.updateStudent(Student);
    }

    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
    }
}
