package com.savytskyy.Lesson4.Phonebook.menu.menuactions;

import com.savytskyy.Lesson4.Phonebook.contacts.Contact;
import com.savytskyy.Lesson4.Phonebook.contacts.ContactsList;
import com.savytskyy.Lesson4.Phonebook.contacts.ContactsService;

import java.util.Scanner;

public class FindNumberPartMenuAction implements MenuAction {
    Scanner sc;
    ContactsService contactsService;

    public FindNumberPartMenuAction(Scanner sc, ContactsService contactsService) {
        this.sc = sc;
        this.contactsService = contactsService;
    }

    @Override
    public void doAction() {
        ContactsList contacts = contactsService.getAll();
        System.out.print("Please enter a part of the number you wish to find: ");
        String targetNumberPart = sc.nextLine();
        System.out.println("---------------------------------");
        boolean foundAny = false;

        for (int i = 0; i < contacts.size(); i++) {
            String name = contacts.get(i).getName();
            String phone = contacts.get(i).getPhone();
            if (phone.contains(targetNumberPart)) {
                System.out.printf("%d- %s, %s\n", i + 1, name, phone);
                foundAny = true;
            }
        }
        if (!foundAny) {
            System.out.println("Sorry, no matches found!");
        }
        System.out.println("---------------------------------");
    }

    @Override
    public String getName() {
        return "Find contact by part of the phone number";
    }

    @Override
    public boolean closeAfter() {
        return false;
    }


}


