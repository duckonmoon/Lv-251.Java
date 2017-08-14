package com.softserve.edu.lv251.dao.impl;

import com.softserve.edu.lv251.dao.DoctorsDAO;
import com.softserve.edu.lv251.entity.Doctors;
import com.softserve.edu.lv251.service.impl.DoctorServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Yana Martynyak on 13.08.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class DoctorServiceImplTest {
    @Spy
    List<Doctors> doctors= new LinkedList<>();
    @Captor
    ArgumentCaptor<Doctors> captor;
    @Mock
    private DoctorsDAO doctorsDAO;
    @InjectMocks
    DoctorServiceImpl doctorService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        doctors.add(new Doctors());
        doctors.add(new Doctors());

    }


    @Test
    public void addDoctor() throws Exception {
        doNothing().when(doctorsDAO).addEntity(any(Doctors.class));
        Doctors doc=new Doctors();
        doc.setFirstname("Petro");
        doctorService.addDoctor(doc);
        verify(doctorsDAO, times(1)).addEntity(captor.capture());
        Assert.assertEquals(captor.getValue().getFirstname(), "Petro");

    }

    @Test
    public void getAll() throws Exception {


        when(doctorsDAO.getAllEntities()).thenReturn(doctors);
        assertEquals(2,doctorsDAO.getAllEntities().size());
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void find() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void searchByLetters() throws Exception {
    }

    @Test
    public void getDoctorsByColumnNameAndValue() throws Exception {
    }

    @Test
    public void findByEmail() throws Exception {
    }

    @Test
    public void registerNewDoctorAccount() throws Exception {
    }

    @Test
    public void appointmentsInThisMonth() throws Exception {
    }

    @Test
    public void searchByDistrict() throws Exception {
    }

    @Test
    public void searchBySpecialization() throws Exception {
    }

    @Test
    public void getDoctorPatients() throws Exception {
    }

    @Test
    public void getDao() throws Exception {
    }

    @Test
    public void getByClinic() throws Exception {
    }

    @Test
    public void addDoctorAccount() throws Exception {
    }

    @Test
    public void getDoctorByNameWithLimitAndOffset() throws Exception {
    }

    @Test
    public void findById() throws Exception {
    }

    @Test
    public void makeDoctorFromUser() throws Exception {
    }

}