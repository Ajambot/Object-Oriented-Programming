/*
Name: Martin Morales Arana
Student ID: 1172178
Assignment 1, Q4
The program uses the PaintingProject class to store the area that needs to be painted
in feet and the cost of a gallon of paint. It then displays the details of the project,
including the amount and cost of gallons and hours of labour needed. The area and the
cost of a gallon of paint are given by the user.
*/
import java.util.Scanner; // import scanner class

// Class to store info about project and calculate the required resources
class PaintingProject{
    private double wallSpace, paintPrice; // attributes to store area needed to be painted and cost per gallon of paint
    private static final double laborCost = 20, feetSpace = 115, laborPerFeetSpace=8; // constants

    // Default constructor
    public PaintingProject() {
        wallSpace=115;
        paintPrice = 30;
    }

    // Constructor with initialized values passed by argument
    public PaintingProject(double wallSpace, double paintPrice) {
        this.wallSpace = wallSpace;
        this.paintPrice = paintPrice;
    }

    // Getter and setter for Wall Space
    public double getWallSpace() {
        return wallSpace;
    }

    public void setWallSpace(double wallSpace) {
        this.wallSpace = wallSpace;
    }

    // Getter and setter for paintPrice
    public double getPaintPrice() {
        return paintPrice;
    }

    public void setPaintPrice(double paintPrice) {
        this.paintPrice = paintPrice;
    }

    // Calculates and displays resources needed for project
    public void displayProjectInfo(){
        double gallons, labor, paintCost, laborCost, total; // variables to store calculations
        // Calculations for amount and cost of gallons and labor
        gallons = wallSpace/feetSpace;
        labor = wallSpace/feetSpace*laborPerFeetSpace;
        paintCost = gallons*paintPrice;
        laborCost = PaintingProject.laborCost*labor;
        total = paintCost+laborCost;
        // Display resources needed to the user.
        // (IntelliJ recommended me to use Java block quotes, that's how
        //  I learned this feature existed)
        System.out.printf("""
                The project requires the following resources:
                - %.1f gallons of paint
                - %.1f hours of labour
                - $%.2f dollars in paint
                - $%.2f dollars in labour
                - Total cost: $%.2f""", gallons, labor, paintCost, laborCost, total);
    }
}

public class Morales_Martin_A1_Q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // instantiate new scanner to read input from user
        double wallSpace, paintPrice; // store area to be painted and price per gallon

        // Ask for input from user
        System.out.print("Please input the total area to be painted in square feet: ");
        wallSpace = input.nextDouble();
        System.out.print("Please input the cost of a gallon of paint: ");
        paintPrice = input.nextDouble();

        // Instantiate new PaintingProject object with attributes initialized by user
        PaintingProject project1 = new PaintingProject(wallSpace, paintPrice);
        project1.displayProjectInfo(); // use method to display resources needed for the project
    }
}