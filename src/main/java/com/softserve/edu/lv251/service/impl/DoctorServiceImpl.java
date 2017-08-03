package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.dao.BaseDAO;
import com.softserve.edu.lv251.dao.ContactsDAO;
import com.softserve.edu.lv251.dao.DoctorsDAO;
import com.softserve.edu.lv251.dto.pojos.UserDTO;
import com.softserve.edu.lv251.entity.Appointments;
import com.softserve.edu.lv251.entity.Contacts;
import com.softserve.edu.lv251.entity.Doctors;
import com.softserve.edu.lv251.exceptions.EmailExistsException;
import com.softserve.edu.lv251.idl.WebRoles;
import com.softserve.edu.lv251.service.DoctorsService;
import com.softserve.edu.lv251.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 21.07.2017.
 */
@Service("doctorService")
public class DoctorServiceImpl extends PagingSizeServiceImpl<Doctors> implements DoctorsService {

    @Autowired
    ContactsDAO contactsDAO;

    @Autowired
    RolesService rolesService;

    @Autowired
    EntityManager entityManager;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DoctorsDAO doctorsDAO;

    @Override
    public void addDoctor(Doctors doctors) {
        doctorsDAO.addEntity(doctors);
    }

    @Override
    public List<Doctors> getAll() {
        return doctorsDAO.getAllEntities();
    }

    @Override
    public void update(Doctors doctors) {
        doctorsDAO.updateEntity(doctors);
    }

    @Override
    public Doctors find(long id) {
        return doctorsDAO.getEntityByID(id);
    }

    @Override
    public void delete(Doctors doctors) {
     doctorsDAO.deleteEntity(doctors);
    }

    @Override
    public List<Doctors> searchByLetters(String letters) {
        return doctorsDAO.searchByLetters(letters);
    }

    @Override
    public List<Doctors> getDoctorsByColumnNameAndValue(String columnName, Object value) {
        return this.doctorsDAO.getEntitiesByColumnNameAndValue(columnName, value);
    }

    @Override
    public Doctors findByEmail(String email) {
        List<Doctors> doctors = getDoctorsByColumnNameAndValue("email", email);
        return doctors.isEmpty() ? null : doctors.get(0);
    }

    @Transactional
    @Override
    public Doctors registerNewDoctorAccount(UserDTO accountDto)
            throws EmailExistsException {

        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException("There is an account with that email address: " + accountDto.getEmail());
        }
        Doctors doctor = new Doctors();
        doctor.setFirstname(accountDto.getFirstName());
        doctor.setLastname(accountDto.getLastName());
        doctor.setMiddlename("");
        doctor.setPassword(bCryptPasswordEncoder.encode(accountDto.getPassword()));
        doctor.setEmail(accountDto.getEmail());
        doctor.setEnabled(true);
        doctor.setPhoto(StoredImagesService.getDefaultPictureBase64encoded("User_Default.png"));
        doctor.setRoles(Arrays.asList(rolesService.findByName(WebRoles.ROLE_USER.name()),
                rolesService.findByName(WebRoles.ROLE_DOCTOR.name())));
        //user.setAppointments(new ArrayList<>());
        //user.setMedicalCards(new ArrayList<>());
        //user.setTestsResults(new ArrayList<>());
        Contacts contact = new Contacts();
        contact.setUsers(doctor);
        contact.setEmail(accountDto.getEmail());
        this.contactsDAO.addEntity(contact);
        doctor.setContact(contact);
        addDoctor(doctor);

        return doctor;
    }


    public List<Appointments> appointmentsInThisMonth(Long id, Date date) {
        return doctorsDAO.appointmentsInThisMonth(id,date);
    }

    @Override
    public List<Doctors> searchByDistrict(String name) {
        return doctorsDAO.searchByDistrict(name);
    }

    private boolean emailExist(String email) {
        return findByEmail(email) != null;
    }

    @Override
    public List<Doctors> searchBySpecialization(String name) {
        return doctorsDAO.searchBySpecialization(name);
    }

    @Override
    public BaseDAO<Doctors> getDao() {
        return doctorsDAO;
    }
}
