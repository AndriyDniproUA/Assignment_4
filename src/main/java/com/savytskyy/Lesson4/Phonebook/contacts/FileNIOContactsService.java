package com.savytskyy.Lesson4.Phonebook.contacts;

import com.savytskyy.Lesson4.Phonebook.contacts.ContactsService;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileNIOContactsService implements ContactsService {
    Scanner sc;
    //ContactsList contactsList = new ContactsList();

    public FileNIOContactsService(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public List<Contact> getAll() {
        List<Contact> contacts = new ArrayList<>();

        try (FileChannel channel = (FileChannel) Files.newByteChannel(Path.of("contacts.txt"), StandardOpenOption.READ, StandardOpenOption.TRUNCATE_EXISTING)) {
            ByteBuffer buffer = ByteBuffer.allocate(10);
            String entry = "";

            while (true) {
                int size = channel.read(buffer);
                if (size == -1) break;

                buffer.flip();
                String substring = new String(buffer.array(), 0, buffer.limit(), "UTF-8");
                buffer.clear();

                for (int i = 0; i < substring.length(); i++) {
                    if (substring.charAt(i) != '\n') {
                        entry += substring.charAt(i);
                    } else {
                        String[] contactData = entry.split("[\\[,:,\\]]");
                        String name = contactData[0];
                        Contact.ContactType type = Contact.ContactType.valueOf(contactData[1].toUpperCase());
                        String contactInfo = contactData[2];

                        contacts.add(new Contact(name, type, contactInfo));
                        entry = "";
                    }
                }
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

        try (FileChannel channel = (FileChannel) Files.newByteChannel(Path.of("contacts.txt"),
                StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
            ByteBuffer buffer = ByteBuffer.allocate(50);

            for (Contact c : contacts) {
                String contactEntry =
                        ((c.getName() + '['
                                + c.getType().toString().toLowerCase() + ':'
                                + c.getContactInfo() + ']' + '\n'));

                buffer.clear();
                buffer.put(contactEntry.getBytes(Charset.forName("UTF-8")));
                buffer.limit(buffer.position());
                buffer.position(0);
                channel.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Contact c) {
        try (FileChannel channel = (FileChannel) Files.newByteChannel(Path.of("contacts.txt"),
                StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {
            ByteBuffer buffer = ByteBuffer.allocate(50);

            String contactEntry =
                    ((c.getName() + '['
                            + c.getType().toString().toLowerCase() + ':'
                            + c.getContactInfo() + ']' + '\n'));

            buffer.clear();
            buffer.put(contactEntry.getBytes(Charset.forName("UTF-8")));
            buffer.limit(buffer.position());
            buffer.position(0);
            channel.write(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
