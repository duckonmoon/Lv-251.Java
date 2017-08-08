package com.softserve.edu.lv251.config;
import com.softserve.edu.lv251.UserDetailsEditor.UpdatableUserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by Marian Brynetskyi
 * Security initializer. initialize filterChain
 */
public class SecurityWebApplicationInitializer
        extends AbstractSecurityWebApplicationInitializer {

//    @Bean
//    public UpdatableUserDetails updatableUserDetails(User user){
//        UpdatableUserDetails updatableUserDetails = new UpdatableUserDetails(user.getUsername(), user.getPassword(), user.getAuthorities());
//        return updatableUserDetails;
//    }
}
