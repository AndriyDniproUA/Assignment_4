package com.savytskyy.Lesson4.Phonebook.menu.menuactions;

import com.savytskyy.Lesson4.Phonebook.contacts.Contact;
import com.savytskyy.Lesson4.Phonebook.contacts.ContactsList;
import com.savytskyy.Lesson4.Phonebook.contacts.ContactsService;
import com.savytskyy.Lesson4.Phonebook.menu.menuactions.MenuAction;

import java.util.List;

public class ReadAllContactsMenuAction implements MenuAction {
    ContactsService contactsService;

    public ReadAllContactsMenuAction(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @Override
    public void doAction() {
        List<Contact> contacts = contactsService.getAll();

        if (contacts.size() > 0) {
            System.out.println("These are all contacts stored in the memory");
            contacts.stream()
                    .forEach(contact ->System.out.printf( "%s, %s\n", contact.getName(), contact.getPhone()));
        } else {
            System.out.println("Sorry, contact list is empty");
            System.out.println();
        }
        System.out.println("-----------------------------------------");
    }

        @Override
        public String getName () {
            return "Read all contacts";
        }

        @Override
        public boolean closeAfter () {
            return false;
        }
    }
