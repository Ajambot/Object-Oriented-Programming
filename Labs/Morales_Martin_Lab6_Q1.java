/*
Name: Martin Morales Arana
Student ID: 1172178
Lab 6, Q1

The program uses the MyPoint and MyRectangle class to represent a rectangle in a 2d plane. The MyRectangle class
has an aggregation relation with the MyPoint class, and also attributes for width and height, contructors, getters and setters,
and builtin functions MoveRectangle and computeArea. The MyPoint has x and y values for the origin point of the rectangle.
In main, we create a rectangle with origin in (10,20), width 100, and height 200. Then we print the area, and move the rectangle
to point (30,40). Finally, we print the x and y values of the rectangle translated.
 */

public class Morales_Martin_Lab6_Q1{
    public static void main (String[] args )
    {
        MyPoint originOne = new MyPoint (10,20);
        MyRectangle rectOne = new MyRectangle(100, 200, originOne);
        System.out.println ("The rectangle area is " + rectOne.computeArea());
        rectOne.moveRectangle(30,40);
        System.out.println ("The rectangle moved to a new point, new X value is "
                + originOne.getX() + " and new Y value is " + originOne.getY());
    }
}