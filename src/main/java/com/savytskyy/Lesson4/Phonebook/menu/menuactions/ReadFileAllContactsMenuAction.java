package main.java.com.savytskyy.Lesson4.Phonebook.menu.menuactions;

import main.java.com.savytskyy.Lesson4.Phonebook.contacts.Contact;
import main.java.com.savytskyy.Lesson4.Phonebook.contacts.ContactsService;

import java.util.List;

public class ReadFileAllContactsMenuAction implements MenuAction {
    ContactsService contactsService;

    public ReadFileAllContactsMenuAction(ContactsService contactsService) {
        this.contactsService = contactsService;
    }









    @Override
    public void doAction() {
        List<Contact> contacts = contactsService.getAll();

        if (contacts.size() > 0) {
            System.out.println("These are all contacts stored in the memory");
            contacts.stream()
                    .forEach(contact ->System.out.printf( "%s, %s, %s\n", contact.getType(), contact.getName(), contact.getContactInfo()));
        } else {
            System.out.println("Sorry, contact list is empty");
            System.out.println();
        }
        System.out.println("-----------------------------------------");
    }

        @Override
        public String getName () {
            return "Read all contacts";
        }

        @Override
        public boolean closeAfter () {
            return false;
        }
    }
