package com.savytskyy.Lesson4.Phonebook.menu;

import com.savytskyy.Lesson4.Phonebook.contacts.ContactsService;
import com.savytskyy.Lesson4.Phonebook.menu.menuactions.MenuAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner sc;
    private ContactsService contactsService;
    private List<MenuAction> actions;

    public Menu(Scanner sc, ContactsService contactsService) {
        actions = new ArrayList<MenuAction>();
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
                actions.get(index).doAction();
            } else {
                System.out.printf("Please enter the number within 1-%d range\n", actions.size());
                continue;
            }
            if (actions.get(index).closeAfter()) break;
        }
    }


    public void addAction(MenuAction action) {
        actions.add(action);
    }

    public void showMenu() {
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(i + 1 + "-" + actions.get(i).getName());
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
        return index >= 0 && index < actions.size();
    }


}
