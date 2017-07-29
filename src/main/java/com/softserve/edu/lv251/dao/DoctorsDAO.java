package com.softserve.edu.lv251.dao;

import com.softserve.edu.lv251.entity.Appointments;
import com.softserve.edu.lv251.entity.Doctors;

import java.util.Date;
import java.util.List;

/**
 * Created by Taras on 16.07.2017.
 */
public interface DoctorsDAO extends BaseDAO<Doctors>{
    List<Doctors> searchByLetters(String letters);
    List<Appointments> appointmentsInThisMonth(Long id, Date date);
    List<Doctors>searchByDistrict(String name);
}
