package com.softserve.edu.lv251.controllers.rest;

import com.softserve.edu.lv251.dto.pojos.UserDTO;
import com.softserve.edu.lv251.dto.pojos.UserUpdate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Yana Martynyak on 29.08.2017.
 */
@CrossOrigin(origins = {"*"})
@Controller
public class UserEditController {
    @ResponseBody
    @RequestMapping(value = "/api/editUser",method = RequestMethod.POST)
    public ResponseEntity<Void>saveUser( @RequestBody UserUpdate user ){
        System.out.println(user);
        return new ResponseEntity<Void>( HttpStatus.OK);
    }

}
