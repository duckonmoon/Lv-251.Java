package com.softserve.edu.lv251;


import com.softserve.edu.lv251.config.DatabaseConfig;
import com.softserve.edu.lv251.dao.BaseDAO;
import com.softserve.edu.lv251.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Shmidt on 11.07.2017.
 */
@Component
public class App {


    @Autowired
    BaseDAO rolesDAO;


    private void start(String[] args){
        Roles roles = new Roles();
        roles.setName("testRole2");
        rolesDAO.addEntity(roles);
        List<Roles> roles_s = rolesDAO.getAllEntities();
        System.out.println("ok");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(DatabaseConfig.class);

        boolean a = annotationConfigApplicationContext.containsBean("testDao");

        App p = annotationConfigApplicationContext.getBean(App.class);
        p.start(args);
    }
}
