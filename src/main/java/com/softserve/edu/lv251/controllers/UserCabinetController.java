package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.config.Mapper;
import com.softserve.edu.lv251.dto.pojos.ContactDTO;
import com.softserve.edu.lv251.dto.pojos.PersonalInfoDTO;
import com.softserve.edu.lv251.entity.Contacts;
import com.softserve.edu.lv251.entity.Users;
import com.softserve.edu.lv251.service.ContactsService;
import com.softserve.edu.lv251.service.UserService;
import javassist.ClassPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.Principal;
import java.util.Base64;

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
    public String userProfileGET(ModelMap model, Principal principal){

        Users user = userService.findByEmail(principal.getName());
        Contacts contacts = user.getContact();

        PersonalInfoDTO userDTO = new PersonalInfoDTO();

        mapper.map(user, userDTO);
        mapper.map(contacts, userDTO);
        model.addAttribute("photo", user.getPhoto());
        model.addAttribute("userObject", userDTO);

        return "user_cabinet";
    }

    @PostMapping("/user/cabinet")
    public String userProfilePOST(@ModelAttribute PersonalInfoDTO personalInfoDTO, Principal principal){

        Users user = userService.findByEmail(principal.getName());
        Contacts contacts = user.getContact();
        mapper.map(personalInfoDTO, user);
        mapper.map(personalInfoDTO, contacts);
        userService.updateUser(user);
        contactsService.updateContacts(contacts);

        return "redirect:/user/cabinet";
    }
}
