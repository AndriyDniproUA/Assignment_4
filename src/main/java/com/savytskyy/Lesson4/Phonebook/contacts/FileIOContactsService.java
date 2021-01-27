package com.savytskyy.Lesson4.Phonebook.contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIOContactsService implements ContactsService {
    Scanner sc;
    //ContactsList contactsList = new ContactsList();

    public FileIOContactsService(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public List<Contact> getAll() {
        List<Contact> contacts = new ArrayList<>();

        try (InputStream is = new FileInputStream("contacts.txt")) {
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String sub;
            while ((sub = br.readLine()) != null) {
                //System.out.println(sub);
                String[] contactData = sub.split("[\\[,:,\\]]");

                String name = contactData[0];
                Contact.ContactType type = Contact.ContactType.valueOf(contactData[1].toUpperCase());
                String contactInfo = contactData[2];

                contacts.add(new Contact(name, type, contactInfo));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;

    }

    @Override
    public void remove(int index) {
        List<Contact> contacts = this.getAll();
        contacts.remove(index);

        try (OutputStream os = new FileOutputStream("contacts.txt")) {
            OutputStreamWriter osr = new OutputStreamWriter(os, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osr);

            for (Contact c : contacts) {
                bw.write((c.getName() + '['
                        + c.getType().toString().toLowerCase() + ':'
                        + c.getContactInfo() + ']' + '\n'));
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Contact c) {
        try (OutputStream os = new FileOutputStream("contacts.txt", true)) {
            OutputStreamWriter osr = new OutputStreamWriter(os, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osr);

            bw.write((c.getName() + '['
                    + c.getType().toString().toLowerCase() + ':'
                    + c.getContactInfo() + ']' + '\n'));
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
