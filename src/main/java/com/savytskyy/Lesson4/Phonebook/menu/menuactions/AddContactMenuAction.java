package main.java.com.savytskyy.Lesson4.Phonebook.menu.menuactions;

import main.java.com.savytskyy.Lesson4.Phonebook.contacts.Contact;
import main.java.com.savytskyy.Lesson4.Phonebook.contacts.ContactsService;

import java.util.Scanner;

public class AddContactMenuAction implements MenuAction {
   Scanner sc;
   ContactsService contactsService;

    public AddContactMenuAction(Scanner sc, ContactsService contactsService) {
        this.sc = sc;
        this.contactsService = contactsService;
    }

    @Override
    public void doAction() {
        String name, phone;
        System.out.print("Please enter the name: ");
        name = sc.next();
        sc.nextLine();
        while (true) {
            System.out.print("Please enter the phone: ");
            phone = sc.next();
            sc.nextLine();
            if (checkPhoneNumberPattern(phone)) break;
            else {
                System.out.println("Your number should follow the pattern: +38 *** *** ** ** (without spaces)");
                continue;
            }
        }
        Contact contact = new Contact(name, phone);
        contactsService.add(contact);
    }

    @Override
    public String getName() {
        return "Add Contact";
    }

    @Override
    public boolean closeAfter() {
        return false;
    }

    private boolean checkPhoneNumberPattern(String number) {
        String phoneNumberPattern = "\\+38\\d{10}";
        return number.matches(phoneNumberPattern);
    }

}
