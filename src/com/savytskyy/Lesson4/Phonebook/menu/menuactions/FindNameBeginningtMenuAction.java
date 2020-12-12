package com.savytskyy.Lesson4.Phonebook.menu.menuactions;

import com.savytskyy.Lesson4.Phonebook.contacts.ContactsList;
import com.savytskyy.Lesson4.Phonebook.contacts.ContactsService;

import java.util.Scanner;

public class FindNameBeginningtMenuAction implements MenuAction {
    Scanner sc;
    ContactsService contactsService;

    public FindNameBeginningtMenuAction(Scanner sc, ContactsService contactsService) {
        this.sc = sc;
        this.contactsService = contactsService;
    }

    @Override
    public void doAction() {
        ContactsList contacts = contactsService.getAll();
        System.out.print("Please enter the beginning of the name to find: ");
        String targetNameBeginning = sc.nextLine();
        System.out.println("---------------------------------");
        boolean foundAny = false;

        for (int i = 0; i < contacts.size(); i++) {
            String name = contacts.get(i).getName();
            String phone = contacts.get(i).getPhone();
            if (name.toLowerCase().startsWith(targetNameBeginning.toLowerCase())) {
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
        return "Find contact by the beginning of the name";
    }

    @Override
    public boolean closeAfter() {
        return false;
    }


}


