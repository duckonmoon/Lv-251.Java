package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.dto.pojos.ClinicSearchDTO;
import com.softserve.edu.lv251.dto.pojos.DistrictsDTO;
import com.softserve.edu.lv251.entity.Doctor;
import com.softserve.edu.lv251.entity.Specialization;
import com.softserve.edu.lv251.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
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
    @Autowired
    private SpecializationService specializationService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(ModelMap model, Principal principal, HttpServletRequest request) {


        if (principal != null) {
            request.getSession().setAttribute("username", userService.findByEmail(principal.getName()).getFirstname() + " " +
                    userService.findByEmail(principal.getName()).getLastname());
        }
        return "home";
    }

    @RequestMapping(value = "/all/clinics")
    @ResponseBody
    public List<ClinicSearchDTO> autocompleteClinics(@RequestParam("name") String name) {
        System.out.println(name);
        System.out.println(clinicService.searchByLetters(name));
        return clinicService.searchByLetters(name);
    }

    @ResponseBody
    @RequestMapping(value = "/search/clinics/{id}")
    public ClinicSearchDTO searchClinics(@PathVariable("id") Long id) {
        return clinicService.clinicSearchById(id);
    }


    @ResponseBody
    @RequestMapping(value = "/districts/byName")
    public List<DistrictsDTO> autocompletedistricts(@RequestParam("name") String name) {
        return districtsService.findByName(name);
    }

    @ResponseBody
    @RequestMapping(value = "/search/clinics/by/district/{name}")
    public List<ClinicSearchDTO> clinicsByDistrict(@PathVariable("name") String name) {
        return clinicService.findByDistrict(name);
    }

    @ResponseBody
    @RequestMapping(value = "/search/doctors/by/district/{name}")
    public List<Doctor> doctorsByDistrict(@PathVariable("name") String name) {
        return doctorsService.searchByDistrict(name);
    }

    @ResponseBody
    @RequestMapping(value = "/doc/by/spec")
    public List<Specialization> autocompleteSpec(@RequestParam("name") String name) {
        return specializationService.searchByLetters(name);
    }

    @ResponseBody
    @RequestMapping(value = "/search/doctors/by/spec/{name}")
    public List<Doctor> doctorsBySpec(@PathVariable("name") String name) {
        return doctorsService.searchBySpecialization(name);
    }


}
