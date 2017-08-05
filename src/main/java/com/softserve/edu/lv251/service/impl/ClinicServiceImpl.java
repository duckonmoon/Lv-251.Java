package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.config.Mapper;
import com.softserve.edu.lv251.dao.BaseDAO;
import com.softserve.edu.lv251.dao.ClinicsDAO;
import com.softserve.edu.lv251.dto.pojos.SearchResultClinicDTO;
import com.softserve.edu.lv251.entity.Clinics;
import com.softserve.edu.lv251.service.ClinicService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taras on 14.07.2017.
 */
@Service("clinicService")
public class ClinicServiceImpl extends PagingSizeServiceImpl<Clinics> implements ClinicService {

    @Autowired
    Mapper mapper;
    @Autowired
    Logger logger;
    @Autowired
    private ClinicsDAO clinicsDAO;

    @Override
    public List<SearchResultClinicDTO> getWithOffsetOrderedByName(String name, int offset, int limit) {
        List<Clinics> clinics;
        if (name == null) {
            clinics = clinicsDAO.getWithOffsetAndLimit(offset, limit);
        } else {
            if (name.equals("")) {
                clinics = clinicsDAO.getWithOffsetAndLimit(offset, limit);
            }
            clinics = clinicsDAO.getByNameWithOffsetAndLimit(name, offset, limit);
        }
        List<SearchResultClinicDTO> results = new ArrayList<>();

        for (Clinics clinic : clinics) {
            SearchResultClinicDTO result = new SearchResultClinicDTO();
            mapper.map(clinic, result);
            results.add(result);

        }
        return results;
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
        return clinicsDAO.getEntitiesByColumnNameAndValue("clinic_name", name).get(0);
    }

    @Override
    public void updatePhoto(MultipartFile file, Clinics clinics) {
        String photo = StoredImagesService.getBase64encodedMultipartFile(file);
        System.out.println("###################################################################" + photo.length());
        clinics.setPhoto(photo);
        clinicsDAO.updateEntity(clinics);
    }
}
