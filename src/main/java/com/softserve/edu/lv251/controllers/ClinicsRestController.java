package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.entity.Clinics;
import com.softserve.edu.lv251.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by Taras on 14.07.2017.
 */
@RestController
public class ClinicsRestController {

    @Autowired
    private ClinicService clinicService;


    @RequestMapping("/clinics")
    public List<Clinics> greeting(@RequestParam(value="offset", required=false, defaultValue="0") String offset,
                                  @RequestParam(value="limit", required=false, defaultValue="10") String limit) {

        int offsetInt = 0;
        int limitInt = 10;

        try {
            offsetInt = Integer.parseInt(offset);
            limitInt = Integer.parseInt(limit);
        }catch (NumberFormatException e){
            // TODO return error json maybe?
        }


        List<Clinics> list = clinicService.getWithOffset(offsetInt, limitInt);
        return list;
    }

    @RequestMapping("/firstclinic")
    public Clinics getFirst(){
        return clinicService.getFirst();
    }


}
