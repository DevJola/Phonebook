package com.paul.phone_registry;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ConsoleInterfaceImpl implements ConsoleInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private final PhoneBook phoneBook;
    private static boolean connected = true;

    public ConsoleInterfaceImpl(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }


    @Override
   public void startApplication(){
        System.out.println("====== Phone Book ======");
        while (connected) {
            displayMenu();
            int selection = Integer.parseInt(scanner.nextLine());
            if (selection < 0 || selection > 5){
                System.err.println("Please enter a valid value!");
                continue;
            }
                switch (selection) {
                    case 1 -> saveContact();
                    case 2 -> editContact();
                    case 3 -> searchContact();
                    case 4 -> deleteContact();
                    case 5 -> printAllContact();
                    case 0 -> displayMenu();
            }
            quitter();
        }
   }

    private void saveContact() {
        String firstName, lastName, email, phone;

        System.out.println("Please enter first name: ");
        firstName = scanner.nextLine();
        System.out.println("Please enter last name: ");
        lastName = scanner.nextLine();
        System.out.println("Please enter email: ");
        email = scanner.nextLine();
        System.out.println("Please enter phone number: ");
        phone = scanner.nextLine();


        Contact contact = new Contact(firstName, lastName, phone, email);
        phoneBook.addContact(contact);
        System.out.println("Contact saved!");
    }


    private void editContact() {
        String firstName, lastName, email, phone;

        System.out.println("== EDIT CONTACT ==");
        System.out.println("Enter name/phone number of contact you want to edit!");
        String field = scanner.nextLine();
        Optional<Contact> contactOptional = phoneBook.findContact(field);

        if (contactOptional.isPresent()){
            System.out.println("Enter value to be changed or leave empty to maintain state");

            System.out.println("Please enter first name: ");
            firstName = scanner.nextLine();
            System.out.println("Please enter last name: ");
            lastName = scanner.nextLine();
            System.out.println("Please enter email: ");
            email = scanner.nextLine();
            System.out.println("Please enter phone number: ");
            phone = scanner.nextLine();

            Contact contact = contactOptional.get();
            if (firstName != null) contact.setFirstName(firstName);
            if (lastName != null) contact.setLastName(lastName);
            if (email != null) contact.setEmail(email);
            if (phone != null) contact.setFirstName(phone);

            System.out.println("Contact edited!");
        } else {
            System.err.println("The field " + field + " doesn't exist in phone book!");
        }
    }

    private void deleteContact() {
        System.out.println("=== Delete Contact ===");
        System.out.println("Enter name or phone number of contact you want to delete!");
        String field = scanner.nextLine();
        Optional<Contact> contactOptional = phoneBook.findContact(field);

        if (contactOptional.isPresent()){
            phoneBook.deleteContact(contactOptional.get());
        } else {
            System.out.println("Contact with field " + field + " doesn't exist!");
        }
    }

    private void printAllContact() {
        Optional<List<Contact>> contactListOptional = phoneBook.getAllContacts();
        if (contactListOptional.isPresent()){
            for (var contact : contactListOptional.get()){
                System.out.println(contact);
            }
        } else {
            System.err.println("PhoneBook is empty");
        }
    }

    private void searchContact() {
        System.out.println("=== Search Contact ===");
        System.out.println("Enter name or phone number of contact you want to find!");
        String field = scanner.nextLine();
        Optional<Contact> contactOptional = phoneBook.findContact(field);

        if (contactOptional.isPresent()){
            System.out.println(contactOptional.get());
        } else {
            System.out.println("Contact with field " + field + " doesn't exist!");
        }
    }

    private void displayMenu(){
        System.out.println("\n Select an option:");
        System.out.println( "1 - add new contact\n" +
                "2 - edit contact\n" +
                "3 - search contact\n" +
                "4 - delete contact\n" +
                "5 - show all contacts\n" +
                "6 - open options menu\n");
        System.out.println("\n Enter your selection");
    }

    private void quitter(){
        System.out.println("Wanna quit?! \n Press Q to quit or 0 to go back to menu!");
        while(true){
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("Q")) {
                System.out.println("Goodbye!");
                connected = false;
                break;
            } else if (!response.equals("0")) {
                System.err.println("You entered an incorrect value, try again!");
            }
        }
    }
}
