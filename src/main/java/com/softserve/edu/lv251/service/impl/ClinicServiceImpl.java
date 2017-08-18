package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.config.Mapper;
import com.softserve.edu.lv251.dao.BaseDAO;
import com.softserve.edu.lv251.dao.ClinicsDAO;
import com.softserve.edu.lv251.dto.pojos.ClinicSearchDTO;
import com.softserve.edu.lv251.dto.pojos.SearchResultClinicDTO;
import com.softserve.edu.lv251.entity.Clinic;
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
public class ClinicServiceImpl extends PagingSizeServiceImpl<Clinic> implements ClinicService {

    @Autowired
    private Mapper mapper;

    @Autowired
    private Logger logger;

    @Autowired
    private ClinicsDAO clinicsDAO;

    @Override
    public List<SearchResultClinicDTO> getWithOffsetOrderedByName(String name, int offset, int limit) {
        List<Clinic> clinics;
        if (name == null || name.isEmpty()) {
            clinics = clinicsDAO.getWithOffsetAndLimit(offset, limit);
        } else {
            clinics = clinicsDAO.getByNameWithOffsetAndLimit(name, offset, limit);
        }
        List<SearchResultClinicDTO> results = new ArrayList<>();

        for (Clinic clinic : clinics) {
            SearchResultClinicDTO result = new SearchResultClinicDTO();
            mapper.map(clinic, result);
            results.add(result);
        }

        return results;
    }

    @Override
    public void addClinic(Clinic clinic) {
        this.clinicsDAO.addEntity(clinic);
    }

    @Override
    public void updateClinic(Clinic clinic) {
        this.clinicsDAO.updateEntity(clinic);
    }

    @Override
    public Clinic getClinicByID(Long clinicId) {
        return clinicsDAO.getEntityByID(clinicId);
    }

    @Override
    public ClinicSearchDTO clinicSearchById(Long clinicId) {
        Clinic clinic = clinicsDAO.getEntityByID(clinicId);
        ClinicSearchDTO clinicSearchDTO = new ClinicSearchDTO();
        mapper.map(clinic, clinicSearchDTO);
        return clinicSearchDTO;
    }

    @Override
    public List<Clinic> getClinicsByColumnNameAndValue(String columnName, Object value) {
        return this.clinicsDAO.getEntitiesByColumnNameAndValue(columnName, value);
    }

    @Override
    public List<Clinic> getAllClinics() {
        return this.clinicsDAO.getAllEntities();
    }

    @Override
    public void deleteClinic(Clinic clinic) {
        this.clinicsDAO.deleteEntity(clinic);
    }

    public Clinic getFirst() {
        return clinicsDAO.getEntityByID(1L);
    }

    @Override
    public BaseDAO<Clinic> getDao() {
        return clinicsDAO;
    }

    public List<ClinicSearchDTO> findByDistrict(String name)

    {
        List<Clinic> clinics = clinicsDAO.findByDistrict(name);
        List<ClinicSearchDTO> results = new ArrayList<>();

        for (Clinic clinic : clinics) {
            ClinicSearchDTO result = new ClinicSearchDTO();
            mapper.map(clinic, result);
            results.add(result);
        }
        return results;
    }

    @Override
    public List<ClinicSearchDTO> searchByLetters(String letters) {
        List<Clinic> clinics = clinicsDAO.searchByLetters(letters);
        List<ClinicSearchDTO> results = new ArrayList<>();

        for (Clinic clinic : clinics) {
            ClinicSearchDTO result = new ClinicSearchDTO();
            mapper.map(clinic, result);
            results.add(result);
        }
        return results;
    }

    @Override
    public Clinic getByName(String name) {
        return clinicsDAO.getEntitiesByColumnNameAndValue("clinic_name", name).get(0);
    }

    @Override
    public void updatePhoto(MultipartFile file, Clinic clinic) {
        if(!file.isEmpty()){
        String photo = StoredImagesService.getBase64encodedMultipartFile(file);
        clinic.setPhoto(photo);
        clinicsDAO.updateEntity(clinic);}
        }
}
