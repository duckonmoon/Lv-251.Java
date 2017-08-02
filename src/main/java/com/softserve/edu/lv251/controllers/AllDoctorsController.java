package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.dto.pojos.DoctorImageDTO;
import com.softserve.edu.lv251.entity.Appointments;
import com.softserve.edu.lv251.entity.Doctors;
import com.softserve.edu.lv251.service.AppointmentService;
import com.softserve.edu.lv251.service.DoctorsService;
import com.softserve.edu.lv251.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Yana on 23.07.2017.
 */
@Controller
public class AllDoctorsController {
    @Autowired
    private DoctorsService doctorsService;
    @Autowired
    UserService userService;
    @Autowired
    AppointmentService appointmentService;

    @RequestMapping(value = "/allDoctors", method = RequestMethod.GET)
    public String allDoctors(Model model) {
        model.addAttribute("doctors", doctorsService.getAll());
        return "allDoctors";
    }

    @RequestMapping(value = "/allDoctors/{flag}/{docId}", method = RequestMethod.GET)
    public String allDoctors(Model model, @PathVariable(value = "flag") boolean flag,
                             @PathVariable(value = "docId") long docId) {
        model.addAttribute("doctors", doctorsService.getAll());
        model.addAttribute("flag", true);
        model.addAttribute("doc", docId);
        return "allDoctors";
    }

    @RequestMapping(value = "/user/addAppointment", method = RequestMethod.POST)
    public String addAppointment(Model modelMap, @RequestParam("datetime") String localdate, @RequestParam("doctorId") long doctorId, Principal principal) {
        Date date;

        //ModelAndView model = new ModelAndView("allDoctors");

        //model.addObject("doctors", doctorsService.getAll());
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(localdate.replace("T", " "));
            Appointments appointments = new Appointments();
            appointments.setAppointmentDate(date);
            appointments.setStatus(false);
            appointments.setUsers(userService.findByEmail(principal.getName()));
            appointments.setDoctors(doctorsService.find(doctorId));

            appointmentService.addAppointment(appointments);

        } catch (Exception e) {
            //model.setViewName("redirect:/allDoctors/true/" + doctorId);

            modelMap.addAttribute("flag", true);
            modelMap.addAttribute("doc", doctorId);

            return allDoctors(modelMap);
            //return model;
        }
        return allDoctors(modelMap);
        //return model;
    }

    @ResponseBody
    @RequestMapping(value = "/all/doc")
    public List<Doctors> searchDoctors(@RequestParam String name) {
        System.out.println(name);
        System.out.println(doctorsService.searchByLetters("Zyrr"));
        System.out.println(doctorsService.searchByLetters(name));
        return doctorsService.searchByLetters(name);

    }

    @ResponseBody
    @RequestMapping(value = "/search/{name}")
    public List<Doctors> searchAll(@PathVariable("name") String name) {
        System.out.println("in search ");
        System.out.println(name);
        return doctorsService.searchByLetters(name);

    }

    @ResponseBody
    @RequestMapping(value = "/searchResult/{id}")
    public Doctors s(@PathVariable Long id) {
        return doctorsService.find(id);
    }

    @RequestMapping(value = "/doctors/{id}", method = RequestMethod.GET)
    public String Doctor(@PathVariable Long id, Model model) {
        model.addAttribute("doctor", DoctorImageDTO.convert(doctorsService.find(id)));
        return "doctor_details";
    }
}
