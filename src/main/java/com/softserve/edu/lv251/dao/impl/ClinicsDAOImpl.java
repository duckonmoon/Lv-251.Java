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
        Query query = entityManager.createQuery("select c from Clinics c join c.contact cont join cont.district d where d.name like :name")
                .setParameter("name", name);

        return query.getResultList();
    }

    @Override
    public List<Clinics> searchByLetters(String letters) {
        String name = letters + "%".toLowerCase();
        Query query = entityManager.createQuery("select c from Clinics c where lower(c.clinic_name) like :name").setParameter("name", name);

        return query.getResultList();
    }

    @Override
    public List<Clinics> getWithOffsetAndLimit(int offset, int limit) {
        Query query = entityManager.createQuery(
                "select c " +
                        "from Clinics c")
                .setFirstResult(offset)
                .setMaxResults(limit);

        return query.getResultList();
    }

    @Override
    public List<Clinics> getByNameWithOffsetAndLimit(String value, int offset, int limit) {
        String name = "%" + value + "%";

        Query query = entityManager.createQuery(
                "select c " +
                        "from Clinics c " +
                        "where c.clinic_name like :name ")
                .setParameter("name", name)
                .setFirstResult(offset)
                .setMaxResults(limit);
        return query.getResultList();
    }
}
