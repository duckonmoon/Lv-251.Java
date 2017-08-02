package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.dao.ContactsDAO;
import com.softserve.edu.lv251.dto.pojos.ContactDTO;
import com.softserve.edu.lv251.entity.Contacts;
import com.softserve.edu.lv251.entity.Users;
import com.softserve.edu.lv251.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by : Kovalevskyy Vitaliy
 */
@Service
public class ContactsServiceImpl implements ContactsService{

    @Autowired
    ContactsDAO contactsDAO;

    @Override
    public void addContacts(Contacts contacts) {
        this.contactsDAO.addEntity(contacts);
    }

    public void updateContacts(Contacts contacts){
        this.contactsDAO.updateEntity(contacts);
    }

    @Override
    public List<Contacts> getContactsByColumnNameAndValue(String columnName, Object value) {
        return this.contactsDAO.getEntitiesByColumnNameAndValue(columnName, value);
    }

    @Override
    public Contacts getContactsByUser(Users user) {
        List<Contacts> contacts = getContactsByColumnNameAndValue("users", user.getId());
        return contacts.isEmpty() ? null : contacts.get(0);
    }

}
