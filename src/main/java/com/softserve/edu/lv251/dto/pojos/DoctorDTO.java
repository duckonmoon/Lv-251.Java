package com.softserve.edu.lv251.dto.pojos;

import com.softserve.edu.lv251.customannotations.PasswordMatches;
import com.softserve.edu.lv251.customannotations.ValidEmail;
import com.softserve.edu.lv251.customannotations.ValidPassword;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Admin on 02.08.2017.
 */
@PasswordMatches
public class DoctorDTO extends UserDTO {

    @NotBlank(message = "{org.hibernate.validator.constraints.NotEmpty.message}")
    private String specialization;

    @NotBlank(message = "{org.hibernate.validator.constraints.NotEmpty.message}")
    private String description;

    @NotBlank(message = "{org.hibernate.validator.constraints.NotEmpty.message}")
    private String clinic;

    private MultipartFile multipartFile;

    public String getSpecialization() {
        return specialization;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
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
                " firstname='" + this.getFirstName() + '\'' +
                ", lastname='" + this.getLastName() + '\'' +
                ", password='" + this.getPassword() + '\'' +
                ", matchingPassword='" + this.getMatchingPassword() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", specialization='" + specialization + '\'' +
                ", description='" + description + '\'' +
                ", clinic='" + clinic + '\'' +
                '}';
    }
}
