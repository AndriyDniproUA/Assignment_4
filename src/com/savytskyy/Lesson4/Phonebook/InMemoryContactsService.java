package com.savytskyy.Lesson4.Phonebook;

public class InMemoryContactsService implements ContactsService{
    ContactsList contactsList = new ContactsList();

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
