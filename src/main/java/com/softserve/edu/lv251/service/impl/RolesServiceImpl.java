package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.dao.RolesDAO;
import com.softserve.edu.lv251.entity.Roles;
import com.softserve.edu.lv251.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesDAO rolesDAO;

    @Override
    public void addRole(Roles role) {
        this.rolesDAO.addEntity(role);
    }

    @Override
    public void updateRole(Roles role) {
        this.rolesDAO.updateEntity(role);
    }

    @Override
    public Roles findByName(String name) {
        List<Roles> roles = this.rolesDAO.getEntitiesByColumnNameAndValue("name", name);
        return roles.isEmpty() ? null : roles.get(0);
    }

    @Override
    public Roles findById(Long roleId) {
        return this.rolesDAO.getEntityByID(roleId);
    }

    @Override
    public List<Roles> getAllRoles() {
        return this.rolesDAO.getAllEntities();
    }
}
