package com.softserve.edu.lv251.dao;

import com.softserve.edu.lv251.entity.Doctors;
import com.softserve.edu.lv251.entity.Users;

import java.util.List;

/**
 * Created by Taras on 16.07.2017.
 */
public interface UsersDAO extends BaseDAO<Users>{
    List<Users> searchByLetters(String letters);
}
