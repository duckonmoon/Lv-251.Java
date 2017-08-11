package com.softserve.edu.lv251.customhandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * Added by Pavlo Kuchereshko.
 */
@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        setDefaultFailureUrl("/login?error=true");

        super.onAuthenticationFailure(request, response, exception);

        Locale locale = request.getLocale();

        String errorMessage = messageSource.getMessage("message.badCredentials", null, locale);

        if (exception.getMessage().equalsIgnoreCase("User is disabled")) {
            errorMessage = messageSource.getMessage("message.disabled", null, locale);
        } else if (exception.getMessage().equalsIgnoreCase("User account has expired")) {
            errorMessage = messageSource.getMessage("message.expired", null, locale);
        }

        request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, errorMessage);
    }
}
