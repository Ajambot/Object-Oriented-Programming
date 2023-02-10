/*
Name: Martin Morales Arana
Student ID: 1172178
Assignment 2, Q2

The program uses the PhoneBook class to store 2 attributes: the name and phone number of a person.
We test this class by creating 5 PhoneBook objects that we store in a Java ArrayList and then we
print the information of all 5 "contacts" using the accessors of the class. The values of the 5
objects are given.
 */

import java.util.ArrayList; // Import ArrayList to store set of PhoneBooks

// PhoneBook class; Stores information previously mentioned
class PhoneBook{
    private String name, phoneNumber; // name and phone number of contact

    /**
     * Constructor for the class with initialized values
     * @param name Name of contact
     * @param phoneNumber Phone number of contact
     */
    public PhoneBook(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter for name
     * @return Name of contact that called it
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name Name of contact
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for phoneNumber
     * @return Phone number of contact that called it
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter for phoneNumber
     * @param phoneNumber Phone number for contact
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

public class Morales_Martin_A2_Q2 {
    public static void main(String[] args) {
        ArrayList<PhoneBook> contacts = new ArrayList<PhoneBook>(); // Create a PhoneBook ArrayList
        // Instantiate 5 contacts and add them to ArrayList
        contacts.add(new PhoneBook("Austin", "8073281234"));
        contacts.add(new PhoneBook("Tasha", "1234567890"));
        contacts.add(new PhoneBook("Pablo", "0987654321"));
        contacts.add(new PhoneBook("Tyrone", "0192837465"));
        contacts.add(new PhoneBook("Uniqua", "9283746501"));

        // Print list of contacts using an enhanced for loop
        System.out.println("Printing list of contacts...");
        for(PhoneBook list : contacts){
            System.out.printf("Name: %s, Phone Number: %s\n", list.getName(), list.getPhoneNumber());
        }
    }
}