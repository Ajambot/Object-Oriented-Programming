/*
Name: Martin Morales Arana
Student ID: 1172178
Assignment 1, Q1.A
The program uses the FloorArea class to store the dimensions of the floor of a room.
It then uses the getArea and displayArea methods to calculate and print to the user
the dimensions of the given room. The dimensions of the room are given (l = 15, w = 25)
*/

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
    // display it to the user.
    public void displayArea(){
        System.out.printf("The area of the floor of the room is %.2f square feet", getArea());
    }
}

public class Morales_Martin_A1_Q1A {
    public static void main(String[] args) {
        // create FloorArea object with  length=15, width=25
        FloorArea room = new FloorArea(15, 25);
        room.displayArea(); // display area using method
    }
}