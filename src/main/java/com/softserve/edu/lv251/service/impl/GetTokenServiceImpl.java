package com.softserve.edu.lv251.service.impl;

/**
 * Created by Taras on 03.08.2017.
 */

import com.softserve.edu.lv251.dto.pojos.TokenAuthenticationDTO;
import com.softserve.edu.lv251.idl.WebRoles;
import com.softserve.edu.lv251.service.GetTokenService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GetTokenServiceImpl implements GetTokenService {

    @Autowired
    Logger logger;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    public TokenAuthenticationDTO getToken(String username, String password) throws Exception {
        if (username == null || password == null)
            return null;
        User user = (User) userDetailsService.loadUserByUsername(username);
        Map<String, Object> tokenData = new HashMap<>();
        if (password.equals(user.getPassword())) {
            tokenData.put("clientType", "user");
            tokenData.put("username", username);
            tokenData.put("token_create_date", new Date().getTime());
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, 1);
            tokenData.put("token_expiration_date", calendar.getTime().getTime());
            JwtBuilder jwtBuilder = Jwts.builder();
            jwtBuilder.setExpiration(calendar.getTime());
            jwtBuilder.setClaims(tokenData);

            String key = "key123";
            String token = jwtBuilder.signWith(SignatureAlgorithm.HS512, key).compact();

            TokenAuthenticationDTO authentication = new TokenAuthenticationDTO();

            authentication.setToken(token);
            authentication.setUsername(user.getUsername());
            for(GrantedAuthority authority: user.getAuthorities()){
                logger.log(Priority.INFO, authority.getAuthority());
                if(authority.getAuthority().equals(WebRoles.ROLE_USER.name())){
                    authentication.setIsUser(true);
                }
                if(authority.getAuthority().equals(WebRoles.ROLE_DOCTOR.name())){
                    authentication.setIsDoctor(true);
                }
            }


            return authentication;
        } else {
            throw new Exception("Authentication error");
        }
    }

}
