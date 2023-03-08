/*
Name: Martin Morales Arana
Student ID: 1172178
Assignment 3, Q2

The program implements a predator/prey simulator that represents an environment of doodlebugs (predator) and ants (prey).
It clearly shows the concepts of polymorphism by implementing a superclass Organism with subclasses ant and predator. It also
uses a board class to store and manage the state of the simulation. It has no significant drawbacks, and it can handle large boards
(highest board size tried is 5000x5000)
 */
import java.security.SecureRandom;
import java.util.Vector;
import java.util.Scanner;

// Board class. Manages and stores the state of the game
class Board{
    private static int n, m; // Dimensions of the board
    private static Organism[][] grid; // matrix of organisms to store game state

    /**
     * Constructor that initializes the simulation state and starts the simulation
     * @param n amount of columns
     * @param m amount of rows
     * @param numAnt amount of ants at start
     * @param numDoodle amount of doodlebugs at start
     */
    public Board(int n, int m, int numAnt, int numDoodle){
        if(numAnt+numDoodle > n*m) // If there are more organisms than spaces in the grid, throw exception
            throw new IllegalArgumentException("Total number of bugs cannot exceed n*m. Try again.");

        // Create grid with specified dimensions
        Board.n = n;
        Board.m = m;
        grid = new Organism[n][m];

        Vector<Integer> emptyX = new Vector<Integer>(); // Stores the x position of all empty cells
        Vector<Integer> emptyY = new Vector<Integer>(); // Stores the y position of all empty cells
        // Add all cells as empty
        for(int i=0; i<n; i++){
            for(int o=0; o<m; o++){
                emptyX.add(i);
                emptyY.add(o);
            }
        }

        SecureRandom random = new SecureRandom(); // RNG
        // Instantiate all ants
        for(int i=0; i<numAnt; i++){
            int pos;
            pos = random.nextInt(emptyX.size()); // Pick a random position to instantiate organism
            createBug(new Ant(emptyX.get(pos), emptyY.get(pos)), emptyX.get(pos), emptyY.get(pos)); // instantiate bug at specified position
            // Remove current position from empty vectors
            emptyX.remove(pos);
            emptyY.remove(pos);
        }
        // Instantiate all doodlebugs
        for(int i=0; i<numDoodle; i++){
            int pos;
            pos = random.nextInt(emptyX.size()); // Pick a random position to instantiate organism
            createBug(new Doodlebug(emptyX.get(pos), emptyY.get(pos)), emptyX.get(pos), emptyY.get(pos)); // instantiate bug at specified position
            // Remove current position from empty vectors
            emptyX.remove(pos);
            emptyY.remove(pos);
        }
        startSim(); //  Start simulation
    }

    public void startSim(){
        System.out.println("Starting Predator-Prey simulation...\n");
        int steps=0;
        Scanner input = new Scanner(System.in);

        // Advance the simulation steps until there are no more ants or doodlebugs
        while(Ant.getAmountOfAnts()>0 && Doodlebug.getAmountOfDoodlebugs()>0){
            System.out.printf("Step %d:\n", steps);
            printBoard();
            // Print the amount of doodlebugs and ants
            System.out.printf("""
                        Amount of Ants: %d
                        Amount of Doodlebugs: %d
                        """, Ant.getAmountOfAnts(), Doodlebug.getAmountOfDoodlebugs());
            timeStep(); // Advance a time step
            steps++;
            System.out.println("Press enter to continue: ");
            input.nextLine();
        }
        // Print the final time step and final stats
        System.out.printf("Step %d:\n", steps);
        printBoard();
        System.out.printf("""
                        Simulation ended.
                        
                        Stats:
                        Time steps survived: %d
                        Final amount of Ants: %d
                        Final amount of Doodlebugs: %d
                        """, steps,
                Ant.getAmountOfAnts(), Doodlebug.getAmountOfDoodlebugs());
    }

    // Getter and setter for n
    public static int getN() {
        return n;
    }

    public static void setN(int n) {
        Board.n = n;
    }

    // Getter and setter for m
    public static int getM() {
        return m;
    }

    public static void setM(int m) {
        Board.m = m;
    }

    /**
     * Check if the organism at position (x,y) is an ant
     * @param x column position
     * @param y row position
     * @return true if the organism is an ant, false otherwise
     */
    public static boolean isAnt(int x, int y){
        return (grid[x][y] instanceof Ant);
    }

    /**
     * Checks if the position is valid and empty
     * @param x column position
     * @param y row position
     * @return true if position is valid and empty, false otherwise
     */
    public static boolean isEmpty(int x, int y){
        return (x<n && x>=0 && y<m && y>=0 && grid[x][y]==null);
    }

    /**
     * Moves the organism to position (x, y)
     * @param bug Organism to be moved
     * @param x new xPosition
     * @param y new yPosition
     */
    public static void moveBug(Organism bug, int x, int y){
        grid[bug.getX()][bug.getY()]=null;
        grid[x][y] = bug;
    }

