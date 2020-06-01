package com.udemymasterclass;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    private ArrayList<Contact> contacts;

    public MobilePhone() {
        this(new ArrayList<Contact>());
    }

    public MobilePhone(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public void userInterface() {
        Scanner sc = new Scanner(System.in);
        boolean exitProgram = false;
        System.out.println("Choose an option: ");
        System.out.println("1: Find Contact");
        System.out.println("2: Update Contact");
        System.out.println("3: Add Contact");
        System.out.println("4: Delete Contact");
        System.out.println("5: List Contacts");
        System.out.println("6: Exit");
        int input = sc.nextInt();
        switch (input) {
            case 1:
                System.out.println("Enter contact name");
                getContactInfo(sc.next());
                break;
            case 2:
                System.out.println("Enter contact name");
                updateContact(sc.next());
                break;
            case 3:
                System.out.println("Enter contact name");
                String name = sc.next();
                addContact(name);
                break;
            case 4:
                System.out.println("Enter contact name");
                deleteContact(sc.next());
                break;
            case 5:
                System.out.println("Listing Contacts");
                listContacts();
                break;
            case 6:
                System.out.println("Exiting...");
                exitProgram = true;
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
        if (!exitProgram) { userInterface(); }
    }

    private void addContact(String name) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: " + name);
        Contact contact = findContact(name);
        if (contact.getName().equals(".")) {
            System.out.println("Enter phone number");
            String phoneNumber = sc.next();
            contacts.add(new Contact(name, phoneNumber));
            System.out.println(name + " added");
        } else {
            System.out.println(name + " already exists");
        }
    }

    private void updateContact(String name) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: " + name);
        Contact contact = findContact(name);
        if (contact.getName().equals(".")) {
            System.out.println("Contact with name " + name + " does not exist");
        } else {
            System.out.println("Name: " + contact.getName() + " Number: " + contact.getPhoneNumber());
            System.out.println("Enter new phone number");
            String newNumber = sc.next();
            System.out.println("Enter new name");
            String newName = sc.next();
            contact.updateContact(newNumber, newName);
            System.out.println("Updated contact " + name + ": to " + newName + " with number " + newNumber);
        }
    }

    private void deleteContact(String name) {
        Contact contact = findContact(name);
        if (contact.getName() != ".") { contacts.remove(contact); }
        System.out.println(name + " deleted");
    }

    private Contact findContact(String name) {
        int len = contacts.size();
        for (int i = 0; i < len; i++) {
            Contact contact = contacts.get(i);
            if (contact.getName().equals(name)) { return contact; }
        }
        System.out.println("No Contact found");
        return new Contact();
    }

    private void listContacts() {
        int len = contacts.size();
        if (len == 0) {
            System.out.println("No Contacts in phone");
        } else {
            for (int i = 0; i < len; i++) {
                Contact contact = contacts.get(i);
                System.out.println("Name: " + contact.getName() + " Number: " + contact.getPhoneNumber());
            }
        }
    }

    public void getContactInfo(String name) {
        Contact contact = findContact(name);
        System.out.println("Name: " + contact.getName() + " Number: " + contact.getPhoneNumber());
    }

}

// Create a program that implements a simple mobile phone with the following capabilities.
// Able to store, modify, remove and query contact names.
// Create a master class (MobilePhone) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
// When adding or updating be sure to check if the contact already exists (use name)
// Be sure not to expose the inner workings of the Arraylist to MobilePhone
// e.g. no ints, no .get(i) etc
// MobilePhone should do everything with Contact objects only.