package com.softserve.edu.lv251.dao.impl;


import com.softserve.edu.lv251.dao.ClinicsDAO;
import com.softserve.edu.lv251.entity.Clinics;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by kilopo on 13.07.2017.
 */
@Transactional
@Repository
public class ClinicsDAOImpl extends BaseDAOImpl<Clinics> implements ClinicsDAO {



    @Transactional
    public List<Clinics> getWithOffsetOrderedByName(int offset, int limit){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Clinics> criteriaQuery = criteriaBuilder.createQuery(Clinics.class);
        Root<Clinics> from = criteriaQuery.from(Clinics.class);
        CriteriaQuery<Clinics> select = criteriaQuery.select(from);
        TypedQuery<Clinics> typedQuery = entityManager.createQuery(select);
        typedQuery.setFirstResult(offset);
        typedQuery.setMaxResults(limit);

        return typedQuery.getResultList();
    }
}
