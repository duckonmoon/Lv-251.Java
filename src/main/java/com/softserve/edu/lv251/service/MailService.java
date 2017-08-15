package com.softserve.edu.lv251.service;

import com.softserve.edu.lv251.entity.Users;

/**
 * Added by Pavlo Kuchereshko.
 *
 */
public interface MailService {
    void sendEmail(final Users user, String messageText);
}
