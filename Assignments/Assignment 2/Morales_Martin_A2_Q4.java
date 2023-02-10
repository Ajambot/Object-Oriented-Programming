/*
Name: Martin Morales Arana
Student ID: 1172178
Assignment 2, Q4

The program tallies up a list of doubles given by command-line arguments and prints it
to the user
 */

public class Morales_Martin_A2_Q4 {
    public static void main(String[] args) {
        double sum=0; // store sum
        // Enhanced for loop to iterate through all Strings in args
        for(String val : args){
            sum+=Double.parseDouble(val); // Parse the String to double and add it to sum
        }
        System.out.printf("The sum is: %.2f", sum); // Print sum
    }
}