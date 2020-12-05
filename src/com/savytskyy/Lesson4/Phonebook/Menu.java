package com.savytskyy.Lesson4.Phonebook;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    private MenuAction[] actions = new MenuAction[0];
    int choice = -1;

    private void addAction(MenuAction action) {
        actions = Arrays.copyOf(actions, actions.length + 1);
        actions[actions.length - 1] = action;
    }

    public void buildMenu() {
        addAction(new ReadAllContactsMenuAction());
        addAction(new AddContactMenuAction());
        addAction(new RemoveContactMenuAction());
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("This is your contact List manager:");

        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + 1 + "-" + actions[i].getName());
        }
        System.out.println("4-quit the program");

        System.out.println("Please enter the number of your choice: ");
        choice = sc.nextInt();
        sc.nextLine();
        int index = choice - 1;
        if (index >= 0 && index < actions.length) {
            actions[index].doAction();
        }
    }
}
