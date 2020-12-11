package com.savytskyy.Lesson4.Phonebook.contacts;

import com.savytskyy.Lesson4.Phonebook.contacts.Contact;

import java.util.Arrays;

public class ContactsList {
    private Contact[] contacts = new Contact[0];

    public Contact get(int index){
        return contacts[index];
    }

    public void set(int index, Contact c){
        contacts[index] = c;
    }

    public int size(){
        return contacts.length;
    }

    public void remove (int index){
        if (index >=0 && index < contacts.length){
            Contact[] buffer = new Contact[contacts.length-1];
            for (int i = 0; i < buffer.length; i++) {
                buffer [i] = contacts [i<index? i : i+1];
            }
            contacts = buffer;
        }
    }

    public void add(Contact c){
        contacts = Arrays.copyOf(contacts, contacts.length+1);
        contacts[contacts.length-1] = c;
    }






}
