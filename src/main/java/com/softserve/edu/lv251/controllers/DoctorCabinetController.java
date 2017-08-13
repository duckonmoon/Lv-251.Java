package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.config.Mapper;
import com.softserve.edu.lv251.dto.pojos.AppointmentsDTO;
import com.softserve.edu.lv251.entity.Appointments;
import com.softserve.edu.lv251.entity.Doctors;
import com.softserve.edu.lv251.entity.Users;
import com.softserve.edu.lv251.service.AppointmentService;
import com.softserve.edu.lv251.service.DoctorsService;
import com.softserve.edu.lv251.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Author: Vitaliy Kovalevskyy
 */
@Controller
public class DoctorCabinetController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserService userService;

    @Autowired
    private Mapper mapper;

    @Autowired
    private Logger logger;

    @Autowired
    private DoctorsService doctorsService;

    @RequestMapping(value = "/doctor/сabinet",method = RequestMethod.GET)
    public String home(ModelMap model,Principal principal){
        model.addAttribute("docApps",appointmentService.getAllDoctorsAppointmentsAfterNow(principal.getName(), Calendar.getInstance().getTime()));
        return "doctor_schedule";
    }

    @RequestMapping(value = "/doctor/cabinet/getApp", method = RequestMethod.POST)
    @ResponseBody
    public List<AppointmentsDTO> getApp(Principal principal) {
        List<AppointmentsDTO> appointmentsDTOs = new LinkedList<>();
        for (Appointments appo : appointmentService.getAppiontmentbyDoctorsEmail(principal.getName())) {
            AppointmentsDTO appointmentsDTO = new AppointmentsDTO();
            mapper.map(appo, appointmentsDTO);
            appointmentsDTOs.add(appointmentsDTO);
        }
        return appointmentsDTOs;
    }


    @RequestMapping(value = "/doctor/cabinet/setApp/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void setApp(@PathVariable(value = "id") long id) {
        Appointments appointments = appointmentService.getAppointmentById(id);
        appointments.setIsApproved(true);
        appointmentService.updateAppointment(appointments);
    }

    @RequestMapping(value = "/users/search")
    @ResponseBody
    public List<Users> getUsers(@RequestParam String name) {
        List<Users> userss = userService.searchByLetters(name);
        return userss;
    }

    @RequestMapping(value = "doctor/patients", method = RequestMethod.GET)
    public String patients() {
        return "doctor_cabinet_patients";
    }


    @RequestMapping(value = "/users/addApp", method = RequestMethod.POST)
    @ResponseBody
    public void addAppointment(HttpServletRequest request, Principal principal)
    {
        Date date;
        try {

            SimpleDateFormat isoFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
            isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            date = isoFormat.parse(request.getParameter("datatime"));

            if(date.before(new Date())){
                throw new Exception();
            }

            Appointments appointments = new Appointments();
            appointments.setAppointmentDate(date);
            appointments.setIsApproved(true);
            appointments.setUsers(userService.getUserByID(Long.parseLong(request.getParameter("input"))));
            appointments.setDoctors(doctorsService.findByEmail(principal.getName()));
            appointmentService.addAppointment(appointments);
        } catch (Exception e) {
            logger.error("Some Errors");
        }
    }


}
