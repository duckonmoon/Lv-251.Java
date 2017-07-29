package com.softserve.edu.lv251.service;

import com.softserve.edu.lv251.entity.Districts;

import java.util.List;

/**
 * Created by Admin on 29.07.2017.
 */
public interface DistrictsService {
    List<Districts> findByName(String name);
}
