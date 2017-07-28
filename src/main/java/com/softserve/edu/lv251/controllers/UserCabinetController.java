package com.softserve.edu.lv251.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Author: Brynetskyi Marian
 */
@Controller
public class UserCabinetController {

    @RequestMapping(value = "/user/cabinet",method = RequestMethod.GET)
    public String home(ModelMap model){
        return "user_cabinet";
    }
}
