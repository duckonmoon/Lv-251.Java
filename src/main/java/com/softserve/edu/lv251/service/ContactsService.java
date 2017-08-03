package com.softserve.edu.lv251.service;

import com.softserve.edu.lv251.entity.Contacts;
import com.softserve.edu.lv251.entity.Users;

import java.util.List;

/**
 * Created by : Kovalevskyy Vitaliy
 */
public interface ContactsService {

    void addContacts(Contacts contact);
    void updateContacts(Contacts contacts);
}
