package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.dao.MedicalCardDAO;
import com.softserve.edu.lv251.entity.MedicalCard;
import com.softserve.edu.lv251.entity.Users;
import com.softserve.edu.lv251.service.MedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Added by Pavlo Kuchereshko.
 */
@Service
public class MedicalCardServiceImpl implements MedicalCardService {

    @Autowired
    private MedicalCardDAO medicalCardDAO;

    @Override
    public void addMedicalCard(MedicalCard medicalCard) {
        this.medicalCardDAO.addEntity(medicalCard);
    }

    @Override
    public void updateMedicalCard(MedicalCard medicalCard) {
        this.medicalCardDAO.updateEntity(medicalCard);
    }

    @Override
    public MedicalCard getMedicalCardById(Long id) {
        return this.medicalCardDAO.getEntityByID(id);
    }

    @Override
    public MedicalCard getMedicalCardsByUser(Users user) {
        List<MedicalCard> medicalCards = this.medicalCardDAO.getEntitiesByColumnNameAndValue("user", user);
        return medicalCards.isEmpty() ? null : medicalCards.get(0);
    }
}
