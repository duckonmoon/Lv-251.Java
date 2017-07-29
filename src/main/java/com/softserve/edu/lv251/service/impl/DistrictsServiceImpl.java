package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.dao.DistrictsDAO;
import com.softserve.edu.lv251.entity.Districts;
import com.softserve.edu.lv251.service.DistrictsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 29.07.2017.
 */
@Service
public class DistrictsServiceImpl implements DistrictsService{
    @Autowired
    private DistrictsDAO districtsDAO;
    @Override
    public List<Districts> findByName(String name) {
        return districtsDAO.findByName(name);
    }
}
