package com.softserve.edu.lv251.controllers;

import com.google.gson.Gson;
import com.softserve.edu.lv251.config.Mapper;
import com.softserve.edu.lv251.dto.pojos.AppointmentsDTO;
import com.softserve.edu.lv251.entity.Appointments;
import com.softserve.edu.lv251.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: Vitaliy Kovalevskyy
 */
@Controller
public class DoctorCabinetController {

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    Mapper mapper;

    @RequestMapping(value = "/doctor/сabinet",method = RequestMethod.GET)
    public String home(ModelMap model){
        return "doctor_schedule";
    }

    @RequestMapping(value = "/doctor/cabinet/getApp", method = RequestMethod.POST)
    @ResponseBody
    public  List<AppointmentsDTO> getApp(Principal principal)
    {
        List<AppointmentsDTO> appointmentsDTOs = new LinkedList<>();
        for(Appointments appo: appointmentService.getAppiontmentbyDoctorsEmail(principal.getName())){
            AppointmentsDTO appointmentsDTO = new AppointmentsDTO();
            mapper.map(appo, appointmentsDTO);
            appointmentsDTOs.add(appointmentsDTO);
        }
        return appointmentsDTOs;
    }


    @RequestMapping(value = "/doctor/cabinet/setApp/{id}",method = RequestMethod.GET)
    @ResponseBody
    public void setApp(@PathVariable(value = "id") long id)
    {
        Appointments appointments = appointmentService.getAppointmentById(id);
        appointments.setStatus(true);
        appointmentService.updateAppointment(appointments);
    }

    @RequestMapping(value = "doctor/patients",method = RequestMethod.GET)
    public String patients(){
        return "doctor_cabinet_patients";
    }




}
