package com.softserve.edu.lv251.dto;

import com.softserve.edu.lv251.dto.pojos.UserDTO;
import com.softserve.edu.lv251.entity.Users;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper extends ConfigurableMapper{

    @Override
    protected void configure(MapperFactory factory) {

        factory.classMap(UserDTO.class, Users.class)
                .field("firstName", "firstname")
                .field("lastName", "lastname")
                .field("password", "password")
                .field("email", "email")
                .exclude("matchingPassword")
                .byDefault().register();
    }
}
