package com.udemy.backendninja.service.implementation;

import com.udemy.backendninja.component.ContactConverter;
import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.repository.ContactRepository;
import com.udemy.backendninja.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;
    @Autowired
    @Qualifier("contactConverter")
    private ContactConverter contactConverter;

    @Override
    public ContactModel addContact(ContactModel contactModel) {
        Contact contact = contactRepository.save(contactConverter.convertModel2Entity(contactModel));
        return contactConverter.convertEntity2Model(contact);
    }

    @Override
    public List<ContactModel> listAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        List<ContactModel> contactModels = new ArrayList<>();
        for (Contact contact : contacts) {
            contactModels.add(contactConverter.convertEntity2Model(contact));
        }
        return contactModels;
    }

    @Override
    public ContactModel findContactById(int id) {
        return contactConverter.convertEntity2Model(contactRepository.findById(id));
    }

    @Override
    public void removeContact(Integer id) {
        ContactModel contactModel = findContactById(id);
        if (contactModel != null) {
            contactRepository.delete(contactConverter.convertModel2Entity(contactModel));
        }
    }
}
