package com.savytskyy.Lesson4.Phonebook.contacts;

import java.util.List;

public interface ContactsService {
    List<Contact> getAll();
    void remove (int index);
    void add(Contact c);
}
