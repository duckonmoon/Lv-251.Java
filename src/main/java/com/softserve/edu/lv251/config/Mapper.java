package com.softserve.edu.lv251.config;

import com.softserve.edu.lv251.dto.pojos.ClinicLatLngDTO;
import com.softserve.edu.lv251.dto.pojos.PatientDTO;
import com.softserve.edu.lv251.dto.pojos.PersonalInfoDTO;
import com.softserve.edu.lv251.dto.pojos.UserDTO;
import com.softserve.edu.lv251.entity.Clinics;
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
        factory.classMap(PatientDTO.class, Users.class)
                .customize(new CustomMapper<PatientDTO, Users>() {
                    @Override
                    public void mapAtoB(PatientDTO patientDTO, Users users, MappingContext context) {
                        patientDTO.setId(users.getId());
                        String fullName = users.getLastname() + " "
                                + users.getFirstname() + " "
                                + users.getLastname();
                        patientDTO.setFullName(fullName);
                    }
                });
    }
}
