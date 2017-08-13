package com.softserve.edu.lv251.dao.impl;

import com.softserve.edu.lv251.dao.VerificationTokenDAO;
import com.softserve.edu.lv251.entity.VerificationToken;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Added by Pavlo Kuchereshko.
 */
@Transactional
@Repository
public class VerificationTokenDAOImpl extends BaseDAOImpl<VerificationToken> implements VerificationTokenDAO {
}
