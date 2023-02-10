/*
Name: Martin Morales Arana
Student ID: 1172178
Lab 5, Q1

The program demonstrates the use of the ArrayList class by adding some names to it,
and then printing them using the ArrayList toString() method
 */
import java.util.ArrayList; // Import ArrayList

public class Morales_Martin_Lab5_Q1 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>(); // Create new ArrayList object
        // Add 5 names
        names.add("Uniqua");
        names.add("Tyrone");
        names.add("Austin");
        names.add("Pablo");
        names.add("Tasha");

        System.out.println("The list is: " + names); // Print ArrayList with toString() method
    }
}