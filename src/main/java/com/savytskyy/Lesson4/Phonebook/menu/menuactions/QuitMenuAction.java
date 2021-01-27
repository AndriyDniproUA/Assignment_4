package com.savytskyy.Lesson4.Phonebook.menu.menuactions;

import com.savytskyy.Lesson4.Phonebook.menu.menuactions.MenuAction;

public class QuitMenuAction implements MenuAction {


    public QuitMenuAction() {
    }

    @Override
    public void doAction() {
        //List<Contact> contacts = contactsService.getAll();

        //System.out.println("All your contacts will be saved in the file");


//        try (OutputStream os = new FileOutputStream("contacts.txt")) {
//            OutputStreamWriter osr = new OutputStreamWriter(os, "UTF-8");
//            BufferedWriter bw = new BufferedWriter(osr);
//            contacts.stream()
//                    .forEach(contact -> {
//                        try {
//                            bw.write((contact.getName() + '['
//                                    + contact.getType().toString().toLowerCase() + ':'
//                                    + contact.getContactInfo() + ']'+'\n'));
//                                    //.getBytes());
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        try {
//                            bw.flush();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


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
