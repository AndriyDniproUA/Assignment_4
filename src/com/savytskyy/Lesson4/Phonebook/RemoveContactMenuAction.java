package com.savytskyy.Lesson4.Phonebook;

public class RemoveContactMenuAction implements MenuAction{
    @Override
    public void doAction() {
        System.out.println("***Remove contacts action***");
    }

    @Override
    public String getName() {
        return "RemoveContactMenuAction";
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}
