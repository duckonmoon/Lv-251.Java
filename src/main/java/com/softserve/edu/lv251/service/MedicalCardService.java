package com.softserve.edu.lv251.service;

import com.softserve.edu.lv251.entity.MedicalCard;
import com.softserve.edu.lv251.entity.Users;

/**
 * Added by Pavlo Kuchereshko.
 */
public interface MedicalCardService {

    void addMedicalCard(MedicalCard medicalCard);

    void updateMedicalCard(MedicalCard medicalCard);

    MedicalCard getMedicalCardById(Long id);

    MedicalCard getMedicalCardsByUser(Users user);
}
