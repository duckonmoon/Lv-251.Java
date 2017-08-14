package com.softserve.edu.lv251.dao.impl;

import com.softserve.edu.lv251.entity.Appointments;
import org.junit.Test;

import java.util.Date;

public class AppointmentsDAOImplTest extends BaseDAOImplTest{

    @Test
    public void testGetAppointmentByDoctorsEmailAfterSomeDate() throws Exception {

    }

    @Test
    public void testAppointmentsWithDoctor() throws Exception {
    }

    @Test
    public void getAppiontmentbyDoctorsEmail() throws Exception {
    }

    @Test
    public void getAppointmentByUserEmail() throws Exception {
    }

    @Override
    @Test
    public void testAddEntity() {
        Appointments appointment1 = new Appointments();
        appointment1.setId(1);
        appointment1.setIsApproved(true);
        appointment1.setAppointmentDate(new Date());
    }
}