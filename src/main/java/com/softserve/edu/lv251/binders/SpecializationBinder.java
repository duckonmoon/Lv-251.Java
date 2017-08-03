package com.softserve.edu.lv251.binders;

import com.softserve.edu.lv251.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.PropertyEditorSupport;

/**
 * Created by Admin on 02.08.2017.
 */
public class SpecializationBinder extends PropertyEditorSupport {
    @Autowired
    private SpecializationService specializationService;

    public SpecializationBinder(SpecializationService specializationService) {
        this.specializationService=specializationService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(specializationService.findByName(text));
    }
}
