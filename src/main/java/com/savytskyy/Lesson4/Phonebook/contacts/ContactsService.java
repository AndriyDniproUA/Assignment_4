package main.java.com.savytskyy.Lesson4.Phonebook.contacts;

import main.java.com.savytskyy.Lesson4.Phonebook.contacts.Contact;
import main.java.com.savytskyy.Lesson4.Phonebook.contacts.ContactsList;

import java.util.List;

public interface ContactsService {
    List<Contact> getAll();
    void remove (int index);
    void add(Contact c);
}
