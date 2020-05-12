package com.udemy.backendninja.component;

import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;
import org.springframework.stereotype.Component;

@Component("contactConverter")
public class ContactConverter {

    public Contact convertModel2Entity(ContactModel contactModel) {
        Contact contact = new Contact();
        contact.setCity(contactModel.getCity());
        contact.setFirstName(contactModel.getFirstName());
        contact.setLastName(contactModel.getLastName());
        contact.setTelephone(contactModel.getTelephone());
        contact.setId(contactModel.getId());
        return contact;
    }

    public ContactModel convertEntity2Model(Contact contact) {
        ContactModel contactModel = new ContactModel();
        contactModel.setCity(contact.getCity());
        contactModel.setFirstName(contact.getFirstName());
        contactModel.setLastName(contact.getLastName());
        contactModel.setTelephone(contact.getTelephone());
        contactModel.setId(contact.getId());
        return contactModel;
    }
}
