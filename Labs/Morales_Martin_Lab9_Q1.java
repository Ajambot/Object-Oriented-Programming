/*
Name: Martin Morales Arana
Student ID: 1172178
Lab 9, Q1

This program implements a square class from an abstract drawable shape class. The square class has topLeft (in the assignment it said center,
but in this program these numbers represent the top left corner position of the square), length and color properties,and a draw and moveShape method.
It also has appropriate constructors, getters and setters. The program assumes that all input is valid and that operations made to the topLeft of the
square will maintain it as a positive number.
 */

abstract class DrawableShape{
    protected int[] topLeft = new int[2]; // coordinates of top left corner
    protected String color;

    // Getter & Setter for topLeft
    public int[] gettopLeft() {
        return topLeft;
    }

    public void settopLeft(int[] topLeft) {
        this.topLeft = topLeft;
    }

    // Getter & Setter for color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Move a shape by an offset
     * @param xOffset amount to offset xAxis by
     * @param yOffset amount to offSet yAxis by
     */
    public void moveShape(int xOffset, int yOffset){
        topLeft[0]+=xOffset;
        topLeft[1]+=yOffset;
    }

    // Abstract method to draw a shape
    public abstract void draw();
}

class Square extends DrawableShape{
    private int length;

    // Default constructor
    public Square() {
        this.length = 5;
        topLeft[0]=0;
        topLeft[1]=0;
        this.color="red";
    }

    // Initialized constructor
    public Square(int centerX, int centerY, int length, String color) {
        this.length = length;
        topLeft[0]=centerX;
        topLeft[1]=centerY;
        this.color=color;
    }

    // Getter & Setter for length
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Define draw method implementation from abstract class
    public void draw(){
        for(int i=0; i<topLeft[0]; i++) System.out.println(); // Y Offset
        for(int i=0; i<length; i++){
            // X Offset
            for(int o=0; o<topLeft[1]; o++){
                System.out.print(" ");
            }
            // Print square
            for(int o=0; o<length; o++){
                if(o==0 || o==length-1 || i==0 || i==length-1) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println(); // Next Line
        }
        // Print properties
        System.out.println("The square's color is " + color + ", it's top-left corner is at ("
                + topLeft[0] + ", " + topLeft[1] + "), and the length is " + length);
    }

}

public class Morales_Martin_Lab9_Q1 {
    public static void main(String[] args) {
        Square sq = new Square();
        sq.draw();
        Square sq2 = new Square(5, 5, 3, "blue");
        sq2.draw();
        sq.moveShape(2,3);
        sq.draw();
    }
}