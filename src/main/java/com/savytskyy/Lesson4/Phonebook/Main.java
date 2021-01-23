package main.java.com.savytskyy.Lesson4.Phonebook;

import main.java.com.savytskyy.Lesson4.Phonebook.contacts.Contact;
import main.java.com.savytskyy.Lesson4.Phonebook.contacts.ContactsService;
import main.java.com.savytskyy.Lesson4.Phonebook.contacts.FileContactsService;
//import main.java.com.savytskyy.Lesson4.Phonebook.contacts.InMemoryContactsService;
import main.java.com.savytskyy.Lesson4.Phonebook.menu.Menu;
import main.java.com.savytskyy.Lesson4.Phonebook.menu.menuactions.*;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //ContactsService contactsService = new InMemoryContactsService(sc);
        ContactsService contactsService = new FileContactsService(sc);



//        contactsService.add(new Contact(Contact.ContactType.PHONE, "Sue", "+380671112233"));
//        contactsService.add(new Contact(Contact.ContactType.PHONE,"Tim", "+380662223344"));
//        contactsService.add(new Contact(Contact.ContactType.PHONE,"Bob", "+380952223344"));

        Menu menu = new Menu(sc, contactsService);
        menu.addAction(new ReadAllContactsMenuAction(contactsService));
        menu.addAction(new AddContactMenuAction(sc, contactsService));
        menu.addAction(new RemoveContactMenuAction(sc, contactsService));
        menu.addAction(new FindNumberPartMenuAction(sc, contactsService));
        menu.addAction(new FindNameBeginningtMenuAction(sc, contactsService));
        menu.addAction(new QuitMenuAction());
        menu.run();
    }
}


//                      ВЫЗЫВАЕТ ПРОБЛЕМЫ С КОДИРОВКОЙ!!!
//          public static void readStorageFile(ContactsService contactsService) {
//        try (InputStream is = new FileInputStream("contacts.txt")) {
//            BufferedInputStream bis = new BufferedInputStream(is);
//            Scanner scanner = new Scanner(bis);
//
//            while (scanner.hasNextLine()) {
//                //contactsService.add(new Contact(Contact.ContactType.PHONE, "Sue", "+380671112233"));
//                System.out.println(scanner.nextLine());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


