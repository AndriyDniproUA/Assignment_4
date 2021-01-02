package com.savytskyy.Lesson4.Phonebook.menu.menuactions;

import com.savytskyy.Lesson4.Phonebook.contacts.Contact;
import com.savytskyy.Lesson4.Phonebook.contacts.ContactsList;
import com.savytskyy.Lesson4.Phonebook.contacts.ContactsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

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
        List<Contact> contactsArray = new ArrayList<>();

        for (int i = 0; i < contacts.size(); i++) {
            contactsArray.add(contacts.get(i));
        }

        System.out.print("Please enter the beginning of the name to find: ");
        String targetNameBeginning = sc.nextLine();

        System.out.println("---------------------------------");
        contactsArray.stream()
                .filter(s -> s.getName().toLowerCase().startsWith(targetNameBeginning.toLowerCase()))
                .forEach(s -> System.out.printf("%s, %s\n", s.getName(), s.getPhone()));
        System.out.println("---------------------------------");

        //TODO АРТУР: КАК МОЖНО ВЫВЕСТИ ИНДЕКС НАЙДЕННОГО КОНТАКТА ПРИ ИСПОЛЬЗОВАНИИ ПОТОКА?

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


