package com.softserve.edu.lv251.dto.pojos;

import com.softserve.edu.lv251.entity.Appointments;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 02.08.2017.
 */
public class AppointmentsDTO {
    private String title;
    private Date start;

    AppointmentsDTO(){}
    AppointmentsDTO(Appointments appointments)
    {
        this.title = appointments.getUsers().getFirstname() + appointments.getUsers().getLastname();
        this.start = appointments.getAppointmentDate();
    }

    public AppointmentsDTO[] convert(List<Appointments> list)
    {
        if (list.size()!=0)
        {
            AppointmentsDTO[] appointmentsDTOS = new AppointmentsDTO[list.size()];
            for (int i = 0; i < list.size();i++)
            {
                appointmentsDTOS[i] = new AppointmentsDTO(list.get(i));
            }
            return appointmentsDTOS;
        }
        return null;
    }


}
