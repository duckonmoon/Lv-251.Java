package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.dto.pojos.AppointmentDTO;
import com.softserve.edu.lv251.dto.pojos.AppointmentsDTO;
import com.softserve.edu.lv251.dto.pojos.AppointmentsForCreationDTO;
import com.softserve.edu.lv251.entity.Doctors;
import com.softserve.edu.lv251.entity.Users;
import com.softserve.edu.lv251.service.AppointmentService;
import com.softserve.edu.lv251.service.PagingSizeService;
import com.softserve.edu.lv251.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by Marian Brynetskyi on 14.08.2017.
 */
//@RunWith(MockitoJUnitRunner.class)
public class UserCabinetControllerTest {

    private MockMvc mockMvc;
    @Mock
    private UserService userService;
    @Mock
    private PagingSizeService<Doctors> pagingSizeService;
    @Mock
    private AppointmentService appointmentService;
    @InjectMocks
    private UserCabinetController userCabinetController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(userCabinetController)
                .build();
    }

    @Test
    public void userProfileGET() throws Exception {
    }

    @Test
    public void userProfilePOST() throws Exception {
    }

    @Test
    public void savePassword() throws Exception {
    }

    @Test
    public void medicalCardGET() throws Exception {

        List<AppointmentDTO> appointments = new ArrayList<>();

        Users users = new Users();
        users.setEmail("kilopo@ex.ua");
        users.setId(1);

        when(userService.findByEmail("")).thenReturn(users);
        when(appointmentService.getAppointmentByUserEmail("")).thenReturn(appointments);

    }

}