package com.savytskyy.Lesson4.Phonebook;

import java.util.Scanner;

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
                System.out.print(i + 1 + "-");
                System.out.print(contacts.get(i).getName() + "   ");
                System.out.println(contacts.get(i).getPhone());
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
