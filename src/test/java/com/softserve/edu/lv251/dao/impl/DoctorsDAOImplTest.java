package com.softserve.edu.lv251.dao.impl;

import com.softserve.edu.lv251.entity.Doctors;
import org.junit.Test;

public class DoctorsDAOImplTest extends BaseDAOImplTest {
    @Test
    public void testSearchByLetters() throws Exception {
    }

    @Test
    public void testAppointmentsInThisMonth() throws Exception {
    }

    @Test
    public void testSearchBySpecialization() throws Exception {
    }

    @Test
    public void testSearchByDistrict() throws Exception {
    }

    @Test
    public void testGetWithOffsetAndLimit() throws Exception {
    }

    @Test
    public void testSearchByNameAndSpecialisationWithOffsetAndLimit() throws Exception {
    }

    @Override
    @Test
    public void testGetAllEntities() {
        Doctors doctor1 = new Doctors();
        doctor1.setId(10);
        doctor1.setFirstname("Антон");
        doctor1.setLastname("Слабий");
        doctor1.setEmail("slabiy@gmail.com");

        Doctors doctor2 = new Doctors();
        doctor2.setId(11);
        doctor2.setFirstname("Паша");
        doctor2.setLastname("Сильний");
        doctor2.setEmail("silniy@gmail.com");

        Doctors doctor3 = new Doctors();
        doctor3.setId(12);
        doctor3.setFirstname("Вася");
        doctor3.setLastname("Довгий");
        doctor3.setEmail("dovgiy@gmail.com");
    }
}