//package com.paul;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Contacts {
//    private String name;
//    private String phoneNumber;
//    private String email;
//    private ArrayList<String> savedContact;
//
//    public Contacts(String name, String phoneNumber, String email, ArrayList<String> savedContact) {
//        this.name = name;
//        this.phoneNumber = phoneNumber;
//        this.email = email;
//        this.savedContact = savedContact;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void createContact(String name, String phoneNumber, String email) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please input your name");
//        String customerName = scanner.nextLine();
//        System.out.println("Please in put your phoneNumber");
//        String customerPhoneNumber = scanner.nextLine();
//        System.out.println("Please input your email address");
//        String customerEmail = scanner.nextLine();
//
//        savedContact.add(customerName);
//        savedContact.add(customerPhoneNumber);
//        savedContact.add(customerEmail);
//
//
//    }
//}
//
//
