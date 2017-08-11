package com.softserve.edu.lv251.dto.pojos;

import com.softserve.edu.lv251.customannotations.EmailNotExists;
import com.softserve.edu.lv251.customannotations.ValidEmail;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by  Yana Martynyak on 10.08.2017.
 */
public class UserToDoctor {
    @ValidEmail
    @EmailNotExists
    private String email;
    @NotBlank
    private String specialization;
    private String clinicName;
    @NotBlank
    private String description;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }
}
