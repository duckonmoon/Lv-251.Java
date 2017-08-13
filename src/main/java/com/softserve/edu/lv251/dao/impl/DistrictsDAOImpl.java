package com.softserve.edu.lv251.dao.impl;

import com.softserve.edu.lv251.dao.DistrictsDAO;
import com.softserve.edu.lv251.entity.Districts;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Admin on 29.07.2017.
 */
@Repository
@PersistenceContext
public class DistrictsDAOImpl extends BaseDAOImpl<Districts> implements DistrictsDAO {

    @Override
    public List<Districts> findByName(String name) {
        String letters = name + "%".toLowerCase();
        Query query = entityManager.createQuery("from Districts d where lower(d.name) like :letters").setParameter("letters", letters);
        return query.getResultList();
    }
}
