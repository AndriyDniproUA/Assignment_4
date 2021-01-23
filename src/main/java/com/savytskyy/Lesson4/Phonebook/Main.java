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
        readStorageFile(contactsService);


//        contactsService.add(new Contact(Contact.ContactType.PHONE, "Sue", "+380671112233"));
//        contactsService.add(new Contact(Contact.ContactType.PHONE,"Tim", "+380662223344"));
//        contactsService.add(new Contact(Contact.ContactType.PHONE,"Bob", "+380952223344"));

        Menu menu = new Menu(sc, contactsService);
        menu.addAction(new ReadAllContactsMenuAction(contactsService));
        menu.addAction(new AddContactMenuAction(sc, contactsService));
        menu.addAction(new RemoveContactMenuAction(sc, contactsService));
        menu.addAction(new FindNumberPartMenuAction(sc, contactsService));
        menu.addAction(new FindNameBeginningtMenuAction(sc, contactsService));
        menu.addAction(new QuitMenuAction(contactsService));
        menu.run();
    }


    public static void readStorageFile(ContactsService contactsService) {
        try (InputStream is = new FileInputStream("contacts.txt")) {
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            //Pattern pattern = Pattern.compile("([А-Яа-яA-Za-z]+)\\[(\\w+):(\\+?\\w+@?\\w+.\\w{3})");

            String sub;
            while ((sub = br.readLine()) != null) {
                //System.out.println(sub);
                String[] contactData = sub.split("[\\[,:,\\]]");

                String name = contactData[0];
                Contact.ContactType type =  Contact.ContactType.valueOf(contactData[1].toUpperCase());
                String contactInfo = contactData[2];

//                Matcher matcher = pattern.matcher(sub);
//
//                if (matcher.find()) {
//                    String name = matcher.group(1);
//                    String type = matcher.group(2);
//                    String contactInfo = matcher.group(3);
//
                    contactsService.add(new Contact(name,type, contactInfo));
//                }
            }
        } catch( IOException e)

        {
            e.printStackTrace();
        }
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


