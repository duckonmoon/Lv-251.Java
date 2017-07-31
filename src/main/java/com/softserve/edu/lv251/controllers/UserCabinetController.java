package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Author: Brynetskyi Marian
 */
@Controller
public class UserCabinetController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/cabinet",method = RequestMethod.GET)
    public String home(ModelMap model, Principal principal){
        model.addAttribute("userObject", userService.findByEmail(principal.getName()));
        return "user_cabinet";
    }
}
