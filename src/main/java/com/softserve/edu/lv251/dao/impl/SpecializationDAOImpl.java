package com.softserve.edu.lv251.dao.impl;

import com.softserve.edu.lv251.dao.SpecializationDAO;
import com.softserve.edu.lv251.entity.Specialization;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Admin on 21.07.2017.
 */
@Transactional
@Repository
public class SpecializationDAOImpl extends BaseDAOImpl<Specialization> implements SpecializationDAO {
    @Override
    public List<Specialization> searchByLetters(String letters) {
        String name=letters+"%".toLowerCase();
        Query query=entityManager.createQuery("from Specialization s where lower(s.name) like :name").setParameter("name",name);
        return query.getResultList();
    }
}
