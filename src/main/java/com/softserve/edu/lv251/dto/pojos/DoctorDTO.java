package com.softserve.edu.lv251.dto.pojos;

import com.softserve.edu.lv251.customannotations.PasswordMatches;
import com.softserve.edu.lv251.customannotations.ValidEmail;
import com.softserve.edu.lv251.customannotations.ValidPassword;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Admin on 02.08.2017.
 */
@PasswordMatches
public class DoctorDTO extends UserDTO {

    @NotBlank(message = "{org.hibernate.validator.constraints.NotEmpty.message}")
    private String firstName;

    @NotBlank(message = "{org.hibernate.validator.constraints.NotEmpty.message}")
    private String lastName;

    @NotBlank(message = "{org.hibernate.validator.constraints.NotEmpty.message}")
    @ValidPassword
    private String password;

    @NotBlank(message = "{org.hibernate.validator.constraints.NotEmpty.message}")
    private String matchingPassword;

    @NotBlank(message = "{org.hibernate.validator.constraints.NotEmpty.message}")
    @ValidEmail
    private String email;

    @NotBlank(message = "{org.hibernate.validator.constraints.NotEmpty.message}")
    private String specialization;

    @NotBlank(message = "{org.hibernate.validator.constraints.NotEmpty.message}")
    private String description;

    @NotBlank(message = "{org.hibernate.validator.constraints.NotEmpty.message}")
    private String clinic;

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    @Override
    public String toString() {
        return "DoctorDTO{" +
                " firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", matchingPassword='" + matchingPassword + '\'' +
                ", email='" + email + '\'' +
                ", specialization='" + specialization + '\'' +
                ", description='" + description + '\'' +
                ", clinic='" + clinic + '\'' +
                '}';
    }
}
