package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.dao.ClinicsDAO;
import com.softserve.edu.lv251.entity.Clinics;
import com.softserve.edu.lv251.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Taras on 14.07.2017.
 */
@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    private ClinicsDAO clinicsDAO;
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Clinics> getWithOffsetOrderedByName(int offset, int limit) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Clinics> criteriaQuery = criteriaBuilder.createQuery(Clinics.class);
        Root<Clinics> from = criteriaQuery.from(Clinics.class);
        CriteriaQuery<Clinics> select = criteriaQuery.select(from);
        TypedQuery<Clinics> typedQuery = entityManager.createQuery(select);
        typedQuery.setFirstResult(offset);
        typedQuery.setMaxResults(limit);
        return typedQuery.getResultList();
    }

    @Override
    public void addClinic(Clinics clinic) {
        this.clinicsDAO.addEntity(clinic);
    }

    @Override
    public void updateClinic(Clinics clinic) {
        this.clinicsDAO.updateEntity(clinic);
    }

    @Override
    public Clinics getClinicByID(Long clinicId) {
        return this.clinicsDAO.getEntityByID(clinicId);
    }

    @Override
    public List<Clinics> getClinicsByColumnNameAndValue(String columnName, Object value) {
        return this.clinicsDAO.getEntitiesByColumnNameAndValue(columnName, value);
    }

    @Override
    public List<Clinics> getAllClinics() {
        return this.clinicsDAO.getAllEntities();
    }

    @Override
    public void deleteClinic(Clinics clinic) {
        this.clinicsDAO.deleteEntity(clinic);
    }

    public Clinics getFirst() {
        return clinicsDAO.getEntityByID(1L);
    }


    @Override
    public int numberOfPaging(Integer size) {
        int n = clinicsDAO.getAllEntities().size();
        return ((int) Math.ceil((double) n/size));
    }

    @Override
    public List<Clinics> getClinics(Integer chainIndex, Integer size) {
        return clinicsDAO.pagination(chainIndex, size);
    }

    @Override
    public List<Integer> listOfVariants(){
        List<Integer> listOfVariants = null;
        Integer countEntity = clinicsDAO.getAllEntities().size();
        if (countEntity <= 10) {
            listOfVariants.add(countEntity);
        } else  if (countEntity <= 20) {
            listOfVariants.add(10);
            listOfVariants.add(countEntity);
        } else if (countEntity <= 50){
            listOfVariants.add(10);
            listOfVariants.add(20);
            listOfVariants.add(countEntity);
        } else if (countEntity <= 100) {
            listOfVariants.add(10);
            listOfVariants.add(20);
            listOfVariants.add(50);
            listOfVariants.add(countEntity);
        } else {
            listOfVariants.add(10);
            listOfVariants.add(20);
            listOfVariants.add(50);
            listOfVariants.add(100);
            listOfVariants.add(countEntity);
        }
        return listOfVariants;
    }

}
