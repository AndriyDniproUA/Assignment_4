package com.savytskyy.Lesson4.Phonebook.menu.menuactions;

import com.savytskyy.Lesson4.Phonebook.contacts.Contact;
import com.savytskyy.Lesson4.Phonebook.contacts.ContactsService;
import com.savytskyy.Lesson4.Phonebook.menu.menuactions.MenuAction;

import java.util.Scanner;

public class RemoveContactMenuAction implements MenuAction {
    Scanner sc;
    ContactsService contactsService;

    public RemoveContactMenuAction(Scanner sc, ContactsService contactsService) {
        this.sc = sc;
        this.contactsService = contactsService;
    }

    @Override
    public void doAction() {
        System.out.println("Please enter the Name of the contact that needs to be removed: ");
        String name = sc.next();
        sc.nextLine();
        boolean contactRemoved = false;

        int index = 0;

        for (Contact contact : contactsService.getAll()) {
            if (contact.getName().toLowerCase().equals(name.toLowerCase())) {
                contactsService.remove(index);
                contactRemoved = true;
                break;
            }
            index++;
        }

        if (!contactRemoved) {
            System.out.println("Sorry, you entered the wrong Name!");
            System.out.println();
        }
    }

        @Override
        public String getName () {
            return "Remove Contact";
        }

        @Override
        public boolean closeAfter () {
            return false;
        }
    }
