package main.java.com.savytskyy.Lesson4.Phonebook.menu.menuactions;

import main.java.com.savytskyy.Lesson4.Phonebook.contacts.Contact;
import main.java.com.savytskyy.Lesson4.Phonebook.contacts.ContactsService;
import main.java.com.savytskyy.Lesson4.Phonebook.menu.menuactions.MenuAction;

import java.io.*;
import java.util.List;

public class QuitMenuAction implements MenuAction {
    ContactsService contactsService;

    public QuitMenuAction(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @Override
    public void doAction() {
        List<Contact> contacts = contactsService.getAll();
        System.out.println("All your contacts will be saved in the file");


        try (OutputStream os = new FileOutputStream("contacts.txt")) {
            OutputStreamWriter osr = new OutputStreamWriter(os, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osr);

            //(OutputStream os = new BufferedOutputStream(new FileOutputStream("contacts.txt")))

            contacts.stream()
                    .forEach(contact -> {
                        try {
                            bw.write((contact.getName() + '['
                                    + contact.getType().toString().toLowerCase() + ':'
                                    + contact.getContactInfo() + ']'+'\n'));
                                    //.getBytes());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            bw.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Good Bye!");
        System.out.println("Thank you for using our service!");
    }

    @Override
    public String getName() {
        return "Quit menu";
    }

    @Override
    public boolean closeAfter() {
        return true;
    }
}
