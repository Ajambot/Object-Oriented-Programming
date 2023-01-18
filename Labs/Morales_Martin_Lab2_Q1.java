/*
Name: Martin Morales Arana
Student ID: 1172178
Lab 2, Q1

The program calculates the area of a donut given the radius of an inner and outer circle.
The program inputs these values from the user and then uses the Donut class to store and calculate
the area.
 */
import java.util.Scanner; // Scanner Library

// Donut Class
class Donut{
    private double innerRadius, outerRadius; // inner and outer radius

    // Default constructor
    public Donut(){
        innerRadius=1;
        outerRadius=2;
    }

    // Constructor with inner and outer initialization
    public Donut(double inner, double outer){
        innerRadius=inner;
        outerRadius=outer;
    }

    // getter functions for inner and outer radius
    public double getInner() {
        return innerRadius;
    }
    public double getOuter() {
        return outerRadius;
    }

    // setter functions for inner and outer radius
    public void setInner(double innerRadius){
        this.innerRadius=innerRadius;
    }

    public void setOuter(double outerRadius){
        this.outerRadius=outerRadius;
    }

    // returns the area of a circle given a radius
    private double areaCircle(double radius){
        return Math.PI * Math.pow(radius, 2);
    }

    // returns the area of the Donut object that called this method
    public double getDonutArea()
    {
        return areaCircle(outerRadius) - areaCircle(innerRadius);
    }

}

public class Morales_Martin_Lab2_Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // instantiate scanner

        // Input from user
        System.out.print("Enter the radius of the outer circle: ");
        double innerRadius, outerRadius;
        outerRadius = input.nextDouble();
        System.out.print("Enter the radius of the inner circle: ");
        innerRadius = input.nextDouble();

        Donut donut = new Donut(innerRadius, outerRadius); // Create Donut object and initialize with user values
        System.out.printf("The area of the donut is: %.2f", donut.getDonutArea()); // Print the area of the donut accurate to 2 decimal spaces
    }
}