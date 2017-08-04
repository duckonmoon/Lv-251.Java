package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.dao.BaseDAO;
import com.softserve.edu.lv251.dao.ClinicsDAO;
import com.softserve.edu.lv251.entity.Clinics;
import com.softserve.edu.lv251.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
@Service("clinicService")
public class ClinicServiceImpl extends PagingSizeServiceImpl<Clinics> implements ClinicService {

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
    public BaseDAO<Clinics> getDao() {
        return clinicsDAO;
    }

    public List<Clinics> findByDistrict(String name) {
        return clinicsDAO.findByDistrict(name);
    }

    @Override
    public List<Clinics> searchByLetters(String letters) {
        return clinicsDAO.searchByLetters(letters);
    }

    @Override
    public Clinics getByName(String name) {
        return clinicsDAO.getEntitiesByColumnNameAndValue("clinic_name",name).get(0);
    }
    @Override
    public void updatePhoto(MultipartFile file,Clinics clinics){
        String photo=StoredImagesService.getBase64encodedMultipartFile(file);
        System.out.println("###################################################################" + photo.length());
        clinics.setPhoto(photo);
        clinicsDAO.updateEntity(clinics);
    }
}
