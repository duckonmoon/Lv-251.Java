package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.config.Mapper;
import com.softserve.edu.lv251.dto.pojos.PersonalInfoDTO;
import com.softserve.edu.lv251.entity.Contacts;
import com.softserve.edu.lv251.entity.Users;
import com.softserve.edu.lv251.service.ContactsService;
import com.softserve.edu.lv251.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

/**
 * Added by Pavlo Kuchereshko
 */
@Controller
public class MedicalCardController {

    @Autowired
    private UserService userService;

    @Autowired
    private ContactsService contactsService;

    @Autowired
    private Mapper mapper;

    @GetMapping("/medical_card")
    public String medicalCardGET(ModelMap model, Principal principal){

        Users user = userService.findByEmail(principal.getName());
        Contacts contacts = user.getContact();

        PersonalInfoDTO userDTO = new PersonalInfoDTO();

        mapper.map(user, userDTO);
        mapper.map(contacts, userDTO);
        model.addAttribute("photo", user.getPhoto());
        model.addAttribute("userObject", userDTO);

        return "medical_card";
    }

    @PostMapping("/medical_card")
    public String medicalCardPOST(@ModelAttribute PersonalInfoDTO personalInfoDTO, Principal principal){

        Users user = userService.findByEmail(principal.getName());
        Contacts contacts = user.getContact();
        mapper.map(personalInfoDTO, user);
        mapper.map(personalInfoDTO, contacts);
        userService.updateUser(user);
        contactsService.updateContacts(contacts);

        return "redirect:/medical_card";
    }
}
