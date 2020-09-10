package com.seu.ums.Controller;

import com.seu.ums.Entity.Phone;
import com.seu.ums.Service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/phones")
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    //Fetch all
    @RequestMapping("/all")
    public List<Phone> getAllPhone(){
        return phoneService.getAllPhone();
    }

    //Fetch one
    @RequestMapping("/{id}")
    public Optional<Phone> getPhone(@PathVariable int id){
        return phoneService.getPhone(id);

    }
    //Insert
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addPhone(@RequestBody Phone phone){
        phoneService.addPhone(phone);
    }

    //Update
    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public void updatePhone(@RequestBody Phone phone){
        phoneService.updatePhone(phone);
    }

    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deletePhone(@PathVariable int id){
        phoneService.deletePhone(id);
    }
}
