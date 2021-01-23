package main.java.com.savytskyy.Lesson4.Phonebook.menu.menuactions;

import main.java.com.savytskyy.Lesson4.Phonebook.contacts.Contact;
import main.java.com.savytskyy.Lesson4.Phonebook.contacts.ContactsList;
import main.java.com.savytskyy.Lesson4.Phonebook.contacts.ContactsService;

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
        List<Contact> contacts = contactsService.getAll();

        System.out.print("Please enter the beginning of the name to find: ");
        String targetNameBeginning = sc.nextLine();

        System.out.println("---------------------------------");
        contacts.stream()
                .filter(s -> s.getName().toLowerCase().startsWith(targetNameBeginning.toLowerCase()))
                .forEach(s -> System.out.printf("%s, %s\n", s.getName(), s.getContactInfo()));
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


