package com.softserve.edu.lv251.controllers.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Taras on 05.08.2017.
 */
@RestController
@RequestMapping(value = "/rest/api/user")
public class UserRestController {

    @RequestMapping(value = "/appointments")
    String getAppointments(){
        return "sdfgfdgdsfga";
    }
    

}
