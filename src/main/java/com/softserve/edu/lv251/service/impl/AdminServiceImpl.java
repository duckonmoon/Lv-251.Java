package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.dao.AdminDAO;
import com.softserve.edu.lv251.entity.Admin;
import com.softserve.edu.lv251.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kovalevskyy Vitaliy on 15.08.2017.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Override
    public Admin findByEmail(String email) {
        List<Admin> admin = adminDAO.getEntitiesByColumnNameAndValue("email", email);
        return admin.isEmpty() ? null : admin.get(0);
    }
}
