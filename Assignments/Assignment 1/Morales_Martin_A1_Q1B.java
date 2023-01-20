/*
Name: Martin Morales Arana
Student ID: 1172178
Assignment 1, Q1.B
The program uses the FloorArea class to store the dimensions of the floor of a room.
It then uses the getArea and displayArea methods to calculate and print to the user
the dimensions of the given room. The dimensions of the room are given by the user
*/

import java.util.Scanner; // import Scanner class to read input

// FloorArea class stores length and width of a room and uses displayArea
// Method to display the area of the room object that called the method
class FloorArea{
    private double length, width; // Attributes

    // Default constructor
    public FloorArea(){
        length=1;
        width=1;
    }

    // Constructor initializing length and width
    public FloorArea(double length, double width){
        this.length = length;
        this.width = width;
    }

    // getter and setter for length
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    // getter and setter for width
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // getArea method returns the area of the floor. Private method.
    // It cannot be called by the user
    private double getArea(){
        return length*width;
    }

    // Public displayArea method uses getArea to calculate the area of the room and
    // displays the length, width and area of the room to the user.
    public void displayArea(){
        System.out.printf("The length entered was: %.2f\nThe width entered was: %.2f\nThe area of the floor of the room is %.2f square feet\n", length, width, getArea());
    }
}

public class Morales_Martin_A1_Q1B {
    public static void main(String[] args) {
        double length, width; // variables to store length and width from the user
        Scanner input = new Scanner(System.in); // instantiate new scanner

        // Ask for user input
        System.out.print("Please enter the length of the room: ");
        length = input.nextDouble();
        System.out.print("Please enter the width of the room: ");
        width = input.nextDouble();

        // create FloorArea object with measures provided by the user using constructor
        FloorArea room = new FloorArea(length, width);
        room.displayArea(); // display area using method
    }
}