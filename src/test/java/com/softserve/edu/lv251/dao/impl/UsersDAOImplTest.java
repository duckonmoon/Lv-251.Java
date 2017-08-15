package com.softserve.edu.lv251.dao.impl;

import com.softserve.edu.lv251.entity.Appointments;
import com.softserve.edu.lv251.entity.Doctors;
import com.softserve.edu.lv251.entity.Users;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by Kovalevskyy Vitaliy on 14.08.2017.
 */

public class UsersDAOImplTest {
    @Mock
    private EntityManager entityManager;
    @Mock
    Query query;
    @Spy
    List<Users> usersList = new ArrayList<>();

    @Before
    public void beforeTest() {
        MockitoAnnotations.initMocks(this);
        Users users = new Users();
        users.setId(2);
        users.setFirstname("Pasha");
        users.setLastname("Pashenko");
        usersList.add(users);
    }

    @Test
    public void searchByLetters() throws Exception {
        when(entityManager.createQuery("")).thenReturn(query);
        when(query.getResultList()).thenReturn(usersList);
        assertEquals(true, ((Users) query.getResultList().get(0)).getFirstname().contains("P"));
    }

    @Test
    public void addEntity() throws Exception {
    }

    @Test
    public void updateEntity() throws Exception {
    }

    @Test
    public void getEntityByID() throws Exception {
        when(entityManager.createQuery("")).thenReturn(query);
        when(query.getResultList()).thenReturn(usersList);
        assertEquals(2, ((Users) query.getResultList().get(0)).getId());
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