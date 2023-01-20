/*
Name: Martin Morales Arana
Student ID: 1172178
Assignment 1, Q5
The program uses the TicketNumber class to store a plane ticket number and check if it is valid or
not with the method instructed in the problem. The plane ticket number is given by the user.
*/
import java.util.Scanner; // import Scanner class to read input from user

// TicketNumber class stores a ticket number and checks if it's valid
class TicketNumber{
    private int num; // attribute. stores ticket number

    // Default constructor for TicketNumber class
    public TicketNumber() {
        num = 123454;
    }

    // Constructor with initialized values passed by argument
    public TicketNumber(int num) {
        this.num = num;
    }

    // Getter and setter for num
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    // Method checks if plane ticket number is valid
    public boolean isValid(){
        int lastDigit = num%10; // extract the last digit
        int newNum = num/10; // new number without the last digit
        // if remainder of new number divided by 7 = the last digit,
        // else ticket is not valid
        return (newNum % 7 == lastDigit);
    }

    // Method displays the validity of the ticket number of the object that called it to the user
    public void displayValidity(){
        System.out.printf("The plane ticket number provided is %s", isValid()? "valid\n" : "invalid\n");
    }

}

public class Morales_Martin_A1_Q5 {
    public static void main(String[] args) {
        int number; // stores plane ticket number
        Scanner input = new Scanner(System.in); // instantiate Scanner to read input from user
        // Ask for user input
        System.out.print("Enter a plane ticket number: ");
        number = input.nextInt();

        TicketNumber ticket1 = new TicketNumber(number); // instantiate TicketNumber class with user input
        ticket1.displayValidity(); // display the validity of the number provided
    }
}