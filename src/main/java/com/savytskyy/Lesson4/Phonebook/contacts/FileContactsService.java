package main.java.com.savytskyy.Lesson4.Phonebook.contacts;

import java.util.List;
import java.util.Scanner;

public class FileContactsService implements ContactsService {
    Scanner sc;
    ContactsList contactsList = new ContactsList();

    public FileContactsService(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public List<Contact> getAll() {
        return contactsList.getAll();
    }

    //TODO НАПИСАТЬ МЕТОД ДЛЯ УДАЛЕНИЯ КОНТАКТА ИЗ ФАЙЛА
    @Override
    public void remove(int index) {
        contactsList.remove(index);
    }

    //TODO НАПИСАТЬ МЕТОД ДЛЯ ДОБАВЛЕНИЯ КОНТАКТА В ФАЙЛ
    @Override
    public void add(Contact c) {
        contactsList.add(c);
    }
}
