package com.softserve.edu.lv251.controllers.rest;

import com.softserve.edu.lv251.dto.pojos.ClinicLatLngDTO;
import com.softserve.edu.lv251.service.ClinicService;
import com.softserve.edu.lv251.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Taras on 27.07.2017.
 */
@RestController
@RequestMapping("/rest/clinics")
public class ClinicRestController {

    @Autowired
    private MapService mapService;

    @Autowired
    private ClinicService clinicService;

    @RequestMapping("/map/all")
    List<ClinicLatLngDTO> mapAllLocations() {
        return mapService.getAllClinicsCoordinates();
    }


}
