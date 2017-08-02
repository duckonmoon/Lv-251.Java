package com.softserve.edu.lv251.dto.pojos;

import com.softserve.edu.lv251.customannotations.PasswordMatches;
import com.softserve.edu.lv251.customannotations.ValidEmail;
import com.softserve.edu.lv251.customannotations.ValidPassword;
import com.softserve.edu.lv251.entity.Clinics;
import com.softserve.edu.lv251.entity.Roles;
import com.softserve.edu.lv251.entity.Specialization;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Admin on 02.08.2017.
 */
@PasswordMatches
public class DoctorDTO {
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    @NotBlank(message = "This field can not be null")
    @ValidPassword
    private String password;
    @NotBlank
    private String matchingPassword;
    @NotBlank
    @ValidEmail
    private String email;
    @NotBlank
    private Specialization specialization;
    @NotBlank
    private String description;

    @NotBlank
    private Clinics clinic;

    public DoctorDTO() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Clinics getClinic() {
        return clinic;
    }

    public void setClinic(Clinics clinic) {
        this.clinic = clinic;
    }
}
