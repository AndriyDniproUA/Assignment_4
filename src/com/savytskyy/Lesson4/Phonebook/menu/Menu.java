package com.savytskyy.Lesson4.Phonebook.menu;

import com.savytskyy.Lesson4.Phonebook.contacts.ContactsService;
import com.savytskyy.Lesson4.Phonebook.menu.menuactions.*;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    private Scanner sc;
    private ContactsService contactsService;
    private MenuAction[] actions;

    public Menu(Scanner sc, ContactsService contactsService) {
        actions = new MenuAction[0];
        this.sc = sc;
        this.contactsService = contactsService;
    }

    public void run() {
        System.out.println("This is your new contact List manager:");

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("You've got the following options:");
            showMenu();
            int choice = askUserChoice();
            int index = choice - 1;
            if (indexIsValid(index)) {
                actions[index].doAction();
            } else {
                System.out.printf("Please enter the number within 1-%d range\n", actions.length);
                continue;
            }
            if (actions[index].closeAfter()) break;
        }
    }


    public void addAction(MenuAction action) {
        actions = Arrays.copyOf(actions, actions.length + 1);
        actions[actions.length - 1] = action;
    }

    public void showMenu() {
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + 1 + "-" + actions[i].getName());
        }
        System.out.println("---------------------------------");
    }

    private int askUserChoice() {
        System.out.println("Please enter the number of your desired option: ");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    private boolean indexIsValid(int index) {
        return index >= 0 && index < actions.length;
    }


}
