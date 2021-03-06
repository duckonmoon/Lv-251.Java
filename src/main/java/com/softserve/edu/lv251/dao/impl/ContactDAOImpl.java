package com.softserve.edu.lv251.dao.impl;

import com.softserve.edu.lv251.dao.ContactDAO;
import com.softserve.edu.lv251.entity.Contact;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by kilopo on 13.07.2017.
 */
@Transactional
@Repository
public class ContactDAOImpl extends BaseDAOImpl<Contact> implements ContactDAO {
}
