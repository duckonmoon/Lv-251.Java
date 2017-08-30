package com.softserve.edu.lv251.controllers.rest;

import com.softserve.edu.lv251.dto.pojos.DoctorDTO;
import com.softserve.edu.lv251.dto.pojos.DoctorInfoDTO;
import com.softserve.edu.lv251.dto.pojos.UserDTO;
import com.softserve.edu.lv251.dto.pojos.UserUpdate;
import com.softserve.edu.lv251.service.DoctorsService;
import com.softserve.edu.lv251.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yana Martynyak on 29.08.2017.
 */
@CrossOrigin(origins = {"*"})
@Controller
public class UserEditController {
    @Autowired
  private UserService userService;
    @Autowired
    private DoctorsService doctorsService;

    @ResponseBody
    @RequestMapping(value = "/api/editUser/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> saveUser(@RequestBody UserUpdate user, @PathVariable("id") Long id) {
        System.out.println(id);
        System.out.println(user.getId());
        System.out.println(user);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/api/getDoctorsToUser/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<DoctorInfoDTO>> getDoctors(@PathVariable("id") Long id) {
        return new ResponseEntity<List<DoctorInfoDTO>>(doctorsService.getDoctorsByUser(id),HttpStatus.OK);

    }
}