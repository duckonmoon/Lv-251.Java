package com.softserve.edu.lv251.service;

import com.softserve.edu.lv251.entity.Moderator;

/**
 * Created by Admin on 31.07.2017.
 */
public interface ModeratorService {
    Moderator getByEmail(String email);
}
