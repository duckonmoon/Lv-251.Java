package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.dao.ContactsDAO;
import com.softserve.edu.lv251.entity.Contact;
import com.softserve.edu.lv251.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by : Kovalevskyy Vitaliy
 */
@Service
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    private ContactsDAO contactsDAO;

    @Override
    public void addContacts(Contact contact) {
        this.contactsDAO.addEntity(contact);
    }

    public void updateContacts(Contact contact) {
        this.contactsDAO.updateEntity(contact);
    }

}
