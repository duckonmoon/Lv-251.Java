package com.softserve.edu.lv251.controllers;


import com.softserve.edu.lv251.config.Mapper;
import com.softserve.edu.lv251.dto.pojos.ClinicInfoDTO;
import com.softserve.edu.lv251.dto.pojos.DoctorDTO;
import com.softserve.edu.lv251.entity.*;
import com.softserve.edu.lv251.model.FileBucket;
import com.softserve.edu.lv251.service.*;
import com.softserve.edu.lv251.service.impl.StoredImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.security.Principal;
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
    model.addAttribute("photoForm",new FileBucket());
     model.addAttribute("doctors",doctors);
     model.addAttribute("moderator",moderator);
     model.addAttribute("clinicDTO",clinicDTO);
        return "moderatorCabinet";
     }

     @PostMapping("/cabinet")
     public String edit(@ModelAttribute @Valid ClinicInfoDTO clinicInfoDTO,Principal principal,BindingResult bindingResult){
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

    return "moderatorCabinet";
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
                System.out.println(doctorDTO.toString());

     return "moderatorAddDoctor";
            }else {
                doctorsService.addDoctorAccount(doctorDTO);
                System.out.println(doctorDTO.toString());
            return "redirect:/moderator/cabinet/doctors";}
 }
//@PostMapping(value = "/upload/clinicPhoto")
// public String uploadPhoto(@RequestParam("file") MultipartFile file,Principal principal){
//    clinicService.updatePhoto(file,moderatorService.getByEmail(principal.getName()).getClinics());
//    System.out.println(file.getContentType());
//    System.out.println(file.getName());
//    System.out.println(file.isEmpty());
//     return "redirect:/moderator/cabinet";
// }
    @PostMapping(value = "/upload/clinicPhoto")
 public String uploadPhoto(@ModelAttribute("photoForm")@Valid FileBucket fileBucket, Principal principal,BindingResult bindingResult){
     if (bindingResult.hasErrors()){
         return "moderatorCabinet";
     }else{
    clinicService.updatePhoto(fileBucket.getMultipartFile(),moderatorService.getByEmail(principal.getName()).getClinics());
     return "redirect:/moderator/cabinet";}
 }

}
