package com.savytskyy.Lesson4.Phonebook;

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
        System.out.println("Please enter the the number of the contact that needs to be removed: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < contactsService.getAll().size()) {
            contactsService.remove(index);
        } else {
            System.out.println("Sorry, you entered the wrong number!");
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
