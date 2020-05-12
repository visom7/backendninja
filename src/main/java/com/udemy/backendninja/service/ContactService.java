package com.udemy.backendninja.service;

import com.udemy.backendninja.model.ContactModel;

import java.util.List;

public interface ContactService {
    public abstract ContactModel addContact(ContactModel contactModel);
    public abstract List<ContactModel> listAllContacts();
    public abstract ContactModel findContactById(int id);
    public abstract void removeContact(int id);
}
