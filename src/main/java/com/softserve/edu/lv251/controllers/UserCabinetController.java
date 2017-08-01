package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.entity.Users;
import com.softserve.edu.lv251.service.UserService;
import javassist.ClassPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    UserService userService;

    @RequestMapping(value = "/user/cabinet",method = RequestMethod.GET)
    public String home(ModelMap model, Principal principal){

        Users user = userService.findByEmail(principal.getName());

        model.addAttribute("photo", user.getPhoto());
        model.addAttribute("userObject", user);
        
        return "user_cabinet";
    }
}
