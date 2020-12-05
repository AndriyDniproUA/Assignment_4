package com.savytskyy.Lesson4.Phonebook;

public class ReadAllContactsMenuAction implements MenuAction{
    @Override
    public void doAction() {
        System.out.println("***Read all contacts action***");
    }

    @Override
    public String getName() {
        return "ReadAllContactsMenuAction";
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}
