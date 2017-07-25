package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.entity.Clinics;
import com.softserve.edu.lv251.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 */
@Controller
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    @RequestMapping(value = "/clinics/all", method = RequestMethod.GET)
    public String allClinics(Model model){
        model.addAttribute("clinics", clinicService.getAllClinics());
        return "clinics";
    }

    @RequestMapping(value = "/clinics/details", method = RequestMethod.GET)
    public String clinicDetails(@RequestParam(name = "id", required = true)long id, Model model){
        Clinics clinic = clinicService.getClinicByID(id);
        model.addAttribute("clinic", clinic);
        return "clinic_details";
    }


}
