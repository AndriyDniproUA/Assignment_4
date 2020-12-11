package com.savytskyy.Lesson4.Phonebook.menu.menuactions;

import com.savytskyy.Lesson4.Phonebook.contacts.Contact;
import com.savytskyy.Lesson4.Phonebook.contacts.ContactsList;
import com.savytskyy.Lesson4.Phonebook.contacts.ContactsService;
import com.savytskyy.Lesson4.Phonebook.menu.menuactions.MenuAction;

public class ReadAllContactsMenuAction implements MenuAction {
    ContactsService contactsService;

    public ReadAllContactsMenuAction(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @Override
    public void doAction() {
        ContactsList contacts = contactsService.getAll();


        if (contacts.size() > 0) {
            System.out.println("These are all contacts stored in the memory");
            for (int i = 0; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);
                System.out.printf( "%d- %s, %s\n", i + 1, contact.getName(), contact.getPhone());
            }
            System.out.println();
        } else {
            System.out.println("Sorry, contact list is empty");
            System.out.println();
        }
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
