package com.savytskyy.Lesson4.Phonebook.contacts;

import com.savytskyy.Lesson4.Phonebook.contacts.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactsList {
    private List<Contact> contacts = new ArrayList<>();

    public Contact get(int index){
        return contacts.get(index);
    }

    public List<Contact>  getAll(){
        return contacts;
    }

    public void set(int index, Contact c){
        if (indexIsValid(index)) contacts.set(index,c);
    }

    public int size(){
        return contacts.size();
    }

    public void remove (int index){
        if (indexIsValid(index)) contacts.remove(index) ;
    }

    public void add(Contact c){
        contacts.add(c);
    }

    private boolean indexIsValid (int index){
        return index >=0 && index < contacts.size();
    }


}
