package com.softserve.edu.lv251.config;

import com.softserve.edu.lv251.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    DataSource dataSource;

    public WebSecurityConfig() {
        super(false);
    }

    /**
     * Author: Pavlo Kuchereshko.
     * Will be used to encode the raw password. Generally, a good encoding algorithm applies a SHA-1
     * or greater hash combined with an 8-byte or greater randomly generated salt.
     * @return BCryptPasswordEncoder.
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() { return new BCryptPasswordEncoder();}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.csrf()
                    .disable()
                    .authorizeRequests()
                    .antMatchers("/resources/**", "/**").permitAll()
                    .anyRequest().permitAll()
                    .and();

            http.formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/j_spring_security_check")
                    .failureUrl("/clinics")
                    .usernameParameter("j_username")
                    .passwordParameter("j_password")
                    .permitAll();

            http.logout()
                    .permitAll()
                    .logoutUrl("/index")
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true);
    }


    /**
     * Added by Pavlo Kuchereshko.
     * AuthenticationManagerBuilder builds AuthenticationManager using which in-memory,
     * JDBC and LDAP authentication is performed.
     * @param auth;
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }

    /**
     * Added by Pavlo Kuchereshko.
     * A production-quality AuthenticationProvider implementation called DaoAuthenticationProvider.
     * @return DaoAuthenticationProvider;
     */
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authProvider;
    }

}
