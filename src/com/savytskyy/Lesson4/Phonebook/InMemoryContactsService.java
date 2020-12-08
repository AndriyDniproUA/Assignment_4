package com.savytskyy.Lesson4.Phonebook;

import java.util.Scanner;

public class InMemoryContactsService implements ContactsService{
    Scanner sc;
    ContactsList contactsList = new ContactsList();

    public InMemoryContactsService(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public ContactsList getAll() {
        return contactsList;
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
