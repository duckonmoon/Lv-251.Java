package com.softserve.edu.lv251.service.impl;

/**
 * Created by Taras on 03.08.2017.
 */

import com.softserve.edu.lv251.service.GetTokenService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GetTokenServiceImpl implements GetTokenService {

    @Autowired
    Logger logger;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    public String getToken(String username, String password) throws Exception {
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
            logger.log(Priority.INFO, token);
            logger.log(Priority.INFO, "strt: " + new Date().getTime());
            logger.log(Priority.INFO, "exp: " + calendar.getTime().getTime());
            return token;
        } else {
            throw new Exception("Authentication error");
        }
    }

}
