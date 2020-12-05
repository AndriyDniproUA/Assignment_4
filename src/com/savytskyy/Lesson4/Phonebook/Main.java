package com.savytskyy.Lesson4.Phonebook;

public class Main {

    public static void main(String[] args) {
        InMemoryContactsService inMemoryContactsService = new InMemoryContactsService();
        Menu menu = new Menu();
        menu.buildMenu();
        while (menu.choice != 4) {
            menu.run();
        }
    }
}
