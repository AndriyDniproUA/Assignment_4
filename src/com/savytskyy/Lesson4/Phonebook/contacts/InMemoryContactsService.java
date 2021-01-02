package com.savytskyy.Lesson4.Phonebook.contacts;

import com.savytskyy.Lesson4.Phonebook.contacts.Contact;
import com.savytskyy.Lesson4.Phonebook.contacts.ContactsList;
import com.savytskyy.Lesson4.Phonebook.contacts.ContactsService;

import java.util.List;
import java.util.Scanner;

public class InMemoryContactsService implements ContactsService {
    Scanner sc;
    ContactsList contactsList = new ContactsList();

    public InMemoryContactsService(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public List<Contact> getAll() {
        return contactsList.getAll();
    }

    @Override
    public void remove(int index) {
        contactsList.remove(index);
    }

    @Override
    public void add(Contact c) {
        contactsList.add(c);
    }
}
