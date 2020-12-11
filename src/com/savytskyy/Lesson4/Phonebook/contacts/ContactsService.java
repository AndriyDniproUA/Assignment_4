package com.savytskyy.Lesson4.Phonebook.contacts;

import com.savytskyy.Lesson4.Phonebook.contacts.Contact;
import com.savytskyy.Lesson4.Phonebook.contacts.ContactsList;

public interface ContactsService {
    ContactsList getAll();
    void remove (int index);
    void add(Contact c);
}
