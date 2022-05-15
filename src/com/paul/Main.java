package com.paul;

import com.paul.phone_registry.ConsoleInterface;
import com.paul.phone_registry.ConsoleInterfaceImpl;
import com.paul.phone_registry.PhoneBook;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = PhoneBook.getPhoneBook();
        ConsoleInterface consoleInterface = new ConsoleInterfaceImpl(phoneBook);
        consoleInterface.startApplication();
    }
}
