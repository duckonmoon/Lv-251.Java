package entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by User on 11.07.2017.
 */
@Entity
public class Doctors extends Users{
    @Column(length = 10000)
    private String description;

    public Doctors() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
