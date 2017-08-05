package com.softserve.edu.lv251.dao.impl;

import com.softserve.edu.lv251.dao.AppointmentsDAO;
import com.softserve.edu.lv251.entity.Appointments;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by kilopo on 13.07.2017.
 */
@Transactional
@Repository
public class AppointmentsDAOImpl extends BaseDAOImpl<Appointments> implements AppointmentsDAO {

    @Override
    public List<Appointments> appointmentsWithDoctor() {
        return entityManager.createQuery("select a from Appointments a join a.doctors d join d.specialization s").getResultList();
    }

    public List<Appointments> getAppiontmentbyDoctorsEmail(String email) {
        return entityManager.createQuery("select a from Appointments a where a.doctors.email= ?1").setParameter(1,email).getResultList();
    }
}

