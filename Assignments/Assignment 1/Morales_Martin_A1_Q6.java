/*
Name: Martin Morales Arana
Student ID: 1172178
Assignment 1, Q6
The program uses the EspTest class to test the users extrasensory perception by making them guess
colors. Every time the user makes a guess, it checks if the guess was right and tallies the right
guesses, and then reveals what the correct color was. Finally, the program displays the amount of
correct and incorrect guesses to the user.
*/
import java.util.Scanner; // Import Scanner class to ask for user input

// EspTest tests the user on extrasensory perception by making them guess from a list of colors
class EspTest{
   private static final String[] colors = {"Red", "Green", "Blue", "Orange", "Yellow"}; // constant string array with list of colors
   private static final int min = 0, max = 4; // Min and Max indexes of array
   private int correctGuesses; // Stores the correct guesses during the EspTest

    // Default constructor. No initializing constructor since we don't want user to set their correct guesses
    public EspTest() {
        correctGuesses=0;
    }

    // Getter for correctGuesses (no setter because of reason previously explained)
    public double getCorrectGuesses() {
        return correctGuesses;
    }

    // Method generates a random color from the list
    public String generateRandomColor(){
        /*
            Math.random generates a double in the range [0.0, 1.0). We multiply this number
            by the range of the array index + 1 (since we are flooring the value, we do +1
            since we want equal odds for all indexes) The number we get will be the offset
            of our index. Then we will add this offset to the minimum index to obtain a random
            index and return the color located at this index. We typecast to int since Math.random
            and Math.floor return a double.
         */
        return colors[(int)Math.floor(Math.random()*(max-min+1)+min)];
    }

    // Method gets user's 10 guesses and calculates the correct guesses
    private void askInput(){
        Scanner input = new Scanner(System.in); // instantiate scanner to get user input
        // For loop to ask for input 10 times
        for(int i=0; i<10; i++)
        {
            String color = generateRandomColor(); // get a random color using class method
            // get user input
            System.out.print("Guess a color from the list (Red, Green, Blue, Orange, Yellow): ");
            if(color.equalsIgnoreCase(input.nextLine())) correctGuesses++; // If user guess = color add 1 to correct guesses
            System.out.printf("The correct color was %s\n", color); // Print out the correct color
        }
        input.close(); // close Scanner
    }

    // Prints out correct and incorrect guesses
    private void displayGuesses(){
        System.out.printf("You had %d correct guesses and %d incorrect guesses\n", correctGuesses, 10-correctGuesses);
    }

    // Starts the esp test
    public void startTest(){
        System.out.println("Initiating extrasensory perception test...");
        askInput(); // ask user guesses and record correct guesses
        displayGuesses(); // display amount of correct/incorrect guesses
        System.out.println("Test finalized. Thank you!");
    }
}

public class Morales_Martin_A1_Q6 {
    public static void main(String[] args) {
        EspTest test1 = new EspTest(); // instantiate esp test
        test1.startTest(); // start test
    }
}