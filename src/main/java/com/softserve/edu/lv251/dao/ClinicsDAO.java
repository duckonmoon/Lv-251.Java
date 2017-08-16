package com.softserve.edu.lv251.dao;


import com.softserve.edu.lv251.entity.Clinic;

import java.util.List;

/**
 *
 */
public interface ClinicsDAO extends BaseDAO<Clinic>{

 List<Clinic>findByDistrict(String name);

 List<Clinic>searchByLetters(String letters);

 List<Clinic>getWithOffsetAndLimit(int offset, int limit);

 List<Clinic>getByNameWithOffsetAndLimit(String value, int offset, int limit);

}
