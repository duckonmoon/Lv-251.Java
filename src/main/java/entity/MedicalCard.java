package entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 *
 */
@Entity
public class MedicalCard extends BaseEntity {
    private Date date;
    private String description;

    @ManyToOne
    private Users user;

    public MedicalCard() {
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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