package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.entity.Clinics;
import com.softserve.edu.lv251.entity.Districts;
import com.softserve.edu.lv251.entity.Doctors;
import com.softserve.edu.lv251.service.ClinicService;
import com.softserve.edu.lv251.service.DistrictsService;
import com.softserve.edu.lv251.service.DoctorsService;
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
    @Autowired
    private DistrictsService districtsService;
    @Autowired
    private DoctorsService doctorsService;

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


    @ResponseBody
    @RequestMapping(value = "/districts/byName")
    public List<Districts> autocompletedistricts(@RequestParam("name")String name){
        System.out.println("in");
        System.out.println(districtsService.findByName(name));
        return  districtsService.findByName(name);
    }
    @ResponseBody
    @RequestMapping(value = "/search/clinics/by/district/{name}")
    public List<Clinics>clinicsByDistrict(@PathVariable("name")String name){
        System.out.println(clinicService.findByDistrict(name));
        return clinicService.findByDistrict(name);
    }

    @ResponseBody
    @RequestMapping(value = "/search/doctors/by/district/{name}")
    public List<Doctors>doctorsByDistrict(@PathVariable("name")String name){
        System.out.println(doctorsService.searchByDistrict(name));
        return doctorsService.searchByDistrict(name);
    }

}
