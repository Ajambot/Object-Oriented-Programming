/*
Name: Martin Morales Arana
Student ID: 1172178
Assignment 1, Q2.B
The program uses the TimeWorked class to store the minutes worked by an employee.
It then uses the getTimeHours, getTimeMinutes and displayTimeinHours methods to
calculate and display the time worked in hours given the minutes. The minutes
worked by the employee are given by the user.
*/

import java.util.Scanner; // import Scanner class to get input from user

// Time worked class stores time worked by an employee in minutes and uses
// getTimeHours, getTimeMinutes and displayTimeinHours to calculate and display
// the time worked in hours
class TimeWorked{
    private double minutes; // minutes attribute
    private static final double HOUR = 60; // constant. Stores amount of minutes in an hour

    // Default constructor
    public TimeWorked() {
        minutes = 60;
    }

    // Constructor initializing minutes
    public TimeWorked(double minutes) {
        this.minutes = minutes;
    }

    // Getter and setter functions for minutes
    public double getMinutes() {
        return minutes;
    }

    public void setMinutes(double minutes) {
        this.minutes = minutes;
    }

    // Calculates the hours worked in hour time format
    private int getTimeHours(){
        return (int)(minutes/HOUR);
    }

    // Calculates the minutes worked in hour time format
    private double getTimeMinutes(){
        return minutes%HOUR;
    }

    // Displays the time worked in hours
    public void displayTimeinHours(){
        System.out.printf("The employee worked %d hours and %.2f minutes\n", getTimeHours(), getTimeMinutes());
    }
}

public class Morales_Martin_A1_Q2B {
    public static void main(String[] args) {
        double minutes; // variable to store minutes worked given by user
        // Get minutes from user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the amount of hours worked by the employee: ");
        minutes = input.nextDouble();
        // instantiate employee1 object and initialize with constructor using minutes constant
        TimeWorked employee1 = new TimeWorked(minutes);
        employee1.displayTimeinHours(); // display time worked in hours using method
    }
}