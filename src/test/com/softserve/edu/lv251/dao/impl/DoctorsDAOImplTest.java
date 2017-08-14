package com.softserve.edu.lv251.dao.impl;

import com.softserve.edu.lv251.entity.Doctors;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Yana Martynyak on 13.08.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class DoctorsDAOImplTest {
    @Mock
    private EntityManager entityManager;
    @Mock
    Query query;
    @Spy
    List<Doctors> doctorsList = new ArrayList<>();
    ;


    @Before
    public void beforeTest() {
        MockitoAnnotations.initMocks(this);
        Doctors doctor = new Doctors();
        doctor.setId(1);
        doctor.setFirstname("Petro");
        doctorsList.add(doctor);


    }


    @Test
    public void searchByLetters() throws Exception {
        Mockito.when(entityManager.createQuery("")).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(doctorsList);
        assertEquals(1, query.getResultList().size());
        assertEquals(true,  ((Doctors) query.getResultList().get(0)).getFirstname().contains("P"));
    }

    @Test
    public void appointmentsInThisMonth() throws Exception {
    }

    @Test
    public void searchBySpecialization() throws Exception {
    }

    @Test
    public void searchByDistrict() throws Exception {
    }

    @Test
    public void getWithOffsetAndLimit() throws Exception {
    }

    @Test
    public void searchByNameAndSpecialisationWithOffsetAndLimit() throws Exception {
    }

}