package com.softserve.edu.lv251.dto.pojos;

/**
 * Created by Taras on 01.08.2017.
 */
public class PatientDTO {
    private long id;
    private String fullName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
