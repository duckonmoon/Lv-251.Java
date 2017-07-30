package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.dao.SpecializationDAO;
import com.softserve.edu.lv251.entity.Specialization;
import com.softserve.edu.lv251.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 29.07.2017.
 */
@Service
public class SpecializationServiceImpl implements SpecializationService {
    @Autowired
    private SpecializationDAO specializationDAO;
    @Override
    public List<Specialization> searchByLetters(String letters) {
        return specializationDAO.searchByLetters(letters);
    }
}