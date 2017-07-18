package com.softserve.edu.lv251.dao;


import com.softserve.edu.lv251.entity.Clinics;

import java.util.List;

/**
 * Created by Taras on 14.07.2017.
 */
public interface ClinicsDAO extends BaseDAO<Clinics>{
    public List<Clinics> getWithOffsetOrderedByName(int offset, int limit);
}
