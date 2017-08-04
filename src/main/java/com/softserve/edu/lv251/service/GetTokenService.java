package com.softserve.edu.lv251.service;

/**
 * Created by Taras on 03.08.2017.
 */
public interface GetTokenService {
    public String getToken(String username, String password) throws Exception;
}
