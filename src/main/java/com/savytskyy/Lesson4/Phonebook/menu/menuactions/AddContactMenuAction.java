package main.java.com.savytskyy.Lesson4.Phonebook.menu.menuactions;

import main.java.com.savytskyy.Lesson4.Phonebook.contacts.Contact;
import main.java.com.savytskyy.Lesson4.Phonebook.contacts.ContactsService;

import java.util.Scanner;

import static main.java.com.savytskyy.Lesson4.Phonebook.contacts.Contact.ContactType.PHONE;

public class AddContactMenuAction implements MenuAction {
    Scanner sc;
    ContactsService contactsService;

    public AddContactMenuAction(Scanner sc, ContactsService contactsService) {
        this.sc = sc;
        this.contactsService = contactsService;
    }

    @Override
    public void doAction() {
        Contact.ContactType type;
        String name, phone, email, typeInput;

        System.out.print("Please enter the name: ");
        name = sc.next();
        sc.nextLine();

        System.out.print("Please enter contact type (EMAIl/PHONE): ");
        while (true) {
            typeInput = sc.next();
            System.out.println(typeInput);
            if (typeInput.toLowerCase().equals("email") || typeInput.toLowerCase().equals("phone")) break;
            else {
                System.out.println("Please choose one of two options: EMAIl/PHONE");
            }
        }
        type = Contact.ContactType.valueOf(typeInput.toUpperCase());


        switch (type) {
            case PHONE: {
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
                Contact contact = new Contact(name, type, phone);
                contactsService.add(contact);
                break;
            }
            case EMAIL: {
                while (true) {
                    System.out.print("Please enter the email address: ");
                    email = sc.next();
                    sc.nextLine();
                    if (checkEmailPattern(email)) break;
                    else {
                        System.out.println("Your email should follow the pattern: userName@mailServer.TLD");
                        continue;
                    }
                }
                Contact contact = new Contact(name, type, email);
                contactsService.add(contact);
                break;
            }

        }

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

    private boolean checkEmailPattern(String email) {
        String emailPattern = ".+@.+\\.\\w{3}";
        return email.matches(emailPattern);
    }



}
