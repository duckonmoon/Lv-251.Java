package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.entity.Clinics;
import com.softserve.edu.lv251.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Admin on 23.07.2017.
 */
@Controller
public class HomeController {
    @Autowired
    private ClinicService clinicService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(ModelMap model){
        return "home";
    }
    @RequestMapping(value = "/all/clinics")
    @ResponseBody
    public List<Clinics> autocompleteClinics(@RequestParam("name") String name){
        return  clinicService.getAllClinics();
    }
    @ResponseBody
    @RequestMapping(value = "/search/clinics/{id}")
    public Clinics searchClinics(@PathVariable ("id") Long id){
        return clinicService.getClinicByID(id);
    }

}
