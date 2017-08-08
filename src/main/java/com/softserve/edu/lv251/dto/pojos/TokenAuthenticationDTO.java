package com.softserve.edu.lv251.dto.pojos;

/**
 * Created by Taras on 07.08.2017.
 */
public class TokenAuthenticationDTO {

    private String token;
    private String username;

    private String firstName;
    private String lastName;
    private String middleName;

    private boolean isUser;
    private boolean isDoctor;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public boolean getIsUser() {
        return isUser;
    }

    public void setIsUser(boolean user) {
        isUser = user;
    }

    public boolean getIsDoctor() {
        return isDoctor;
    }

    public void setIsDoctor(boolean doctor) {
        isDoctor = doctor;
    }
}
