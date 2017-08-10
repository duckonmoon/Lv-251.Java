package com.softserve.edu.lv251.dto.pojos;

/**
 * Created by User on 10.08.2017.
 */
public class UserCutDTO {
    private String firstname;
    private String lastname;

    public UserCutDTO() {
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

    @Override
    public String toString() {
        return "UserCutDTO{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
