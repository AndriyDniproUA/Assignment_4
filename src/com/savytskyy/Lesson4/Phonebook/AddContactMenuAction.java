package com.savytskyy.Lesson4.Phonebook;

public class AddContactMenuAction implements MenuAction{
    @Override
    public void doAction() {
        System.out.println("***Add contact menu action***");

    }

    @Override
    public String getName() {
        return "AddContactMenuAction";
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}
