/*
Name: Martin Morales Arana
Student ID: 1172178
Assignment 2, Q1

The program uses the Fish class to store 3 attributes: the amount of Fish in the tank, and the pet name
and kind of each specific fish. Then, we test this class by creating 3 Fish objects and using the toString,
getName(), getType(), getNumberOfFish(), and isSameType() to print all of their attributes. The values
of the attributes of the 3 Fish objects are given
 */

import java.util.Scanner; // Scanner to read input from user

// Fish classes with attributes and method described in the header
class Fish{
    private static int numberOfFish=0; // Static variable; Only one instance for all fish objects; stores amount of fish
    private String kind; // Stores the kind of fish
    private Name name; // Stores the name of the fish. Uses Name class.

    /**
     * Default constructor; Increases amount of fish by 1
     */
    public Fish() {
        numberOfFish++;
    }

    /**
     * Constructor; Initializes all values and increases amount of fish by 1
     * @param kind Kind of fish
     * @param name Pet Name of Fish
     */
    public Fish(String name, String kind) {
        this.kind = kind;
        this.name = new Name(name);
        numberOfFish++;
    }

    /**
     * Getter for NumberOfFish
     * @return Amount of fish in the tank
     */
    public static int getNumberOfFish() {
        return numberOfFish;
    }

    /**
     * Getter for Kind
     * @return Kind of Fish object that called it
     */
    public String getKind() {
        return kind;
    }

    /**
     * Setter for Kind
     * @param kind Kind of fish
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Getter for Name
     * @return Pet name of Fish object that called it
     */
    public String getName() {
        return name.petName;
    }

    /**
     * Setter for Fish
     * @param name Name of fish
     */
    public void setName(String name) {
        this.name.setPetName(name); // use method from Name class to initialize
    }

    /**
     * Checks if the Name of two fish is the same
     * @param f1 Fish 1
     * @param f2 Fish 2
     * @return True if pet name is the same, else false
     */
    public static boolean isSameType(Fish f1, Fish f2){
        return f1.getKind().equals(f2.getKind());
    }

    /**
     * Override of the toString function. Prints the information of the current fish
     * @return String containing information of current fish
     */
    @Override
    public String toString()
    {
        return name.petName + " (" + kind + ")";
    }
}

// Name class. Stores name of the fish
class Name{
    public String petName; // String to store the pet name of the fish

    /**
     * Constructor with initialized values
     * @param petName Pet name of the fish
     */
    public Name(String petName) {
        this.petName = petName;
    }

    /**
     * Getter for petName
     * @return petName of the fish that called it
     */
    public String getPetName() {
        return petName;
    }

    /**
     * Setter for petName
     * @param petName Pet name of fish
     */
    public void setPetName(String petName) {
        this.petName = petName;
    }
}
public class Morales_Martin_A2_Q1 {
    public static void main(String[] args) {
        // Create 3 Fish objects
        Fish fish1 = new Fish("Nemo Finding", "clownfish");
        Fish fish2 = new Fish("Bozo Iron", "clownfish");
        Fish fish3 = new Fish("Patrick Star", "starfish");

        // Test the toString() overridden function
        System.out.println("Test toString():");
        System.out.println(fish1.toString());

        // Test getters
        System.out.println("\nTest getName(), getType(), and getNumberOfFish():");
        System.out.printf("My name is %s; I am a %s fish\nThere are %d fish in the tank\n", fish1.getName(), fish1.getKind(), Fish.getNumberOfFish());

        // Test isSameType()
        System.out.println("\nTest isSameType():");
        System.out.printf(fish1.toString() + " and " + fish2.toString() + " are %s type(s) of fish.\n" +
                fish1.toString() + " and " + fish3.toString() + " are %s type(s) of fish\n", Fish.isSameType(fish1, fish2)? "the same" : "different", Fish.isSameType(fish1, fish3)? "the same" : "different");
        System.out.print("Press enter to continue...");
        Scanner input = new Scanner(System.in);
        input.nextLine(); // Wait for input
    }
}