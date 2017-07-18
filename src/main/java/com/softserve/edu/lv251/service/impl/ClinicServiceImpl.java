package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.dao.ClinicsDAO;
import com.softserve.edu.lv251.service.ClinicService;
import com.softserve.edu.lv251.entity.Clinics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Taras on 14.07.2017.
 */
@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    private ClinicsDAO clinicsDAO;


    public List<Clinics> getAll() {
        return clinicsDAO.getAllEntities();
    }

    public List<Clinics> getWithOffset(int offset, int limit) {
        return clinicsDAO.getWithOffsetOrderedByName(offset, limit);
    }

    public void addClinic(Clinics clinic) {
        clinicsDAO.addEntity(clinic);
    }

    public Clinics getFirst() {
        return clinicsDAO.getEntityByID(40L);
    }
}
