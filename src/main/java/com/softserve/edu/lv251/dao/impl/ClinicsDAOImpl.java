package com.softserve.edu.lv251.dao.impl;


import com.softserve.edu.lv251.dao.ClinicsDAO;
import com.softserve.edu.lv251.entity.Clinics;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 *
 */
@Transactional
@Repository
public class ClinicsDAOImpl extends BaseDAOImpl<Clinics> implements ClinicsDAO {


    @Override
    public List<Clinics> findByDistrict(String name) {
        Query query=entityManager.createQuery("select c from Clinics c join c.contact cont join cont.district d where d.name like :name")
                .setParameter("name",name);

        return query.getResultList();
    }
}
