package com.savytskyy.Lesson4.Phonebook.menu;

import com.savytskyy.Lesson4.Phonebook.contacts.ContactsService;
import com.savytskyy.Lesson4.Phonebook.contacts.FileContactsService;
//import main.java.com.savytskyy.Lesson4.Phonebook.contacts.InMemoryContactsService;
import com.savytskyy.Lesson4.Phonebook.menu.menuactions.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //ContactsService contactsService = new InMemoryContactsService(sc);
        ContactsService contactsService = new FileContactsService(sc);

//        contactsService.add(new Contact(Contact.ContactType.PHONE, "Sue", "+380671112233"));
//        contactsService.add(new Contact(Contact.ContactType.PHONE,"Tim", "+380662223344"));
//        contactsService.add(new Contact(Contact.ContactType.PHONE,"Bob", "+380952223344"));

        Menu menu = new Menu(sc, contactsService);
        menu.addAction(new ReadAllContactsMenuAction(contactsService));
        menu.addAction(new AddContactMenuAction(sc, contactsService));
        menu.addAction(new RemoveContactMenuAction(sc, contactsService));
        menu.addAction(new FindNumberPartMenuAction(sc, contactsService));
        menu.addAction(new FindNameBeginningtMenuAction(sc, contactsService));
        menu.addAction(new QuitMenuAction());
        menu.run();
    }
}




