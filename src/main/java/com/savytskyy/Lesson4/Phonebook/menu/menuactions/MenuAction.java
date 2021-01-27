package com.savytskyy.Lesson4.Phonebook.menu.menuactions;

public interface MenuAction {
    void doAction();
    String getName();
    boolean closeAfter();
}
