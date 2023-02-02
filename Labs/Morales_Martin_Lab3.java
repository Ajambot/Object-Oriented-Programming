/*
Name: Martin Morales Arana
Student ID: 1172178
Lab 3, Q1

The program uses the Fan class to store 4 attributes: the speed of the fan, the color of the fan,
the radius of the fan and whether the fan is on or off. Then, we test this class by creating 2 Fan
objects and using the toString method of the Fan class to print all of their attributes. The values
of the attributes of the 2 fan objects are given
 */

// Fan class. Stores speed, radius, color and on/off
class Fan{
    private static final int SLOW=1, MEDIUM=2, FAST=3; // constants to define 3 speeds of the fan
    // Private attributes of the fan
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    // Default constructor. Initializes with default values given by problem
    public Fan() {
        speed = SLOW;
        on = false;
        radius = 5;
        color = "blue";
    }

    // Constructor which initializes all values of the Fan object with passed arguments
    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    // Getter and setter for speed
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // Getter and setter for on
    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    // Getter and setter for radius
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Getter and setter for color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // toString method prints all the attributes of the Fan object that called it
    public String toString(){
        return "Speed: " + speed +
                "\nColor: " + color +
                "\nRadius: " + radius +
                "\nFan is " + ((on)? "on" : "off") +"\n\n";
    }
}


public class Morales_Martin_Lab3 {
    public static void main(String[] args) {
        System.out.print("Sample run\n\n");
        // Create 2 fan objects initialized with values from the problem
        Fan fan1 = new Fan(3, true,10, "yellow");
        Fan fan2 = new Fan(2, false, 5, "blue");
        System.out.print(fan1.toString() + fan2.toString());// Print attributes of both fans
    }
}