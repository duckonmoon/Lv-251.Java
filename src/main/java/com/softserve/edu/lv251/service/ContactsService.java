package com.softserve.edu.lv251.service;

import com.softserve.edu.lv251.entity.Contacts;
import com.softserve.edu.lv251.entity.Users;

import java.util.List;

/**
 * Created by : Kovalevskyy Vitaliy
 */
public interface ContactsService {

    void updateContacts(Contacts contacts);
    List<Contacts> getUsersByColumnNameAndValue(String columnName, Object value);
    Contacts getContactsByUserId(Long userId);
}
