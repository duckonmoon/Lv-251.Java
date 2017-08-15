package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.dao.AppointmentsDAO;
import com.softserve.edu.lv251.entity.Appointments;
import com.softserve.edu.lv251.entity.Doctors;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Marian Brynetskyi on 14.08.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class AppointmentServiceImplTest {

    @Spy
    List<Appointments> appointments = new LinkedList<>();
    @Captor
    ArgumentCaptor<Appointments> captor;

    @Mock
    private AppointmentsDAO appointmentsDAO;

    @InjectMocks
    private AppointmentServiceImpl appointmentService;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm");

    @Before
    public void setUp() throws ParseException {
        MockitoAnnotations.initMocks(this);

        Appointments appointments2 = new Appointments();
        Appointments appointments1 = new Appointments();

        appointments1.setAppointmentDate(sdf.parse("12/09/2017 - 15:00"));
        appointments2.setAppointmentDate(sdf.parse("12/08/2017 - 15:00"));

        appointments1.setIsApproved(true);
        appointments2.setIsApproved(true);

        appointments.add(appointments1);
        appointments.add(appointments2);
    }

    @Test
    public void addAppointment() throws Exception {
        doNothing().when(appointmentsDAO).addEntity(any(Appointments.class));
        Appointments appointments = new Appointments();
        appointments.setId(1);

        Doctors doc = new Doctors();
        doc.setFirstname("Petro");
        appointments.setDoctors(doc);
        appointmentService.addAppointment(appointments);

        verify(appointmentsDAO, times(1)).addEntity(captor.capture());
        Assert.assertEquals(1, captor.getValue().getId());
        Assert.assertEquals("Petro", captor.getValue().getDoctors().getFirstname());


    }

    @Test
    public void updateAppointment() throws Exception {
    }

    @Test
    public void getAppointmentById() throws Exception {

    }

    @Test
    public void getAllDoctorAppointmentsAfterNow() throws Exception {
    }

    @Test
    public void getAllDoctorsAppointmentsAfterNow() throws Exception {

    }

    @Test
    public void getAllDoctorsAppointmentsAfterNow1() throws Exception {
    }

    @Test
    public void listAppointmensWithDoctor() throws Exception {
    }

    @Test
    public void getAppiontmentbyDoctorsEmail() throws Exception {

        when(appointmentsDAO.getAppointmentByUserEmail("kilopo@ex.ua")).thenReturn(appointments);

        when(appointmentService.getAppiontmentbyDoctorsEmail("kilopo@ex.ua")).thenReturn(appointments);

        List<Appointments> forTest = appointmentService.getAppiontmentbyDoctorsEmail("kilopo@ex.ua");
        Assert.assertEquals(2,forTest.size());
    }

    @Test
    public void getAppointmentByUserEmail() throws Exception {
    }

}