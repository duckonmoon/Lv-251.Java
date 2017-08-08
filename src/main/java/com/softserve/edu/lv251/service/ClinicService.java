package com.softserve.edu.lv251.service;


import com.softserve.edu.lv251.dto.pojos.SearchResultClinicDTO;
import com.softserve.edu.lv251.entity.Clinics;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Taras on 14.07.2017.
 */
public interface ClinicService {

    void addClinic(Clinics clinic);

    void updateClinic(Clinics clinic);

    Clinics getClinicByID(Long clinicId);

    List<Clinics> getClinicsByColumnNameAndValue(String columnName, Object value);

    List<Clinics> getAllClinics();

    void deleteClinic(Clinics clinic);

    List<SearchResultClinicDTO> getWithOffsetOrderedByName(String name, int offset, int limit);

    Clinics getFirst();

    List<Clinics>findByDistrict(String name);
    List<Clinics>searchByLetters(String letters);
   Clinics getByName(String name);
   void updatePhoto(MultipartFile file,Clinics clinics);
}
