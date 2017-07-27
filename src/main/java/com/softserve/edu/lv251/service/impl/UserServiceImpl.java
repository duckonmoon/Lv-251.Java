package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.dao.ContactsDAO;
import com.softserve.edu.lv251.dao.UsersDAO;
import com.softserve.edu.lv251.dto.Mapper;
import com.softserve.edu.lv251.dto.pojos.UserDTO;
import com.softserve.edu.lv251.entity.Contacts;
import com.softserve.edu.lv251.entity.Users;
import com.softserve.edu.lv251.exceptions.EmailExistsException;
import com.softserve.edu.lv251.idl.WebRoles;
import com.softserve.edu.lv251.service.RolesService;
import com.softserve.edu.lv251.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    ContactsDAO contactsDAO;

    @Autowired
    UsersDAO usersDAO;

    @Autowired
    RolesService rolesService;

    @Autowired
    EntityManager entityManager;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    Mapper mapper;

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
        return usersDAO.getEntityByID(1L);
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
        user.setFirstname(accountDto.getFirstName());
        user.setLastname(accountDto.getLastName());
        user.setMiddlename("");
        user.setPassword(bCryptPasswordEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
        user.setEnabled(true);
        user.setPhoto(StoredImagesService.getDefaultPictureBase64encoded("User_Default.png"));
        user.setRoles(Arrays.asList(rolesService.findByName(WebRoles.ROLE_USER.name())));
        //user.setAppointments(new ArrayList<>());
        //user.setMedicalCards(new ArrayList<>());
        //user.setTestsResults(new ArrayList<>());
        Contacts contact = new Contacts();
        contact.setUsers(user);
        contact.setEmail(accountDto.getEmail());
        this.contactsDAO.addEntity(contact);
        user.setContact(contact);
        addUser(user);

        return user;
    }

    private boolean emailExist(String email) {
        return findByEmail(email) != null;
    }
}
