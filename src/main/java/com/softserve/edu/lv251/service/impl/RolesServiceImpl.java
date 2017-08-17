package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.dao.RolesDAO;
import com.softserve.edu.lv251.entity.Role;
import com.softserve.edu.lv251.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesDAO rolesDAO;

    @Override
    public void addRole(Role role) {
        this.rolesDAO.addEntity(role);
    }

    @Override
    public void updateRole(Role role) {
        this.rolesDAO.updateEntity(role);
    }

    @Override
    public Role findByName(String name) {
        List<Role> roles = this.rolesDAO.getEntitiesByColumnNameAndValue("name", name);
        return roles.isEmpty() ? null : roles.get(0);
    }

    @Override
    public Role findById(Long roleId) {
        return this.rolesDAO.getEntityByID(roleId);
    }

    @Override
    public List<Role> getAllRoles() {
        return this.rolesDAO.getAllEntities();
    }
}
