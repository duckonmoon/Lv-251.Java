package com.softserve.edu.lv251.dto.pojos;

/**
 * Created by Admin on 09.08.2017.
 */
public class ClinicSearchDTO {
    private Long id;
    private String clinic_name;
    private String photo;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClinic_name() {
        return clinic_name;
    }

    public void setClinic_name(String clinic_name) {
        this.clinic_name = clinic_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
