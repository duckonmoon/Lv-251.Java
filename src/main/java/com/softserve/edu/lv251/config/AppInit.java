package com.softserve.edu.lv251.config;

/**
 * Created by Taras on 16.07.2017.
 */

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                DatabaseConfig.class,
                WebSecurityConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class<?>[]{
                WebConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        initCharacterEncodingFilter(servletContext);
    }

    private void initCharacterEncodingFilter(final ServletContext servletContext) {
        final CharacterEncodingFilter utf8 = new CharacterEncodingFilter();
        utf8.setEncoding("utf-8");
        utf8.setForceEncoding(true);
        servletContext.addFilter("SetCharacterEncodingFilter", utf8)
                .addMappingForUrlPatterns(null, false, "/*");
    }
}