package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.service.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Admin on 23.07.2017.
 */
@Controller
public class AllDoctorsController {
    @Autowired
    private DoctorsService doctorsService;
    @RequestMapping(value = "/allDoctors",method = RequestMethod.GET)
    public  String allDoctors(Model model){
        model.addAttribute("doctors",doctorsService.getAll());
        return "allDoctors";
    }
}
