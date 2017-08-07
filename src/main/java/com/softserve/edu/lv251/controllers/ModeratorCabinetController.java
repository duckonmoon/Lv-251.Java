package com.softserve.edu.lv251.controllers;


import com.softserve.edu.lv251.config.Mapper;
import com.softserve.edu.lv251.dto.pojos.ClinicInfoDTO;
import com.softserve.edu.lv251.dto.pojos.DoctorDTO;
import com.softserve.edu.lv251.entity.*;
import com.softserve.edu.lv251.model.FileBucket;
import com.softserve.edu.lv251.service.*;
import com.softserve.edu.lv251.service.impl.StoredImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Locale;

/**
 * Created by Admin on 31.07.2017.
 */
@Controller
@RequestMapping(value = "/moderator")
public class ModeratorCabinetController {
    @Autowired
    private ModeratorService moderatorService;
    @Autowired
    private DoctorsService doctorsService;
    @Autowired
    private SpecializationService specializationService;
    @Autowired
    private ClinicService clinicService;
    @Autowired
    private Mapper mapper;
    @Autowired
    private ContactsService contactsService;
    @Autowired
    MessageSource messageSource;


    @GetMapping(value = "/cabinet")
     public String moderatorCabinet( Principal principal, Model model){
     Moderator moderator=moderatorService.getByEmail(principal.getName());
     List<Doctors> doctors=doctorsService.getByClinic(moderator.getClinics().getId());
     Clinics clinics=moderator.getClinics();
     Contacts contacts=clinics.getContact();
        ClinicInfoDTO clinicDTO=new ClinicInfoDTO();
    mapper.map(clinics,clinicDTO);
    mapper.map(contacts,clinicDTO);
    model.addAttribute("photoForm",new FileBucket());
     model.addAttribute("doctors",doctors);
     model.addAttribute("moderator",moderator);
     model.addAttribute("clinicDTO",clinicDTO);
        return "moderatorCabinet";
     }

     @PostMapping("/cabinet")
     public String edit(@ModelAttribute("clinicDTO") @Valid ClinicInfoDTO clinicInfoDTO,BindingResult bindingResult,Principal principal,RedirectAttributes model){
         Locale currentLocale = LocaleContextHolder.getLocale();

         String messageError = messageSource.getMessage("messages.errorClinicName", null, currentLocale);
         Moderator moderator= moderatorService.getByEmail(principal.getName());
         Clinics clinics= moderator.getClinics();
         Contacts contacts= clinics.getContact();
if(!bindingResult.hasErrors()){
         mapper.map(clinicInfoDTO,clinics);
         mapper.map(clinicInfoDTO,contacts);

         clinicService.updateClinic(clinics);
         contactsService.updateContacts(contacts);
         return "redirect:/moderator/cabinet";}
         else {
    model.addFlashAttribute("classCss", "alert alert-warning");
    model.addFlashAttribute("message", messageError);
    return "redirect:/moderator/cabinet";
         }
     }

     @GetMapping(value = "/cabinet/doctors")
     public  String moderatorAllDoctors(Principal principal,Model model){
         Moderator moderator=moderatorService.getByEmail(principal.getName());
         List<Doctors> doctors=doctorsService.getByClinic(moderator.getClinics().getId());

         model.addAttribute("doctors",doctors);
         model.addAttribute("moderator",moderator);
         return "moderatorCabinetDoctors";
     }
     @GetMapping(value = "/cabinet/doctors/delete/{id}")
       public String deleteDoctor(@PathVariable("id")Long id){
         doctorsService.delete(doctorsService.find(id));
         return "redirect:/moderator/cabinet/doctors";

}       @GetMapping(value = "/cabinet/add/doctor")
        public String addDoctor(Model model,Principal principal){
        model.addAttribute("doctorForm",new DoctorDTO());
        Moderator moderator=moderatorService.getByEmail(principal.getName());
        List<Doctors> doctors=doctorsService.getByClinic(moderator.getClinics().getId());
        model.addAttribute("doctors",doctors);
        model.addAttribute("moderator",moderator);
           return "moderatorAddDoctor";
}

@PostMapping(value = "/add/doctor")
 public String registerDoctor(@ModelAttribute("doctorForm")@Valid DoctorDTO doctorDTO, BindingResult bindingResult){
            if(bindingResult.hasErrors()){
     System.out.println("has errors");
                System.out.println(doctorDTO.getMultipartFile().getSize());
                System.out.println(doctorDTO.toString());


     return "moderatorAddDoctor";
            }else {
                System.out.println(doctorDTO.getMultipartFile().getSize());
                doctorsService.addDoctorAccount(doctorDTO);
                System.out.println(doctorDTO.toString());
            return "redirect:/moderator/cabinet/doctors";}
 }

    @PostMapping(value = "/upload/clinicPhoto")
 public String uploadPhoto(@ModelAttribute("photoForm")@Valid FileBucket fileBucket,BindingResult bindingResult, Principal principal,RedirectAttributes model){
     if (bindingResult.hasErrors()){
         Locale currentLocale = LocaleContextHolder.getLocale();


         String messageError = messageSource.getMessage("messages.errorPhoto", null, currentLocale);
         model.addFlashAttribute("classCss", "alert alert-danger");
         model.addFlashAttribute("message", messageError);
         return "redirect:/moderator/cabinet";
     }else{
    clinicService.updatePhoto(fileBucket.getMultipartFile(),moderatorService.getByEmail(principal.getName()).getClinics());
     return "redirect:/moderator/cabinet";}
 }

}
