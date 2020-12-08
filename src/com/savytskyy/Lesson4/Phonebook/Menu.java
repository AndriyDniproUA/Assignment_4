package com.savytskyy.Lesson4.Phonebook;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    Scanner sc;
    ContactsService contactsService;

    public Menu(Scanner sc, ContactsService contactsService) {
        this.sc = sc;
        this.contactsService = contactsService;
    }

    private MenuAction[] actions = new MenuAction[0];

    public void run() {
        int choice;
        boolean mustQuit = false;

        buildMenu();
        System.out.println("This is your new contact List manager:");
        System.out.println();

        do {
            System.out.println("This release features the following options:");
            showMenu();
            System.out.println("Please enter the number of your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            int index = choice - 1;
            if (index >= 0 && index < actions.length) {
                actions[index].doAction();
                mustQuit = actions[index].closeAfter();
            }
        } while (!mustQuit);
    }

    public void buildMenu(){
        addAction(new ReadAllContactsMenuAction(contactsService));
        addAction(new AddContactMenuAction(sc, contactsService));
        addAction(new RemoveContactMenuAction(sc, contactsService));
        addAction(new QuitMenuAction());
    }

    private void addAction(MenuAction action) {
        actions = Arrays.copyOf(actions, actions.length + 1);
        actions[actions.length - 1] = action;
    }

    public void showMenu(){
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + 1 + "-" + actions[i].getName());
        }
    }

}
