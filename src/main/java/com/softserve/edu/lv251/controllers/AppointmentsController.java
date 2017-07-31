package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.entity.Appointments;
import com.softserve.edu.lv251.entity.Users;
import com.softserve.edu.lv251.service.AppointmentService;
import com.softserve.edu.lv251.service.DoctorsService;
import com.softserve.edu.lv251.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kilopo on 31.07.2017.
 */
@Controller
public class AppointmentsController {

    @Autowired
    private UserService userService;
    @Autowired
    private DoctorsService doctorsService;
    @Autowired
    private AppointmentService appointmentService;


    @RequestMapping(value = "/user/addAppointment", method = RequestMethod.POST)
    public String addAppointment(@RequestParam("datetime") String localdate, @RequestParam("doctorId") long doctorId, Principal principal) {
        Date date;

        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(localdate.replace("T", " "));
            Appointments appointments = new Appointments();
            appointments.setAppointmentDate(date);
            appointments.setStatus(false);
            appointments.setUsers(userService.findByEmail(principal.getName()));
            appointments.setDoctors(doctorsService.find(doctorId));

            appointmentService.addAppointment(appointments);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return "home";
    }

}