    /**
     * Dereferences and destroys the bug at (x, y)
     * @param x x position
     * @param y y position
     */
    public static void killBug(int x, int y){
        grid[x][y]=null;
    }

    /**
     * Places the bug passed to the function at position (x, y)
     * @param bug bug to be placed
     * @param x x position
     * @param y y position
     */
    public static void createBug(Organism bug, int x, int y){
        grid[x][y] = bug;
    }

    /**
     * Prints the board at the current time step
     */
    public void printBoard(){
        for(int i=0; i<n; i++){
            for(int o=0; o<m; o++){
                // If there is a bug at (i, o) print its symbol, else print a '.' to represent an empty cell
                if(grid[i][o]!=null)
                    System.out.print(grid[i][o].getSymbol());
                else System.out.print(".");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Moves the simulation state forward by one step
    public void timeStep(){
        Vector<Organism> isMoved = new Vector<Organism>(); // Vector that contains all the organisms that have been moved

        // Move the doodlebugs first
        for(int i=0; i<n; i++) {
            for (int o = 0; o < m; o++) {
                // Check if the current organism is a doodlebug and hasn't been moved
                if (grid[i][o] instanceof Doodlebug && !isMoved.contains(grid[i][o])) {
                    isMoved.add(grid[i][o]); // add to moved vector
                    grid[i][o].move(); // move the organism
                }
            }
        }
        isMoved.clear(); // clear the contents of the vector
        // Move all the ants. Same as doodlebugs
        for(int i=0; i<n; i++){
            for(int o=0; o<m; o++){
                if(grid[i][o] instanceof Ant && !isMoved.contains(grid[i][o])){
                    isMoved.add(grid[i][o]);
                    grid[i][o].move();
                }
            }
        }
        isMoved.clear(); // clear vector
        // We check for starvation for all doodlebugs and breed all eligible organisms. We add newborn organisms to isMoved
        // vector so that we do not add a timestepsurvived at time of birth
        for(int i=0; i<n; i++){
            for(int o=0; o<m; o++){
                if (grid[i][o] instanceof Doodlebug && ((Doodlebug)grid[i][o]).starve()) continue; // Starve eligible doodlebugs
                if(grid[i][o]!=null && !isMoved.contains(grid[i][o])){ // Add a timestep and breed all non-newborn eligible organisms
                    grid[i][o].timeStepsSurvived++;
                    isMoved.add(grid[i][o].breed());
                }
            }
        }
    }
}

// Organism superclass. Declared as abstract
abstract class Organism{
    protected int x,y, timeStepsSurvived;
    protected char symbol;
    public abstract void move(); // abstract method move to be overriden in subclasses
    public abstract Organism breed(); // abstract method breed to be overriden in subclasses

    // Returns a random empty position adjacent to the organism that called it
    public Vector<Integer> randomEmptyAdjPos(){
        int[] xOffset = {1, -1, 0, 0};
        int[] yOffset = {0, 0, 1, -1};
        SecureRandom random = new SecureRandom();
        Vector<Integer> emptyX = new Vector<Integer>();
        Vector<Integer> emptyY = new Vector<Integer>();
        for(int i=0; i<4; i++){
            // If an adjacent position is empty, add it to the empty vectors
            if(Board.isEmpty(x+xOffset[i], y+yOffset[i])){
                emptyX.add(x+xOffset[i]);
                emptyY.add(y+yOffset[i]);
            }
        }
        if(emptyX.size()==0) return null; //  If there are no empty adjacent positions, return null
        Vector<Integer> newPos = new Vector<Integer>();
        // Fetch a random empty adjacent position and return it
        int ranPos = random.nextInt(emptyX.size());
        newPos.add(emptyX.get(ranPos));
        newPos.add(emptyY.get(ranPos));
        return newPos;
    }

    // Getter and setter for x position
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    // Getter and setter for y position
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Getter and setter for time steps survived
    public int getTimeStepsSurvived() {
        return timeStepsSurvived;
    }

    public void setTimeStepsSurvived(int timeStepsSurvived) {
        this.timeStepsSurvived = timeStepsSurvived;
    }

    // Getter and setter for symbol
    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}

// Ant subclass of organism
class Ant extends Organism{
    private static int amountOfAnts=0; // amount of ants currently alive
    private static final int timeToBreed=3; // Breed threshold

    // Constructor for ant
    public Ant(int x, int y) {
        this.x = x;
        this.y = y;
        timeStepsSurvived = 0;
        amountOfAnts++;
        symbol='O';
    }

    // Getter and setter for amount of ants
    public static int getAmountOfAnts() {
        return amountOfAnts;
    }

    public static void setAmountOfAnts(int amountOfAnts) {
        Ant.amountOfAnts = amountOfAnts;
    }

    /**
     * Overriden move method. Moves the and to a random adjacent position
     */
    @Override
    public void move() {
        Vector<Integer> newPos = randomEmptyAdjPos(); // Select a random empty position
        if(newPos==null) return; // If no positions are available, do not move
        Board.moveBug(this, newPos.get(0), newPos.get(1)); // Move bug to new position
        // Update bug position
        x = newPos.get(0);
        y = newPos.get(1);
    }

    /**
     * Breed overriden method. Breeds current ant if it has surpassed the breed threshold
     * @return reference to newborn child if it bred and null if it didn't
     */
    @Override
    public Organism breed() {
        Vector<Integer> breedPos = randomEmptyAdjPos(); // Find a random empty adjacent position to place child
        // If there is an adjacent position available and the current ant has surpassed the breed threshold, proceed
        if(timeStepsSurvived>=timeToBreed && breedPos!=null){
            Ant child = new Ant(breedPos.get(0), breedPos.get(1)); // Create newborn at random adjacent position
            Board.createBug(child, breedPos.get(0), breedPos.get(1)); // Place newborn in board
            timeStepsSurvived=0; // Reset time since last bred
            return child; // return newborn
        }
        return null; // If not possible to breed, return null
    }
}

// Doodlebug subclass of organism
class Doodlebug extends Organism{
    private static int amountOfDoodlebugs=0; // current amount of doodlebugs alive on board
    private static final int timeToBreed = 8, timeToDie = 3; // death and breed threshold
    private int timeSinceLastEat; // Time since doodlebug last ate an ant

    // Constructor for doodlebug
    public Doodlebug(int x, int y) {
        this.x = x;
        this.y = y;
        timeStepsSurvived = 0;
        timeSinceLastEat = 0;
        amountOfDoodlebugs++;
        symbol='X';
    }

    // Getter and setter for amount of doodlebugs
    public static int getAmountOfDoodlebugs() {
        return amountOfDoodlebugs;
    }

    public static void setAmountOfDoodlebugs(int amountOfDoodlebugs) {
        Doodlebug.amountOfDoodlebugs = amountOfDoodlebugs;
    }

    // Getter and setter for time since last eaten
    public int getTimeSinceLastEat() {
        return timeSinceLastEat;
    }

    public void setTimeSinceLastEat(int timeSinceLastEat) {
        this.timeSinceLastEat = timeSinceLastEat;
    }

    /**
     * Overriden move method to move a doodlebug
     */
    @Override
    public void move(){
        int[] xOffset = {1, -1, 0, 0};
        int[] yOffset = {0, 0, 1, -1};
        for (int i = 0; i < 4; i++) {
            // Check if the current adjacent position is valid and if there is an ant there
            if (x + xOffset[i] < Board.getN() && x + xOffset[i] >= 0 && y + yOffset[i] < Board.getM()
                    && y + yOffset[i] >= 0 && Board.isAnt(x+xOffset[i], y+yOffset[i])) {
                Board.killBug(x + xOffset[i], y + yOffset[i]); // Kill the adjacent ant
                //System.out.print("Ant destroy\n");
                Ant.setAmountOfAnts(Ant.getAmountOfAnts() - 1); // Decrease ant counter by 1
                timeSinceLastEat=0; // reset eat counter
                Board.moveBug(this, x+xOffset[i], y+yOffset[i]); // Move doodlebug to ant position
                // Update x and y position and return
                this.x = this.x+xOffset[i];
                this.y = this.y+yOffset[i];
                return;
            }
        }

        // If the doodlebug had no adjacent adds, move it as normally and update eat counter
        Vector<Integer> newPos = randomEmptyAdjPos();
        if(newPos==null) return;
        Board.moveBug(this, newPos.get(0), newPos.get(1));
        this.x = newPos.get(0);
        this.y = newPos.get(1);
        timeSinceLastEat++;
    }

    /**
     * Breed overriden method. Breeds current doodlebug if eligible
     */
    @Override
    public Organism breed() {
        Vector <Integer> breedPos = randomEmptyAdjPos(); // get a random empty adjacent position
        // If breed threshold was surpassed and there is an empty position adjacent, breed
        if(timeStepsSurvived>=timeToBreed && breedPos!=null){
            // Create newborn and reset timeSteps counter
            Doodlebug child = new Doodlebug(breedPos.get(0), breedPos.get(1));
            Board.createBug(child, breedPos.get(0), breedPos.get(1));
            timeStepsSurvived=0;
            return child;
        }
        return null; // If not eligible to breed, return null
    }

    /**
     * Starve method exclusive to doodlebugs
     * @return true if bug starved, and false otherwise
     */
    public boolean starve() {
        if(timeSinceLastEat>=timeToDie){ // If starve threshold surpassed, decrease counter and kill current bug
            amountOfDoodlebugs--;
            Board.killBug(x, y);
            return true;
        }
        return false;
    }
}

public class Morales_Martin_A3_Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Predator-Prey Simulator");
        System.out.println("Please enter the dimensions of the board: ");
        int n, m;
        n = input.nextInt();
        m = input.nextInt();
        System.out.println("Please enter the starting amount of Ants: ");
        int ant = input.nextInt();
        System.out.println("Please enter the starting amount of Doodlebugs: ");
        int doodle = input.nextInt();
        Board newGame = new Board(n, m, ant, doodle); // Initialize board and start simulation
    }
}