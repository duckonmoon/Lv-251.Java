package com.softserve.edu.lv251.dto.pojos;

import com.softserve.edu.lv251.entity.Doctors;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 31.07.2017.
 */
public class DoctorImageDTO extends Doctors {
    private BufferedImage img;

    DoctorImageDTO() {
    }

    DoctorImageDTO(Doctors doctors) {
        try {
            this.setImg(ImageIO.read(new ByteArrayInputStream(Base64.getDecoder().decode(doctors.getPhoto()))));
        } catch (Exception e) {
        }
        setLastname(doctors.getLastname());
        setAppointments(doctors.getAppointments());
        setClinic(doctors.getClinic());
        setContact(doctors.getContact());
        setDescription(doctors.getDescription());
        setDocAppointments(doctors.getDocAppointments());
        setEmail(doctors.getEmail());
        setEnabled(doctors.isEnabled());
        setFirstname(doctors.getFirstname());
        setLastname(doctors.getLastname());
        setMiddlename(doctors.getMiddlename());
        setPassword(doctors.getPassword());
        setPhoto(doctors.getPhoto());
        setRoles(doctors.getRoles());
        setSpecialization(doctors.getSpecialization());
        setTestsResults(doctors.getTestsResults());
        setTokenExpired(doctors.isTokenExpired());
        setId(doctors.getId());
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public static List<DoctorImageDTO> convert(List<Doctors> list) {
        List<DoctorImageDTO> list1 = new LinkedList<>();
        for (Doctors d :
                list) {
            list1.add(new DoctorImageDTO(d));
        }
        return list1;
    }

    public static DoctorImageDTO convert(Doctors doctors) {
        return new DoctorImageDTO(doctors);
    }
}
