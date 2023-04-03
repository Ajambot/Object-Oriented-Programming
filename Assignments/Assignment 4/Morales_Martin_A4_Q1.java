/*
Name: Martin Morales Arana
Student ID: 1172178
Assignment 4, Q1

Implements a class Task that represents a process in a system. It has a priority attached to it.
It implements a Priority interface, which establishes getter and setter for priorities, and the comparable
interface from the java standard library
 */

/**
 * Priority interface with abstract functions to set and get priorities of an object for comparison
 */
interface Priority{
    abstract public void setPriority(int priority);
    abstract public int getPriority();
}

// Task class. Implements priority and comparable interfaces
class Task implements Priority, Comparable{
    int priority;

    /**
     * Default constructor. All default tasks are initialized with priority 1
     */
    public Task(){
        priority=1;
    }

    /**
     * Initialized constructor
     * @param priority priority of the new instantiated task
     */
    public Task(int priority){
        this.priority = priority;
    }

    // Setter and getter functions from priority interface
    @Override
    public void setPriority(int priority){
        this.priority = priority;
    }

    @Override
    public int getPriority(){
        return priority;
    }

    // compareTo method from comparable interface. Compares depending on priority
    @Override
    public int compareTo(Object o) {
        if(this.priority>((Task)o).priority) return -1;
        else if(this.priority<((Task)o).priority) return 1;
        return 0;
    }
}

public class Morales_Martin_A4_Q1 {
    public static void main(String[] args) {
        // Create 3 tasks
        Task t1 = new Task();
        Task t2 = new Task(2);
        Task t3 = new Task(3);

        // Compare tasks
        System.out.println("Comparing t1 and t2: " + printCompare("t1", "t2", t1.compareTo(t2)));
        System.out.println("Comparing t2 and t3: " + printCompare("t2", "t3", t2.compareTo(t3)));
        System.out.println("Comparing t1 and t3: " + printCompare("t1", "t3", t1.compareTo(t3)));

        t1.setPriority(10);
        System.out.println("Comparing t1 and t2: " + printCompare("t1", "t2", t1.compareTo(t2)));
        System.out.println("t1's priority is: " + t1.getPriority());

    }

    public static String printCompare(String s1, String s2, int compareKey){
        if(compareKey==-1) return s1+" has higher priority";
        if(compareKey==1) return s2+" has higher priority";
        if(compareKey==0) return "They have the same priority";
        return "Priorities passed not valid";
    }
}