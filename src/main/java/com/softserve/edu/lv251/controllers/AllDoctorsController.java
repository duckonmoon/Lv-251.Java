package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.dto.pojos.DoctorImageDTO;
import com.softserve.edu.lv251.entity.Doctors;
import com.softserve.edu.lv251.service.DoctorsService;
import com.softserve.edu.lv251.service.PagingSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yana on 23.07.2017.
 */
@Controller
public class AllDoctorsController {

    @Autowired
    private DoctorsService doctorsService;

    @Autowired
    @Qualifier("doctorService")
    private PagingSizeService<Doctors> pagingSizeService;

    @RequestMapping(value = "/allDoctors/{current}",method = RequestMethod.GET)
    public  String allDoctors(@PathVariable("current") Integer chainIndex, Model model){
        model.addAttribute("getDoctors", pagingSizeService.getEntity(chainIndex, 10));
        model.addAttribute("numberChain", pagingSizeService.numberOfPaging(10));
//        model.addAttribute("doctors",doctorsService.getAll());
        return "allDoctors";
    }
    @ResponseBody
    @RequestMapping(value = "/all/doc")
    public List<Doctors> searchDoctors(@RequestParam String name){
        System.out.println(name);
        System.out.println(doctorsService.searchByLetters("Zyrr"));
        System.out.println(doctorsService.searchByLetters(name));
        return doctorsService.searchByLetters(name);

    }
    @ResponseBody
    @RequestMapping(value = "/search/{name}")
    public List<Doctors> searchAll(@PathVariable("name") String name){
        System.out.println("in search ");
        System.out.println(name);
        return doctorsService.searchByLetters(name);

    }
    @ResponseBody
    @RequestMapping(value = "/searchResult/{id}")
    public Doctors s(@PathVariable Long id){
        return  doctorsService.find(id);
    }

    @RequestMapping(value = "/doctors/{id}",method = RequestMethod.GET)
    public String Doctor(@PathVariable Long id, Model model){
        model.addAttribute("doctor", DoctorImageDTO.convert(doctorsService.find(id)));
        return "doctor_details";
    }
}
