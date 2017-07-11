package entity;

import javax.persistence.Entity;

/**
 *
 */


@Entity
public class Clinics extends BaseEntity {
    private String clinic_name;

    public Clinics() {
    }

    public String getClinic_name() {
        return clinic_name;
    }

    public void setClinic_name(String clinic_name) {
        this.clinic_name = clinic_name;
    }
}
