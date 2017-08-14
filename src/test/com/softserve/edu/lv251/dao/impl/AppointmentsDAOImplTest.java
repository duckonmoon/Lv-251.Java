package com.softserve.edu.lv251.dao.impl;

import com.softserve.edu.lv251.entity.Appointments;
import com.softserve.edu.lv251.entity.Doctors;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by Marian Brynetskyi on 14.08.2017.
 */
public class AppointmentsDAOImplTest {
    @Mock
    private EntityManager entityManager;
    @Mock
    Query query;
    @Spy
    List<Appointments> appointmentsList = new ArrayList<>();

    @Before
    public void beforeTest() {
        MockitoAnnotations.initMocks(this);
        Doctors doctor = new Doctors();
        doctor.setId(1);
        doctor.setFirstname("Petro");
        doctor.setEmail("somemail@mail.com");

        Appointments appointments = new Appointments();
        appointments.setId(1);
        Appointments appointments1 = new Appointments();
        appointments1.setId(2);

        appointments1.setDoctors(doctor);
        appointments.setDoctors(doctor);
        appointmentsList.add(appointments);
        appointmentsList.add(appointments1);
    }

    @Test
    public void getAppointmentByDoctorsEmailAfterSomeDate() throws Exception {
    }

    @Test
    public void appointmentsWithDoctor() throws Exception {
    }

    @Test
    public void getAppiontmentbyDoctorsEmail() throws Exception {
        when(entityManager.createQuery("")).thenReturn(query);
        when(query.getResultList()).thenReturn(appointmentsList);
        Assert.assertEquals(2, entityManager.createQuery("").getResultList().size());
        Assert.assertEquals("somemail@mail.com", ((Appointments) query.getResultList().get(0)).getDoctors().getEmail());
        Assert.assertEquals("somemail@mail.com", ((Appointments) query.getResultList().get(1)).getDoctors().getEmail());
    }

    @Test
    public void getAppointmentByUserEmail() throws Exception {
    }

    @Test
    public void addEntity() throws Exception {
    }

    @Test
    public void updateEntity() throws Exception {
    }

    @Test
    public void getEntityByID() throws Exception {
    }

    @Test
    public void getEntitiesByColumnNameAndValue() throws Exception {
    }

    @Test
    public void getAllEntities() throws Exception {
    }

    @Test
    public void deleteEntity() throws Exception {
    }

    @Test
    public void pagination() throws Exception {
    }

}