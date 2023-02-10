/*
Name: Martin Morales Arana
Student ID: 1172178
Assignment 2, Q3.A

The program uses the Inventory class to store 2 attributes: the description and amount of units of
an item in inventory. Then, we test this class by creating an array of 4 Inventory objects and using the
getItemsInfo method of the Inventory class to read the information of 4 items from the user and print
all of their attributes.
 */

import java.util.Scanner; // Scanner to read input from user

// Inventory class; has methods and attributes described above
class Inventory{
    private String description; // description of item
    private int unit; // How many units left of item

    /**
     * Default constructor; Leaves all values as default
     */
    public Inventory() {
    }

    /**
     * Constructor that initializes just the description
     * @param description Description of item
     */
    public Inventory(String description) {
        this.description = description;
    }

    /**
     * Constructor that initializes all values of the object
     * @param description Description of item
     * @param unit Amount of units left of item
     */
    public Inventory(String description, int unit) {
        this.description = description;
        this.unit = unit;
    }

    /**
     * Getter for description
     * @return Description of item that called it
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description
     * @param description description of item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for unit
     * @return Units remaining of item that called it
     */
    public int getUnit() {
        return unit;
    }

    /**
     * Setter for unit
     * @param unit Units left of item
     */
    public void setUnit(int unit) {
        this.unit = unit;
    }

    /**
     * Initializes Inventory array passed by reference with user input and then prints it
     * @param inventory Array of Inventory objects.
     */
    public static void getItemsInfo(Inventory[] inventory){
        // Get item info for every item in array
        for(int i=0; i< inventory.length; i++){
            String description;
            int units;
            Scanner input = new Scanner(System.in); // Scanner to read user input
            // Read description and units
            System.out.printf("Enter the description for item %d: ", i+1);
            description = input.nextLine();
            System.out.printf("Enter the amount of units for item %d: ", i+1);
            units = input.nextInt();
            inventory[i] = new Inventory(description, units); // Create new object in array with values given
        }
        // Print all items in inventory
        int i=1; // Index of items
        System.out.println("\nPrinting list of items...");
        // Use enhanced for loop to print all items in array
        for(Inventory item : inventory)
        {
            System.out.printf("%d. Description: %s, Units: %s\n", i, item.getDescription(), item.getUnit());
            i++;
        }
        System.out.println("End of List");
    }
}
public class Morales_Martin_A2_Q3A {
    public static void main(String[] args) {
        Inventory[] inventory = new Inventory[4]; // Create Inventory array of size 4
        Inventory.getItemsInfo(inventory); // Initialize array and print it
    }
}