/*
Name: Martin Morales Arana
Student ID: 1172178
Lab 8, Q1

The program demonstrates the concepts of inheritance, aggregation and polymorphism by having 4 classes.
Film superclass which contains info of a general movie, Family and Children subclasses which are specialized
classes of the film class, and Renting class, which contains a film object and represents a movie rental by a
user. The program prints the information of all rented movies, including late fees, and prints the total outstanding
fees for the rental service.
 */

// Film superclass
class Film{
    private String rating, title;
    private int idNumber;

    // Default constructor
    public Film() {
    }

    // Initialized constructor
    public Film(String rating, String title, int idNumber) {
        this.rating = rating;
        this.title = title;
        this.idNumber = idNumber;
    }

    // Getters and Setters
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    // equals method overriden from Object class
    public boolean equals(Film film2){
        return (film2.idNumber==idNumber);
    }

    // Calculate Late Fee for a general film
    public double calculateLF(double days){
        return 2.0*days;
    }
}

class Family extends Film{
    // Initialized constructor
    public Family(String rating, String title, int id){
        super(rating, title, id);
    }

    // Calculates late fee for Family film
    public double calculateLF(double days){
        return 3.0*days;
    }
}

class Children extends Film{
    // Initialized constructor
    public Children(String rating, String title, int id){
        super(rating, title, id);
    }

    // Calculates late fee
    public double calculateLF(double days){
        return 2.5*days;
    }
}

// Renting class
class Renting{
    Film rented; // aggregation/compositon
    int customerId, lateCount;

    // Initialized constructor
    public Renting(Film rented, int customerId, int lateCount) {
        this.rented = rented;
        this.customerId = customerId;
        this.lateCount = lateCount;
    }

    // Getters and setters
    public void setRented(Film rented) {
        this.rented = rented;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getLateCount() {
        return lateCount;
    }

    public void setLateCount(int lateCount) {
        this.lateCount = lateCount;
    }

    // Calculates the rental late fee (polymorphism)
    public double rentLateFee(){
        return rented.calculateLF(lateCount);
    }

    // Prints the info of the movie
    public String movieInfo(){
        return "Title: " + rented.getTitle() + "\nRating: " + rented.getRating() + "\nMovie ID: " + rented.getIdNumber();
    }
}

public class Morales_Martin_Lab8_Q1 {
    public static void main(String[] args) {
        // Create 6 Renting objects in array
        Renting[] renters = new Renting[6];
        renters[0] = new Renting(new Family("PG-14", "Kung Fu Panda (mature version)", 1234), 1172178, 3);
        renters[1] = new Renting(new Family("PG-14", "Toy Story (mature version)", 2345), 9876522, 2);
        renters[2] = new Renting(new Children("Rated G", "Die Hard (kids version)", 3456), 3527354, 0);
        renters[3] = new Renting(new Children("Rated G", "Rambo (kids version)", 4567), 1273289, 10);
        renters[4] = new Renting(new Film("R", "My Little Pony (Gore)", 5678), 1203212, 7);
        renters[5] = new Renting(new Film("R", "Backyardigans the Movie (with Sylvester Stallone and Bruce Willis)", 7890), 9823423, 4);

        // Print the info of all rented movies and add fees
        double totalFees=0;
        for(Renting rent : renters){
            System.out.println("Renter with ID " + rent.getCustomerId() + " rented the following movie " + rent.getLateCount() + " days ago:\n" + rent.movieInfo());
            System.out.println("The late fee for this user is: " + rent.rentLateFee() + "\n");
            totalFees+=rent.rentLateFee();
        }
        // Print total fees
        System.out.print("The total outstanding fees for this rental service are: " + totalFees);
    }
}