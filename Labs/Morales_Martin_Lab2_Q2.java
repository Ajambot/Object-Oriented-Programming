import java.util.Scanner; // import Scanner class


// Point class to store 2d coordinates
class Point{
    private double x,y; // x and y values of coordinate

    // Default constructor
    public Point(){
        x=0;
        y=0;
    }

    // Constructor with initialized x and y
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // getters for x and y coordinates
    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    // Setters for x and y coordinates
    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    // square function returns square of a number
    public double square(double x){
        return x*x;
    }

    // distance returns the distance between the point that called the method and a point passed in arguments
    public double distance(Point p2)
    {
        return Math.sqrt(square(x-p2.getX()) + square(y-p2.getY()));
    }

}
public class Morales_Martin_Lab2_Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // scanner initialization

        // Receive input from user for both points
        System.out.print("Input x coordinates for point 1: ");
        double x, y;
        x = input.nextDouble();
        System.out.print("Input y coordinates for point 1: ");
        y = input.nextDouble();
        Point p1 = new Point(x, y);
        System.out.print("Input x coordinates for point 2: ");
        x = input.nextDouble();
        System.out.print("Input y coordinates for point 2: ");
        y = input.nextDouble();
        Point p2 = new Point(x, y);

        System.out.printf("The distance between the two points is %.2f", p1.distance(p2)); // print distance of point 1 to point 2
    }
}