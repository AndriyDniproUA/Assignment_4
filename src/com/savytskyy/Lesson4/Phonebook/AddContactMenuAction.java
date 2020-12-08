package com.savytskyy.Lesson4.Phonebook;

import java.util.Scanner;

public class AddContactMenuAction implements MenuAction{
   Scanner sc;
   ContactsService contactsService;

    public AddContactMenuAction(Scanner sc, ContactsService contactsService) {
        this.sc = sc;
        this.contactsService = contactsService;
    }

    @Override
    public void doAction() {
        String name, phone;
        System.out.print("Please enter the name: ");
        name = sc.next();
        sc.nextLine();
        System.out.print("Please enter the phone: ");
        phone = sc.next();
        sc.nextLine();
        Contact contact = new Contact(name, phone);
        contactsService.add(contact);
    }

    @Override
    public String getName() {
        return "Add Contact";
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}
