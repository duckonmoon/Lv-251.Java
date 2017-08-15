package com.softserve.edu.lv251.dao.impl;

import com.softserve.edu.lv251.dao.AdminDAO;
import com.softserve.edu.lv251.entity.Admin;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;

/**
 * Created by Shmidt on 15.08.2017.
 */
@Repository
@PersistenceContext
public class AdminDAOImpl extends BaseDAOImpl<Admin> implements AdminDAO {
}
