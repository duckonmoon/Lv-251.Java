package com.softserve.edu.lv251.dao.impl;

import com.softserve.edu.lv251.dao.BaseDAO;
import com.softserve.edu.lv251.dao.ModeratorDAO;
import com.softserve.edu.lv251.entity.Moderator;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;

/**
 * Created by Admin on 31.07.2017.
 */
@Repository
@PersistenceContext
public class ModeratorDAOImpl extends BaseDAOImpl<Moderator> implements ModeratorDAO {
}
