package com.softserve.edu.lv251.controllers;


import com.softserve.edu.lv251.config.Mapper;
import com.softserve.edu.lv251.constants.Constants;
import com.softserve.edu.lv251.dto.pojos.ClinicInfoDTO;
import com.softserve.edu.lv251.dto.pojos.DoctorDTO;

import com.softserve.edu.lv251.dto.pojos.UserToDoctor;
import com.softserve.edu.lv251.entity.*;

import com.softserve.edu.lv251.model.FileBucket;
import com.softserve.edu.lv251.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Locale;

/**
 * Created by Yana Martynyak on 31.07.2017.
 */
@Controller
@RequestMapping(value = "/moderator")
public class ModeratorCabinetController {
    @Autowired
    private ModeratorService moderatorService;

    @Autowired
    private DoctorsService doctorsService;

    @Autowired
    private Logger logger;

    @Autowired
    private ClinicService clinicService;

    @Autowired
    private Mapper mapper;

    @Autowired
    private ContactsService contactsService;

    @Autowired
     private UserService userService;

    @Autowired
    private MessageSource messageSource;


    @GetMapping(value = "/cabinet")
    public String moderatorCabinet(Principal principal, Model model) {
        Moderator moderator = moderatorService.getByEmail(principal.getName());
        List<Doctors> doctors = doctorsService.getByClinic(moderator.getClinic().getId());
        Clinics clinics = moderator.getClinic();
        System.out.println(doctors);
        Contacts contacts = clinics.getContact();
        ClinicInfoDTO clinicDTO = new ClinicInfoDTO();
     if(clinics!=null){
        mapper.map(clinics, clinicDTO);}
     if(contacts!=null){
        mapper.map(contacts, clinicDTO);}
        model.addAttribute(Constants.Controllers.PHOTO_FORM, new FileBucket());
        model.addAttribute(Constants.Controllers.DOCTORS, doctors);
        model.addAttribute(Constants.Controllers.MODERATOR, moderator);
        model.addAttribute(Constants.Controllers.CLINIC_DTO, clinicDTO);
        return Constants.Controllers.MODERATOR_CABINET;


     }

    @PostMapping("/cabinet")
    public String edit(@ModelAttribute("clinicDTO") @Valid ClinicInfoDTO clinicInfoDTO, BindingResult bindingResult, Principal principal, RedirectAttributes model) {
        Locale currentLocale = LocaleContextHolder.getLocale();

        String messageError = messageSource.getMessage("messages.errorClinicName", null, currentLocale);
        Moderator moderator = moderatorService.getByEmail(principal.getName());
        Clinics clinics = moderator.getClinic();
        Contacts contacts = clinics.getContact();
        if (!bindingResult.hasErrors()) {
            mapper.map(clinicInfoDTO, clinics);
            mapper.map(clinicInfoDTO, contacts);

            clinicService.updateClinic(clinics);
            contactsService.updateContacts(contacts);
            return "redirect:/moderator/cabinet";
        } else {
            model.addFlashAttribute(Constants.Controllers.CLASS_CSS, "alert alert-warning");
            model.addFlashAttribute(Constants.Controllers.MESSAGE, messageError);
            return "redirect:/moderator/cabinet";
        }
    }

    @GetMapping(value = "/cabinet/doctors")
    public String moderatorAllDoctors(Principal principal, Model model) {
        Moderator moderator = moderatorService.getByEmail(principal.getName());
        List<Doctors> doctors = doctorsService.getByClinic(moderator.getClinic().getId());


        model.addAttribute(Constants.Controllers.DOCTORS, doctors);
        model.addAttribute(Constants.Controllers.MODERATOR, moderator);
        return Constants.Controllers.MODERATOR_CABINET_DOCTORS;
    }

    @GetMapping(value = "/cabinet/doctors/delete/{id}")
    public String deleteDoctor(@PathVariable("id") Long id) {
        doctorsService.delete(doctorsService.find(id));
        return "redirect:/moderator/cabinet/doctors";

}

    @GetMapping(value = "/cabinet/add/doctor")
    public String addDoctor(Model model, Principal principal) {
        model.addAttribute("doctorForm", new DoctorDTO());
        Moderator moderator = moderatorService.getByEmail(principal.getName());
        List<Doctors> doctors = doctorsService.getByClinic(moderator.getClinic().getId());
        model.addAttribute(Constants.Controllers.DOCTORS, doctors);
        model.addAttribute(Constants.Controllers.MODERATOR, moderator);
        return Constants.Controllers.MODERATOR_ADD_DOCTOR;
    }

    @PostMapping(value = "/add/doctor")
    public String registerDoctor(@ModelAttribute("doctorForm") @Valid DoctorDTO doctorDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.warn("registerDoctor has errors");
            return "moderatorMakeDoctor";
        } else {
            doctorsService.addDoctorAccount(doctorDTO);
            return "redirect:/moderator/cabinet/doctors";
        }
    }


    @PostMapping(value = "/upload/clinicPhoto")
    public String uploadPhoto(@ModelAttribute("photoForm")@Valid FileBucket fileBucket, BindingResult bindingResult, Principal principal, RedirectAttributes model) {
        if (bindingResult.hasErrors()) {
            Locale currentLocale = LocaleContextHolder.getLocale();
            String messageError = messageSource.getMessage("messages.errorPhoto", null, currentLocale);
            model.addFlashAttribute(Constants.Controllers.CLASS_CSS, "alert alert-danger");
            model.addFlashAttribute(Constants.Controllers.MESSAGE, messageError);
            return "redirect:/moderator/cabinet";
        } else {
            clinicService.updatePhoto(fileBucket.getMultipartFile(), moderatorService.getByEmail(principal.getName()).getClinic());

            return "redirect:/moderator/cabinet";
        }
    }

    @GetMapping(value = "/cabinet/make/doctor")
    public String makeDoctor(Model model, Principal principal) {
        model.addAttribute(Constants.Controllers.USERS_TO_DOCTOR, new UserToDoctor());

        Moderator moderator = moderatorService.getByEmail(principal.getName());
        List<Doctors> doctors = doctorsService.getByClinic(moderator.getClinic().getId());
        List<Users> users = userService.getAllUsers();

        model.addAttribute(Constants.Controllers.DOCTORS, doctors);
        model.addAttribute(Constants.Controllers.MODERATOR, moderator);

            return Constants.Controllers.MODERATOR_MAKE_DOCTOR;
        }

        @PostMapping(value = "/cabinet/make/doctor")
        public String makeDoctor (@ModelAttribute("usersToDoctor") @Valid UserToDoctor userToDoctor, BindingResult
        bindingResult, Principal principal){
            if (bindingResult.hasErrors()) {
                return Constants.Controllers.MODERATOR_MAKE_DOCTOR;
            } else {
                doctorsService.makeDoctorFromUser(userToDoctor, principal.getName());
                return "redirect:/moderator/cabinet/doctors";
            }
        }
}
