package main.java.com.savytskyy.Lesson4.Phonebook.menu.menuactions;

import main.java.com.savytskyy.Lesson4.Phonebook.contacts.Contact;
import main.java.com.savytskyy.Lesson4.Phonebook.contacts.ContactsList;
import main.java.com.savytskyy.Lesson4.Phonebook.contacts.ContactsService;

import java.util.ArrayList;
import java.util.List;
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
        List<Contact> contacts = contactsService.getAll();


        System.out.print("Please enter a part of the number you wish to find: ");
        String targetNumberPart = sc.nextLine();
        System.out.println("---------------------------------");

        contacts.stream()
                .filter(s -> s.getPhone().contains(targetNumberPart))
                .forEach(s -> System.out.printf("%s, %s\n", s.getName(), s.getPhone()))
        ;

        System.out.println("---------------------------------");

        //TODO АРТУР: КАК МОЖНО ВЫВЕСТИ ИНДЕКС НАЙДЕННОГО КОНТАКТА ПРИ ИСПОЛЬЗОВАНИИ ПОТОКА?
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


