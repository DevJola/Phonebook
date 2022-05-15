package com.paul.phone_registry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PhoneBook {
    private static PhoneBook instance;
    private final static List<Contact> contactList = new ArrayList<>();

    private PhoneBook(){}

    public static PhoneBook getPhoneBook(){
       if (instance == null) instance = new PhoneBook();
       return instance;
    }

    public void addContact(Contact contact){
        contactList.add(contact);
    }

    public void deleteContact(Contact contact){
        contactList.remove(contact);
    }

    public Optional<Contact> findContact(String field){

        for (Contact contact : contactList){
            String firstName = contact.getFirstName();
            String lastName = contact.getLastName();
            String phone = contact.getPhone();

            if (firstName.equals(field) || lastName.equals(field) || phone.contains(field)){
                return Optional.of(contact);
            }
        }

        return Optional.empty();
    }


    public Optional<List<Contact>> getAllContacts() {
        return contactList.size() > 0 ? Optional.of(contactList) : Optional.empty();
    }
}
