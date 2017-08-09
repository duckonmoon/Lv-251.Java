package com.softserve.edu.lv251.controllers;

import com.softserve.edu.lv251.dto.pojos.DoctorDTO;
import com.softserve.edu.lv251.dto.pojos.UserDTO;
import com.softserve.edu.lv251.entity.Doctors;
import com.softserve.edu.lv251.entity.Users;
import com.softserve.edu.lv251.entity.VerificationToken;
import com.softserve.edu.lv251.events.OnRegistrationCompleteEvent;
import com.softserve.edu.lv251.exceptions.EmailExistsException;
import com.softserve.edu.lv251.service.DoctorsService;
import com.softserve.edu.lv251.service.UserService;
import com.softserve.edu.lv251.service.VerificationTokenService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Calendar;
import java.util.Locale;

/**
 * Added by Pavlo Kuchereshko.
 *
 */

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    @Autowired
    DoctorsService doctorsService;

    @Autowired
    VerificationTokenService verificationTokenService;

    @Autowired
    Logger logger;

    @Autowired
    MessageSource messageSource;

    /**
     * The publisher constructs the event object and publishes it to anyone who’s listening.
     */
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new UserDTO());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUserAccount(
            @ModelAttribute("userForm") @Valid UserDTO accountDto,
            BindingResult result,
            WebRequest request,
            Errors errors) {

        if (result.hasErrors()) {
            return "registration";
        }

        Users registered = createUserAccount(accountDto, result);

        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }

        try {
            String appUrl = request.getContextPath();
            applicationEventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, LocaleContextHolder.getLocale(), appUrl));
        } catch (Exception e) {
            logger.error(e);
            return "registration";
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/registrationDoctor", method = RequestMethod.GET)
    public String registrationDoctor(Model model) {
        model.addAttribute("doctorForm", new UserDTO());


        return "registrationDoctor";
    }

    @RequestMapping(value = "/registrationDoctor", method = RequestMethod.POST)
    public String registerDoctorAccount(
            @ModelAttribute("doctorForm") @Valid UserDTO accountDto,
            BindingResult result) {

        Doctors registered = new Doctors();
        if (!result.hasErrors()) {
//            registered = createDoctorAccount(accountDto, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        if (result.hasErrors()) {
            return "registrationDoctor";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET)
    public String finishRegistration(
            @RequestParam("token") String token,
            Model model,
            WebRequest request) {

        Locale locale = LocaleContextHolder.getLocale();

        VerificationToken verificationToken = userService.getVerificationToken(token);
        if (verificationToken == null) {
            String message = messageSource.getMessage("message.invalidToken", null, locale);
            model.addAttribute("message", message);
            return "redirect:/403?lang=" + locale.getLanguage();
        }

        Users user = verificationToken.getUser();
        Calendar calendar = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - calendar.getTime().getTime()) <= 0) {
            String message = messageSource.getMessage("message.invalidToken", null, locale);
            model.addAttribute("message", message);
            return "redirect:/403?lang=" + locale.getLanguage();
        }

        user.setEnabled(true);
        this.userService.updateUser(user);
        this.verificationTokenService.deleteVerificationToken(verificationToken);

        return "successRegistration";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("flag", true);

            return "home";

        }

        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }

        model.addAttribute("login", true);
        return "home";
    }


    private Users createUserAccount(UserDTO accountDto, BindingResult result) {
        Users registered;
        try {
            registered = userService.registerNewUserAccount(accountDto);
        } catch (EmailExistsException e) {
            logger.warn(e);
            return null;
        }
        return registered;
    }

    private Doctors createDoctorAccount(DoctorDTO accountDto, BindingResult result) {
        Doctors registered;
        try {
            registered = doctorsService.registerNewDoctorAccount(accountDto);
        } catch (EmailExistsException e) {
            logger.warn(e);
            return null;
        }
        return registered;
    }
}
