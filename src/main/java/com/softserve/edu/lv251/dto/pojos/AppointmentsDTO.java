package com.softserve.edu.lv251.dto.pojos;

import com.softserve.edu.lv251.entity.Appointments;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 02.08.2017.
 */
public class AppointmentsDTO {


    private Long id;
    private String title;
    private String start;
    private String color;
    private String backgroundColor;
    private String borderColor;
    private String textColor;


    AppointmentsDTO(){}
    AppointmentsDTO(Appointments appointments)
    {
        this.id = appointments.getId();
        this.title = appointments.getUsers().getFirstname() + appointments.getUsers().getLastname();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(appointments.getAppointmentDate());
        this.start = calendar.get(Calendar.YEAR) + "-" +  (calendar.get(Calendar.MONTH)+1) + "-"  +  (calendar.get(Calendar.DAY_OF_MONTH)+1);
    }

    public static List<AppointmentsDTO> convert(List<Appointments> list)
    {
        List<AppointmentsDTO> appointmentsDTOS = new LinkedList<>();
        for (int i = 0; i < list.size();i++)
        {
            appointmentsDTOS.add( new AppointmentsDTO(list.get(i)));
        }
        return appointmentsDTOS;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }
}
