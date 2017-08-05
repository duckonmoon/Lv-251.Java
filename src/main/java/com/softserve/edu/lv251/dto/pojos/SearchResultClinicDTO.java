package com.softserve.edu.lv251.dto.pojos;

/**
 * Created by Taras on 05.08.2017.
 */
public class SearchResultClinicDTO {
    private long id;
    private String name;
    private String description;
    private String photo;

    private ContactsDTO contacts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public ContactsDTO getContacts() {
        return contacts;
    }

    public void setContacts(ContactsDTO contacts) {
        this.contacts = contacts;
    }
}
