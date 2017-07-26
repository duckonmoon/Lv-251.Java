package com.softserve.edu.lv251.service;


import com.softserve.edu.lv251.entity.Roles;

import java.util.List;

/**
 * Added by Pavlo Kuchereshko.
 *
 */
public interface RolesService {

    void addRole(Roles role);

    void updateRole(Roles role);

    Roles findByName(String name);

    Roles findById(Long roleId);

    List<Roles> getAllRoles();
}
