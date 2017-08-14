package com.softserve.edu.lv251.dao.impl;

import com.softserve.edu.lv251.dao.DoctorsDAO;
import com.softserve.edu.lv251.entity.Doctors;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Yana Martynyak on 13.08.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class DoctorsDAOImplTest {
    @Mock
    private EntityManager entityManager;
    @Mock
    Query query;



    @Before
    public void beforeTest(){
        MockitoAnnotations.initMocks(this);



    }


    @Test
    public void searchByLetters() throws Exception {


        Mockito.when(entityManager.createQuery("from Doctors d where lower(d.firstname) like" +
                " :letters or lower(d.lastname) like :letters or lower(d.specialization.name) like :letters")).thenReturn(query);

        List<Doctors> doctorsList = new ArrayList<>(1);

        Mockito.when(query.getResultList()).thenReturn(doctorsList);
        assertEquals(doctorsList,query.getResultList());
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