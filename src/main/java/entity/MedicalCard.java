package entity;

import javax.persistence.Entity;
import java.util.Date;

/**
 *
 */
@Entity
public class MedicalCard extends BaseEntity {
    private Date date;
    private String description;


    public MedicalCard() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MedicalCard{" +
                "date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}