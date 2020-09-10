package com.seu.ums.Controller;

import com.seu.ums.Entity.Lecturer;
import com.seu.ums.Service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController 
@RequestMapping("/lecturers")
public class LecturerController {
    @Autowired
    private LecturerService lecturerService;

    //Fetch all
    @RequestMapping("/")
    public List<Lecturer> getAllLecturer(){
        return lecturerService.getAllLecturer();
    }

    //Fetch one
    @RequestMapping("/{id}")
    public Optional<Lecturer> getLecturer(@PathVariable long id){
        return lecturerService.getLecturer(id);

    }
    //Insert
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addLecturer(@RequestBody Lecturer lecturer){
        lecturerService.addLecturer(lecturer);
    }

    //Update
    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public void updateLecturer(@RequestBody Lecturer lecturer){
        lecturerService.updateLecturer(lecturer);
    }

    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteLecturer(@PathVariable long id){
        lecturerService.deleteLecturer(id);
    }
}
