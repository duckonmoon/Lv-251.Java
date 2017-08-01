package com.softserve.edu.lv251.dto.pojos;

/**
 * Created by Shmidt on 01.08.2017.
 */
public class PersonalInfoDTO {

    private String firstname;
    private String lastname;
    private String email;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PersonalInfoDTO() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
