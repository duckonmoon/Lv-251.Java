package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.config.Mapper;
import com.softserve.edu.lv251.dto.pojos.PersonalInfoDTO;
import com.softserve.edu.lv251.entity.Users;
import com.softserve.edu.lv251.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    private Mapper mapper;

    @GetMapping("/user/cabinet")
    public String userProfileGET(ModelMap model, Principal principal){

        Users user = userService.findByEmail(principal.getName());

        PersonalInfoDTO userDTO = new PersonalInfoDTO();
        mapper.map(user, userDTO);
        model.addAttribute("photo", user.getPhoto());
        model.addAttribute("userObject", userDTO);
        return "user_cabinet";
    }

    @PostMapping("/user/cabinet")
    public String userProfilePOST(@ModelAttribute PersonalInfoDTO personalInfoDTO, Principal principal){
        Users user = userService.findByEmail(principal.getName());
        mapper.map(personalInfoDTO, user);
        userService.updateUser(user);
        return "redirect:/user/cabinet";
    }

    @GetMapping("/user/appointments")
    public String userAppointments(Model model){
        return "user_cabinet_body_appointments";
    }
}
