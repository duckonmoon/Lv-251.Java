package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.binders.ClinicBinder;
import com.softserve.edu.lv251.binders.SpecializationBinder;
import com.softserve.edu.lv251.config.Mapper;
import com.softserve.edu.lv251.dao.ModeratorDAO;
import com.softserve.edu.lv251.dto.pojos.ClinicInfoDTO;
import com.softserve.edu.lv251.dto.pojos.DoctorDTO;
import com.softserve.edu.lv251.entity.*;
import com.softserve.edu.lv251.idl.WebRoles;
import com.softserve.edu.lv251.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

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


    @GetMapping(value = "/cabinet")
     public String moderatorCabinet(Principal principal, Model model){
     Moderator moderator=moderatorService.getByEmail(principal.getName());
     List<Doctors> doctors=doctorsService.getByClinic(moderator.getClinics().getId());
     Clinics clinics=moderator.getClinics();
     Contacts contacts=clinics.getContact();
        ClinicInfoDTO clinicDTO=new ClinicInfoDTO();
    mapper.map(clinics,clinicDTO);
    mapper.map(contacts,clinicDTO);

     model.addAttribute("doctors",doctors);
     model.addAttribute("moderator",moderator);
     model.addAttribute("clinicDTO",clinicDTO);
        return "moderator_cabinet";
     }

     @PostMapping("/cabinet")
     public String edit(@ModelAttribute ClinicInfoDTO clinicInfoDTO,Principal principal){
         Moderator moderator= moderatorService.getByEmail(principal.getName());
         Clinics clinics= moderator.getClinics();
         Contacts contacts= clinics.getContact();

         mapper.map(clinicInfoDTO,clinics);
         mapper.map(clinicInfoDTO,contacts);

         clinicService.updateClinic(clinics);
         contactsService.updateContacts(contacts);
         return "redirect:/moderator/cabinet";
     }

     @GetMapping(value = "/cabinet/doctors")
     public  String moderatorAllDoctors(Principal principal,Model model){
         Moderator moderator=moderatorService.getByEmail(principal.getName());
         List<Doctors> doctors=doctorsService.getByClinic(moderator.getClinics().getId());

         model.addAttribute("doctors",doctors);
         model.addAttribute("moderator",moderator);
         return "moderator_cabinet_doctors";
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
           return "moderator_addDoctor";
}

@PostMapping(value = "/add/doctor")
 public String registerDoctor(@ModelAttribute("doctorForm")@Valid DoctorDTO doctorDTO, BindingResult bindingResult,WebRequest request,
                              Errors errors){
            if(bindingResult.hasErrors()){
     System.out.println("has errors");
                System.out.println(doctorDTO.toString());

     return "moderator_addDoctor";
            }else {
                doctorsService.addDoctorAccount(doctorDTO);
                System.out.println(doctorDTO.toString());
            return "redirect:/moderator/cabinet/doctors";}
 }

}
