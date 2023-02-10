/*
Name: Martin Morales Arana
Student ID: 1172178
Assignment 2, Q3.A

The program uses the Inventory class to store 2 attributes: the description and amount of units of
an item in inventory. Then, we test this class by creating 3 Inventory objects and getting the total
amount of items in 1 object, 2 objects and 3 objects of the class with the toUnit() method. Values for
the 3 objects are given.
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

    /**
     * Counts total amount of units in inventoryList
     * @param inventoryList Variable number arguments list of Inventory objects
     * @return Total amount of units in inventoryList
     */
    public static int toUnits(Inventory... inventoryList){
        int sum=0;
        for(Inventory item : inventoryList) sum+=item.getUnit();
        return sum;
    }
}
public class Morales_Martin_A2_Q3B {
    public static void main(String[] args) {
        // Create 3 Inventory objects
        Inventory item1 = new Inventory("Sofa", 10);
        Inventory item2 = new Inventory("Chair", 20);
        Inventory item3 = new Inventory("Lamp", 30);

        // Print out total amount of items in item 1, items 1 and 2, and items 1, 2, and 3
        System.out.printf("There are %d units of item 1\nThere are %d units of items 1 and 2\n" +
                "There are %d units of items 1, 2, and 3\n", Inventory.toUnits(item1),
                Inventory.toUnits(item1, item2), Inventory.toUnits(item1, item2, item3));

    }
}