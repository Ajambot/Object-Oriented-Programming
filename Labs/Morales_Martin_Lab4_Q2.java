/*
Name: Martin Morales Arana
Student ID: 1172178
Lab 4, Q2
The program prints out the location of the largest element in a double array. It uses the
locateLargest method from the Location class to find the element in the given array and store
the row and column number, and the value of the largest element in the array in a Location object.
The method then returns this object. We use this method in main to print out the location of the
largest element. The array dimensions and size are given by the user.
*/
import java.util.Scanner; // Scanner class to receive input

class Location{
    private int row, col; // store row and column number of largest element
    private double maxVal; // store maximum value in array

    // Constructor with initialized values passed by argument
    public Location(int row, int col, double maxVal) {
        this.row = row;
        this.col = col;
        this.maxVal = maxVal;
    }

    // getter and setter for row
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    // getter and setter for col
    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    // getter and setter for maxVal
    public double getMaxVal() {
        return maxVal;
    }

    public void setMaxVal(double maxVal) {
        this.maxVal = maxVal;
    }

    // locateLargest method locates largest element and returns a
    // Location object with its location
    public static Location locateLargest(double[][] a){
        int x, y; // row and column number of max val
        double val = a[0][0]; // max value initialized with first value in array
        x=y=0; // index of first value

        // loop through entire array
        for(int i=0; i<a.length; i++)
        {
            for(int o=0; o<a[i].length; o++)
            {
                if(a[i][o] > val){ // if current value is bigger than max, current value is new max
                    val=a[i][o];
                    x=i;
                    y=o;
                }
            }
        }
        return new Location(x, y, val); // return Location object with correct coordinates and value
    }
}

public class Morales_Martin_Lab4_Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // new scanner to read input
        int row, col; // row and column dimensions of array

        // get row and column from user
        System.out.print("Enter the number of rows and columns of the array: ");
        row = input.nextInt();
        col = input.nextInt();

        double[][] a = new double[row][col]; // create array with specified dimensions

        // get array from user
        System.out.println("Enter the array:");

        for(int i=0; i<row; i++)
        {
            for(int o=0; o<col; o++)
            {
                a[i][o] = input.nextDouble();
            }
        }

        // print out coordinates using Location locateLargest method
        System.out.printf("The location of the largest element is at (%d,%d)", Location.locateLargest(a).getRow(), Location.locateLargest(a).getCol());
    }
}