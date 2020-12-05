package com.savytskyy.Lesson4.Phonebook;

public interface ContactsService {
    ContactsList getAll();
    void remove (int index);
    void add(Contact c);
}
