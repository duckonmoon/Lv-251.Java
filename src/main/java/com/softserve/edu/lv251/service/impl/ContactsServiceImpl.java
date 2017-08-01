package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.dao.ContactsDAO;
import com.softserve.edu.lv251.dto.pojos.ContactDTO;
import com.softserve.edu.lv251.entity.Contacts;
import com.softserve.edu.lv251.entity.Users;
import com.softserve.edu.lv251.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by : Kovalevskyy Vitaliy
 */
public class ContactsServiceImpl implements ContactsService{

    @Autowired
    ContactsDAO contactsDAO;

    public void updateContacts(Contacts contacts){
        this.contactsDAO.updateEntity(contacts);
    }

    @Override
    public List<Contacts> getUsersByColumnNameAndValue(String columnName, Object value) {
        return this.contactsDAO.getEntitiesByColumnNameAndValue(columnName, value);
    }

    @Override
    public Contacts getContactsByUserId(Long userId) {
        List<Contacts> contacts = getUsersByColumnNameAndValue("users", userId);
        return contacts.isEmpty() ? null : contacts.get(0);
    }

}
