package com.seu.ums.Controller;

import com.seu.ums.Entity.Programme;
import com.seu.ums.Service.ProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/programmes")
public class ProgrammeController {
    @Autowired
    private ProgrammeService programmeService;

    //Fetch all
    @RequestMapping("/")
    public List<Programme> getAllProgramme(){
        return programmeService.getAllProgramme();
    }

    //Fetch one
    @RequestMapping("/{code}")
    public Optional<Programme> getProgramme(@PathVariable String code){
        return programmeService.getProgramme(code);

    }
    //Insert
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addProgramme(@RequestBody Programme programme){
        programmeService.addProgramme(programme);
    }

    //Update
    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public void updateProgramme(@RequestBody Programme programme){
        programmeService.updateProgramme(programme);
    }

    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{code}")
    public void deleteProgramme(@PathVariable String code){
        programmeService.deleteProgramme(code);
    }
}
