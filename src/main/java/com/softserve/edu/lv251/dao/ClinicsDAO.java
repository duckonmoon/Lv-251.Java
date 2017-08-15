package com.softserve.edu.lv251.dao;


import com.softserve.edu.lv251.entity.Clinics;

import java.util.List;

/**
 *
 */
public interface ClinicsDAO extends BaseDAO<Clinics>{

 List<Clinics>findByDistrict(String name);

 List<Clinics>searchByLetters(String letters);

 List<Clinics>getWithOffsetAndLimit(int offset, int limit);

 List<Clinics>getByNameWithOffsetAndLimit(String value, int offset, int limit);

}
