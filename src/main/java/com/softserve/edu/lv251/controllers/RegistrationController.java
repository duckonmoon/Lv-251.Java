package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.dto.pojos.UserDTO;
import com.softserve.edu.lv251.entity.Users;
import com.softserve.edu.lv251.exceptions.EmailExistsException;
import com.softserve.edu.lv251.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Added by Pavlo Kuchereshko.
 *
 */

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    @Autowired
    Logger logger;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model, Principal principal) {
        model.addAttribute("userForm", new UserDTO());


        return "registration";
    }

    //fix
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUserAccount(
            @ModelAttribute("userForm") @Valid UserDTO accountDto,
            BindingResult result,
            WebRequest request,
            Errors errors) {

        Users registered = new Users();
        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        if (result.hasErrors()) {
            return "registration";
        } else {
            return "/index";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            return "wrongPassword";
        }

        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }

        return "login";
    }


    private Users createUserAccount(UserDTO accountDto, BindingResult result) {
        Users registered;
        try {
            registered = userService.registerNewUserAccount(accountDto);
        } catch (EmailExistsException e) {
            System.out.println("Email exception!");
            return null;
        }
        return registered;
    }
}
