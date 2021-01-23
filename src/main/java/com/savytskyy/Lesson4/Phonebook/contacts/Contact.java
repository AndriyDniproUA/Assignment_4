package main.java.com.savytskyy.Lesson4.Phonebook.contacts;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor


public class Contact {
   public enum ContactType {
        PHONE, EMAIL
    }

    private String name;
    private ContactType type;
    private String contactInfo;


//    public Contact(String name, String phone) {
//        this.name = name;
//        this.phone = phone;
//    }
//
//    public String getName(){
//        return name;
//    }
//    public String getPhone() { return phone;}
}
