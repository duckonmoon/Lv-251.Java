package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.config.Mapper;
import com.softserve.edu.lv251.dto.pojos.PersonalInfoDTO;
import com.softserve.edu.lv251.entity.Contacts;
import com.softserve.edu.lv251.entity.Users;
import com.softserve.edu.lv251.service.ContactsService;
import com.softserve.edu.lv251.service.UserService;
import com.softserve.edu.lv251.UserDetailsEditor.UpdatableUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Author: Brynetskyi Marian
 * Updated: Kovalevskyy Vitaliy
 */
@Controller
public class UserCabinetController {

    @Autowired
    private UserService userService;

    @Autowired
    private ContactsService contactsService;

    @Autowired
    private Mapper mapper;


    @GetMapping("/user/cabinet")
    public String userProfileGET(ModelMap model, UpdatableUserDetails principal){

        Users user = userService.findByEmail(principal.getUsername());
        Contacts contacts = user.getContact();
        PersonalInfoDTO userDTO = new PersonalInfoDTO();

        mapper.map(user, userDTO);
        mapper.map(contacts, userDTO);
        model.addAttribute("photo", user.getPhoto());
        model.addAttribute("userObject", userDTO);

        return "user_cabinet";
    }

    @PostMapping("/user/cabinet")
    public String userProfilePOST(@ModelAttribute PersonalInfoDTO personalInfoDTO, UpdatableUserDetails principal){

        Users user = userService.findByEmail(principal.getUsername());
        Contacts contacts = user.getContact();

        mapper.map(personalInfoDTO, user);
        mapper.map(personalInfoDTO, contacts);
        userService.updateUser(user);
        contactsService.updateContacts(contacts);
        principal.setUsername(personalInfoDTO.getEmail());

        return "redirect:/user/cabinet";
    }
}
