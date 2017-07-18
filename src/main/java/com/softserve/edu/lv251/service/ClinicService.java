package com.softserve.edu.lv251.service;


import com.softserve.edu.lv251.entity.Clinics;

import java.util.List;

/**
 * Created by Taras on 14.07.2017.
 */
public interface ClinicService {

    public List<Clinics> getAll();
    public List<Clinics> getWithOffset(int offset, int limit);
    public void addClinic(Clinics clinic);
    public Clinics getFirst();


}
