package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.dao.ModeratorDAO;
import com.softserve.edu.lv251.entity.Doctors;
import com.softserve.edu.lv251.entity.Moderator;
import com.softserve.edu.lv251.entity.Roles;
import com.softserve.edu.lv251.idl.WebRoles;
import com.softserve.edu.lv251.service.DoctorsService;
import com.softserve.edu.lv251.service.ModeratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping(value = "/cabinet")
     public String moderatorCabinet(Principal principal, Model model){
     Moderator moderator=moderatorService.getByEmail(principal.getName());
     List<Doctors> doctors=doctorsService.getByClinic(moderator.getClinics().getId());
     model.addAttribute("doctorsSize",doctors.size());
     model.addAttribute("moderator",moderator);
        return "moderator_cabinet";
     }

}
