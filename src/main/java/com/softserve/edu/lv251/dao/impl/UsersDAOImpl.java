package com.softserve.edu.lv251.dao.impl;

import com.softserve.edu.lv251.dao.UsersDAO;
import com.softserve.edu.lv251.entity.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


/**
 * Created by Marian Brynetskyi on 13.07.2017.
 */
@Transactional
@Repository
public class UsersDAOImpl extends BaseDAOImpl<User> implements UsersDAO {
    @Override
    public List<User> searchByLetters(String letters) {
        String search = "%" + letters + "%".toLowerCase();
        return entityManager.createQuery("from Users d where lower(d.firstname) like" +
                " :letters or lower(d.lastname) like :letters").setParameter("letters", search).getResultList();
    }
}
