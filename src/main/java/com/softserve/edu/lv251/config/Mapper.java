package com.softserve.edu.lv251.config;

import com.softserve.edu.lv251.dto.pojos.*;
import com.softserve.edu.lv251.entity.Clinics;

import com.softserve.edu.lv251.entity.Doctors;
import com.softserve.edu.lv251.entity.Moderator;

import com.softserve.edu.lv251.entity.Contacts;

import com.softserve.edu.lv251.entity.Users;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
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

        factory.classMap(PersonalInfoDTO.class, Users.class)
                .field("firstname", "firstname")
                .field("lastname", "lastname")
                .field("email", "email")
                .byDefault().register();



        factory.classMap(PersonalInfoDTO.class, Contacts.class)
                .field("address", "address")
                .field("city", "city")
                .field("zipCode", "zipCode")
                .field("firstPhone", "firstPhone")
                .field("secondPhone", "secondPhone")
                .field("thirdPhone", "thirdPhone")
                .byDefault().register();


        factory.classMap(ClinicInfoDTO.class,Clinics.class)
                .field("clinic_name","clinic_name")
                .field("description","description")
                .byDefault().register();

         factory.classMap(ClinicInfoDTO.class,Contacts.class)
                 .field("address", "address")
                 .field("city", "city")
                 .field("zipCode", "zipCode")
                 .field("firstPhone", "firstPhone")
                 .field("secondPhone", "secondPhone")
                 .field("thirdPhone", "thirdPhone")
                 .byDefault().register();

        factory.classMap(ClinicLatLngDTO.class, Clinics.class)
                .customize(new CustomMapper<ClinicLatLngDTO, Clinics>() {
                    @Override
                    public void mapAtoB(ClinicLatLngDTO latLng, Clinics clinics, MappingContext context) {
                        double lat = clinics.getContact().getLatitude();
                        double lng = clinics.getContact().getLongitude();
                        latLng.setLat(lat);
                        latLng.setLng(lng);
                        latLng.setId(clinics.getId());
                    }
                });
    }
}
