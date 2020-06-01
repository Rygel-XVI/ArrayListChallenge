package com.udemymasterclass;

public class Contact {
    private String phoneNumber;
    private String name;

    public Contact() {
        this(".", ".");
    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void updateContact(String phoneNumber, String name) {
        setPhoneNumber(phoneNumber);
        setName(name);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

}
