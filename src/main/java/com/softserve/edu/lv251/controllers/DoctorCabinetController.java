package com.softserve.edu.lv251.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * Author: Vitaliy Kovalevskyy
 */
@Controller
public class DoctorCabinetController {
    @RequestMapping(value = "/doctor/сabinet",method = RequestMethod.GET)
    public String home(ModelMap model){
        return "doctor_schedule";
    }

    @RequestMapping(value = "/doctor/cabinet/getApp")
    @ResponseBody
    public String getApp(HttpServletResponse response)
    {
        return null;
    }
}