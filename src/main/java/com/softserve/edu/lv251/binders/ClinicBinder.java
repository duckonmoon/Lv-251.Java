package com.softserve.edu.lv251.binders;

import com.softserve.edu.lv251.service.ClinicService;
import com.softserve.edu.lv251.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.PropertyEditorSupport;

/**
 * Created by Admin on 02.08.2017.
 */
public class ClinicBinder extends PropertyEditorSupport {
    @Autowired
    private ClinicService clinicService;

    public ClinicBinder(ClinicService clinicService) {
        this.clinicService=clinicService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(clinicService.getByName(text));
    }
}
