package com.softserve.edu.lv251.idl;

import com.softserve.edu.lv251.entity.Roles;
import com.softserve.edu.lv251.entity.Users;
import com.softserve.edu.lv251.service.RolesService;
import com.softserve.edu.lv251.service.UserService;
import com.softserve.edu.lv251.service.impl.StoredImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.Arrays;

/**
 * Added by Pavlo Kuchereshko.
 *
 */
@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent>{

    private boolean isAlreadySetup = false;
    @Autowired
    RolesService rolesService;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (isAlreadySetup) return;

        for (WebRoles webRoles : WebRoles.values()) {
            String name = webRoles.name();
            createRoleIfNotFound(name);
        }

        isAlreadySetup = true;
    }

    private void createRoleIfNotFound(String name) {
        Roles role = this.rolesService.findByName(name);

        if (role == null) {
            role = new Roles();
            role.setName(name);
            this.rolesService.addRole(role);
        }
    }
}
