package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.dao.AppointmentsDAO;
import com.softserve.edu.lv251.dao.impl.AppointmentsDAOImpl;
import com.softserve.edu.lv251.dto.pojos.AppointmentsDTO;
import com.softserve.edu.lv251.dto.pojos.AppointmentsForCreationDTO;
import com.softserve.edu.lv251.entity.Appointments;
import com.softserve.edu.lv251.entity.Doctors;
import com.softserve.edu.lv251.entity.Users;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Marian Brynetskyi on 14.08.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class AppointmentServiceImplTest {

    @Spy
    List<Appointments> appointments = new LinkedList<>();

    @Spy
    List<AppointmentsForCreationDTO> appointmentsForCreationDTOS = new LinkedList<>();
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

        Doctors doc=new Doctors();
        doc.setFirstname("Petro");

        Users users = new Users();
        users.setFirstname("Ivan");

        Appointments appointments2 = new Appointments();
        Appointments appointments1 = new Appointments();

        appointments1.setAppointmentDate(sdf.parse("12/09/2017 - 15:00"));
        appointments2.setAppointmentDate(sdf.parse("12/08/2017 - 15:00"));

        appointments1.setDoctors(doc);
        appointments2.setDoctors(doc);

        appointments1.setUsers(users);
        appointments2.setUsers(users);

        appointments1.setId(1);
        appointments2.setId(2);

        appointments1.setIsApproved(true);
        appointments2.setIsApproved(true);

        appointments.add(appointments1);
        appointments.add(appointments2);

        AppointmentsForCreationDTO appointmentsDTO1 = new AppointmentsForCreationDTO();
        AppointmentsForCreationDTO appointmentsDTO2 = new AppointmentsForCreationDTO();

        appointmentsDTO1.setAppointmentDate(sdf.parse("12/09/2017 - 15:00"));
        appointmentsDTO2.setAppointmentDate(sdf.parse("12/08/2017 - 15:00"));

        appointmentsForCreationDTOS.add(appointmentsDTO1);
        appointmentsForCreationDTOS.add(appointmentsDTO2);
    }

    @Test
    public void addAppointment() throws Exception {
        doNothing().when(appointmentsDAO).addEntity(any(Appointments.class));
        Appointments appointments = new Appointments();
        appointments.setId(1);

        Doctors doc=new Doctors();
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
        when(appointmentService.getAllDoctorsAppointmentsAfterNow()).thenReturn(appointmentsForCreationDTOS
                .stream()
                .filter(p->p.getAppointmentDate().after(new Date()))
                .collect(Collectors.toList()));


        Assert.assertEquals(1, appointmentService.getAllDoctorsAppointmentsAfterNow().size());
    }

    @Test
    public void getAllDoctorsAppointmentsAfterNow1() throws Exception {
    }

    @Test
    public void listAppointmensWithDoctor() throws Exception {
    }

    @Test
    public void getAppiontmentbyDoctorsEmail() throws Exception {
    }

    @Test
    public void getAppointmentByUserEmail() throws Exception {
    }

}