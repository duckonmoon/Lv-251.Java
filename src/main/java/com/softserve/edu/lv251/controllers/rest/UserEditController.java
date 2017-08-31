package com.softserve.edu.lv251.controllers.rest;

import com.softserve.edu.lv251.dto.pojos.*;
import com.softserve.edu.lv251.service.DoctorService;
;
import com.softserve.edu.lv251.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yana Martynyak on 29.08.2017.
 */

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = {"*"})
public class UserEditController {

    @Autowired
  private UserService userService;

    @Autowired
    private DoctorService doctorService;



    @RequestMapping(value = "/editUser/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> saveUser(@RequestBody UserUpdate user, @PathVariable("id") Long id) {
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @RequestMapping(value = "/getDoctorsToUser/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<DoctorRespondDTO>> getDoctors(@PathVariable("id") Long id) {
        List<DoctorRespondDTO> list=doctorService.getDoctorsByUser(id);
        return new ResponseEntity<List<DoctorRespondDTO>>(list,HttpStatus.OK);

    }
    @RequestMapping(value = "/getAppointmentsToUser/{id}", method = RequestMethod.GET)
   public  ResponseEntity<List<AppointmentsInfoDTO>> getAppointments(@PathVariable ("id") Long id){
       List<AppointmentsInfoDTO> list=new LinkedList<>();
       AppointmentsInfoDTO appointmentsInfoDTO= new AppointmentsInfoDTO(1,new Date(),"Petro","Ivanovych","Hiryrg",true);
        AppointmentsInfoDTO app2= new AppointmentsInfoDTO(2,new Date(),"Petro","Ivanovych","Hiryrg",false);
       list.add(appointmentsInfoDTO);
        System.out.println(new Date());
       list.add(app2);
        return new ResponseEntity<List<AppointmentsInfoDTO>>(list,HttpStatus.OK);
   }

}