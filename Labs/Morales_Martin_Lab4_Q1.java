/*
Name: Martin Morales Arana
Student ID: 1172178
Lab 4, Q1
The program creates an array with dimensions given by command-line arguments and then it fills the
array with random integers from 1 to 10 and displays it.
*/

import java.security.SecureRandom; // random number generator

public class Morales_Martin_Lab4_Q1 {
    public static void main(String[] args) {
        int size=10; // default size in case there are no command-line arguments
        if(args.length!=0) size = Integer.parseInt(args[0]); // If there is at least 1 argument, read the 1st argument, parse it to an int and overwrite value of size variable
        int[] numArray = new int[size]; // create new array of size "size"

        SecureRandom randomNumbers = new SecureRandom(); // random number generator
        // Loops "size" times
        for(int i=0; i<size; i++){
            numArray[i] = 1+randomNumbers.nextInt(10); // Fills value i in the numArray with a random integer from 1 to 10
        }

        for(int x : numArray) System.out.printf("%d ", x); // Enhanced for loop prints every value in the array
    }
}