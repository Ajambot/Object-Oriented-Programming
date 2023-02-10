/*
Name: Martin Morales Arana
Student ID: 1172178
Lab 5, Q2

The program implement the Complex class, which contains a real and imaginary
floating part. It also has its respective constructor, accesors and mutators,
and add, subtract and print methods. We test the class by creating 2 Complex
objects and adding them and subtracting them together.
 */

// Complex class with attributes and methods described above
class Complex{
    private double real, imaginary; // real and imaginary parts of the complex number

    /**
     * Constructor initializing both parts of the complex number
     * @param real Real part of the Complex number
     * @param imaginary Imaginary part of the complex number
     */
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Getter for real part
     * @return Real part of the Complex number that called it
     */
    public double getReal() {
        return real;
    }

    /**
     * Setter for real part of the number
     * @param real Real part of the number
     */
    public void setReal(double real) {
        this.real = real;
    }

    /**
     * Getter for Imaginary part
     * @return Imaginary part of the number that called it
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * Setter for Imaginary
     * @param imaginary Imaginary part of the number
     */
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    /**
     * Add the current Complex number to c
     * @param c Complex number passed to method
     */
    public void add(Complex c){
        real += c.real;
        imaginary += c.imaginary;
    }

    /**
     * Subtract the current Complex number from c
     * @param c Complex number passed to method
     */
    public void subtract(Complex c){
        real -= c.real;
        imaginary -= c.imaginary;
    }

    /**
     * Prints the Complex number
     */
    public void print(){
        System.out.printf("The complex number has values (%.2f, %.2f)\n", real, imaginary);
    }
}

public class Morales_Martin_Lab5_Q2 {
    public static void main(String[] args) {
        Complex c1 = new Complex (2.0, 5.0); // 2.0 + 5.0i
        Complex c2 = new Complex (-3.1, -6.3); // -3.1 - 6.3i
        c1.add (c2); // c1 is now -1.1 - 1.3
        c1.print ();
        c2.subtract(c1); // c2 is now -2.0, -5.0
        c2.print ();
    }
}