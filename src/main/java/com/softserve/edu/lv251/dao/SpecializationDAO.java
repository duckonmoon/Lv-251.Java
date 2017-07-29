package com.softserve.edu.lv251.dao;

import com.softserve.edu.lv251.entity.Specialization;

import java.util.List;

/**
 * Created by Admin on 21.07.2017.
 */
public interface SpecializationDAO extends BaseDAO<Specialization> {
    List<Specialization>searchByLetters(String letters);

}
