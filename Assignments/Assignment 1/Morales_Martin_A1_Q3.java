/*
Name: Martin Morales Arana
Student ID: 1172178
Assignment 1, Q3
The program uses the StudentAccount class to store the credit hours and the money spent on textbooks
by a student. It then uses the displayStudentAccount method and the initialized cost constants to
calculate and display the total student fees in detail. The credit hours and the money spent on
textbooks are given by the user.
*/
import java.util.Scanner; // import scanner class to read input from user

// StudentAccount class stores important data to calculate and display the total fees of a student
class StudentAccount{
    private double creditHours, moneySpentonBooks; // attributes
    private static final double creditHourCost=85, athleticFee=65; // cost constants

    // Defalt constructor
    public StudentAccount() {
        creditHours=10;
        moneySpentonBooks=90;
    }

    // Constructor to initialize StudentAccount with all values passed in arguments
    public StudentAccount(double creditHours, double moneySpentonBooks) {
        this.creditHours = creditHours;
        this.moneySpentonBooks = moneySpentonBooks;
    }

    // getter and setter for credit hours
    public double getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(double creditHours) {
        this.creditHours = creditHours;
    }

    //getter and setter for moneySpentonBooks
    public double getMoneySpentonBooks() {
        return moneySpentonBooks;
    }

    public void setMoneySpentonBooks(double moneySpentonBooks) {
        this.moneySpentonBooks = moneySpentonBooks;
    }

    // Method to display a detailed Student Account of the object that called it
    public void displayStudentAccount()
    {
        System.out.printf("\n%25s%20s\n", "Fee Detail", "Amount");
        System.out.printf("%19s (%.1f)%20.2f\n", "Credit Hours", creditHours, creditHours*creditHourCost);
        System.out.printf("%25s%20.2f\n", "Textbooks", moneySpentonBooks);
        System.out.printf("%25s%20.2f\n", "Athletics Fee", athleticFee);
        System.out.printf("%45s\n", "-------");
        System.out.printf("%s%40.2f\n", "Total", creditHours*creditHourCost+moneySpentonBooks+athleticFee);
    }
}

public class Morales_Martin_A1_Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // instantiate scanner to read input from user
        double creditHours, textbooks;
        // Get input from user
        System.out.print("Input the total amount of credit hours: ");
        creditHours = input.nextDouble();
        System.out.print("Input the total amount spent on textbooks: ");
        textbooks = input.nextDouble();
        // Create StudentAccount object initialized with user values
        StudentAccount student1 = new StudentAccount(creditHours, textbooks);
        student1.displayStudentAccount(); // display student 1 Account
    }
}