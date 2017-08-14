package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.config.Mapper;
import com.softserve.edu.lv251.dao.BaseDAO;
import com.softserve.edu.lv251.dao.ClinicsDAO;
import com.softserve.edu.lv251.dto.pojos.ClinicSearchDTO;
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
    private Mapper mapper;

    @Autowired
    private Logger logger;

    @Autowired
    private ClinicsDAO clinicsDAO;

    @Override
    public List<SearchResultClinicDTO> getWithOffsetOrderedByName(String name, int offset, int limit) {
        List<Clinics> clinics;
        if (name == null || name.isEmpty()) {
            clinics = clinicsDAO.getWithOffsetAndLimit(offset, limit);
        } else {
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
        return clinicsDAO.getEntityByID(clinicId);
    }

    @Override
    public ClinicSearchDTO clinicSearchById(Long clinicId) {
        Clinics clinics = clinicsDAO.getEntityByID(clinicId);
        ClinicSearchDTO clinicSearchDTO = new ClinicSearchDTO();
        mapper.map(clinics, clinicSearchDTO);
        return clinicSearchDTO;
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

    public List<ClinicSearchDTO> findByDistrict(String name)

    {
        List<Clinics> clinics = clinicsDAO.findByDistrict(name);
        List<ClinicSearchDTO> results = new ArrayList<>();

        for (Clinics clinic : clinics) {
            ClinicSearchDTO result = new ClinicSearchDTO();
            mapper.map(clinic, result);
            results.add(result);
        }
        return results;
    }

    @Override
    public List<ClinicSearchDTO> searchByLetters(String letters) {
        List<Clinics> clinics = clinicsDAO.searchByLetters(letters);
        List<ClinicSearchDTO> results = new ArrayList<>();

        for (Clinics clinic : clinics) {
            ClinicSearchDTO result = new ClinicSearchDTO();
            mapper.map(clinic, result);
            results.add(result);
        }
        return results;
    }

    @Override
    public Clinics getByName(String name) {
        return clinicsDAO.getEntitiesByColumnNameAndValue("clinic_name", name).get(0);
    }

    @Override
    public void updatePhoto(MultipartFile file, Clinics clinics) {
        String photo = StoredImagesService.getBase64encodedMultipartFile(file);
        clinics.setPhoto(photo);
        clinicsDAO.updateEntity(clinics);
        }
}
