package com.savytskyy.Lesson4.Phonebook;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactsService contactsService = new InMemoryContactsService(sc);

        Menu menu = new Menu(sc, contactsService);
        menu.run();
    }
}
