package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.dao.ContactsDAO;
import com.softserve.edu.lv251.dao.UsersDAO;
import com.softserve.edu.lv251.config.Mapper;
import com.softserve.edu.lv251.dto.pojos.PasswordDTO;
import com.softserve.edu.lv251.dto.pojos.UserDTO;
import com.softserve.edu.lv251.entity.Contacts;
import com.softserve.edu.lv251.entity.MedicalCard;
import com.softserve.edu.lv251.entity.Users;
import com.softserve.edu.lv251.entity.VerificationToken;
import com.softserve.edu.lv251.exceptions.EmailExistsException;
import com.softserve.edu.lv251.idl.WebRoles;
import com.softserve.edu.lv251.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * Added by Pavlo Kuchereshko.
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersDAO usersDAO;

    @Autowired
    RolesService rolesService;

    @Autowired
    ContactsService contactsService;

    @Autowired
    MedicalCardService medicalCardService;

    @Autowired
    VerificationTokenService verificationTokenService;

    @Autowired
    EntityManager entityManager;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    Mapper mapper;

    @Autowired
    MailService mailService;

    @Override
    public void addUser(Users user) {
        this.usersDAO.addEntity(user);
    }

    @Override
    public void updateUser(Users user) {
        this.usersDAO.updateEntity(user);
    }

    @Override
    public Users getUserByID(Long userId) {
        return this.usersDAO.getEntityByID(userId);
    }

    @Override
    public List<Users> getUsersByColumnNameAndValue(String columnName, Object value) {
        return this.usersDAO.getEntitiesByColumnNameAndValue(columnName, value);
    }

    @Override
    public List<Users> getAllUsers() {
        return this.usersDAO.getAllEntities();
    }

    @Override
    public void deleteUser(Users user) {
        this.usersDAO.deleteEntity(user);
    }

    public Users getFirst() {
        return this.usersDAO.getEntityByID(1L);
    }

    @Override
    public Users findByEmail(String email) {
        List<Users> users = getUsersByColumnNameAndValue("email", email);
        return users.isEmpty() ? null : users.get(0);
    }

    public List<Users> getWithOffsetOrderedByName(int offset, int limit) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Users> criteriaQuery = criteriaBuilder.createQuery(Users.class);
        Root<Users> from = criteriaQuery.from(Users.class);
        CriteriaQuery<Users> select = criteriaQuery.select(from);
        TypedQuery<Users> typedQuery = entityManager.createQuery(select);
        typedQuery.setFirstResult(offset);
        typedQuery.setMaxResults(limit);

        return typedQuery.getResultList();
    }

    @Transactional
    @Override
    public Users registerNewUserAccount(UserDTO accountDto)
            throws EmailExistsException {

        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException("There is an account with that email address: " + accountDto.getEmail());
        }
        Users user = new Users();
        mapper.map(accountDto, user);
        user.setMiddlename("");
        user.setPassword(bCryptPasswordEncoder.encode(accountDto.getPassword()));
        user.setEnabled(false);
        user.setPhoto(StoredImagesService.getDefaultPictureBase64encoded("User_Default.png"));
        user.setRoles(Arrays.asList(rolesService.findByName(WebRoles.ROLE_USER.name())));
        Contacts contact = new Contacts();
        contact.setUsers(user);
        contact.setEmail(accountDto.getEmail());
        MedicalCard medicalCard = new MedicalCard();
        medicalCard.setUser(user);
        this.contactsService.addContacts(contact);
        this.medicalCardService.addMedicalCard(medicalCard);
        user.setContact(contact);
        addUser(user);

        //IT'S WORKS, DO NOT UNCOMMENT)))
        //sendRegistrationEmail(user);

        return user;
    }

    private boolean emailExist(String email) {
        return findByEmail(email) != null;
    }

    @Override
    public void sendRegistrationEmail(Users user) {
        this.mailService.sendEmail(user);
    }

    @Override
    public List<Users> searchByLetters(String search) {
        return usersDAO.searchByLetters(search);
    }

    @Override
    public Users getUserByVerificationToken(String verificationToken) {
        return this.verificationTokenService.findByVerificationToken(verificationToken).getUser();
    }

    @Override
    public void createVerificationToken(Users user, String verificationToken) {
        VerificationToken myVerificationToken = new VerificationToken();
        myVerificationToken.setUser(user);
        myVerificationToken.setToken(verificationToken);
        this.verificationTokenService.addVerificationToken(myVerificationToken);
    }

    @Override
    public VerificationToken getVerificationToken(String verificationToken) {
        return this.verificationTokenService.findByVerificationToken(verificationToken);
    }

    @Transactional
    @Override
    public Users changePassword(Users user, PasswordDTO passwordDTO){
        user.setPassword(bCryptPasswordEncoder.encode(passwordDTO.getPassword()));
        updateUser(user);

        return user;
    }
}
