package com.softserve.edu.lv251.service;

import com.softserve.edu.lv251.dto.pojos.ClinicLatLngDTO;

import java.util.List;

/**
 * Created by Taras on 27.07.2017.
 */

public interface MapService {
    public List<ClinicLatLngDTO> getAllClinicsCoordinates();
}
