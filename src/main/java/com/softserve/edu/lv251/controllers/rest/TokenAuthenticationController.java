package com.softserve.edu.lv251.controllers.rest;

import com.softserve.edu.lv251.dto.pojos.TokenAuthenticationDTO;
import com.softserve.edu.lv251.service.GetTokenService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Taras on 03.08.2017.
 */
@RestController
public class TokenAuthenticationController {

    @Autowired
    public GetTokenService getTokenService;

    @Autowired
    Logger logger;

    @RequestMapping("rest/auth")
    public TokenAuthenticationDTO auth(@RequestParam(name = "email")String email,
                                       @RequestParam(name = "password")String password){
        try {
            return getTokenService.getToken(email, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
