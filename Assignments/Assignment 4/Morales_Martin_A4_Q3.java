/*
Name: Martin Morales Arana
Student ID: 1172178
Assignment 4, Q3

Implements elective and major courses classes that are subclasses of an abstract course class
*/

// Abstract course class that represents a university course
abstract class Course{
    String courseTitle, description, department;
    int courseID;

    // Default constructor
    public Course(){
    }

    // Initialized constructor
    public Course(String courseTitle, String description, String department, int courseID) {
        this.courseTitle = courseTitle;
        this.description = description;
        this.department = department;
        this.courseID = courseID;
    }

    abstract public String toString();

    // Getter and sttter for course title
    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    // Getter and setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and setter for department
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Geter and setter for CourseID
    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}

// Represents major course. Subclass of course
class majorCourse extends Course{
    String instructor;
    String[] preReqs;
    double credits;

    // Initialized constructor for majorCourse. Initializes inherited attributes with superclass constructor
    public majorCourse(String courseTitle, String description, String department, int courseID, String instructor, double credits, String ... preReqs) {
        super(courseTitle, description, department, courseID);
        this.instructor = instructor;
        this.credits = credits;
        this.preReqs = preReqs;
    }

    // Getter and setter for instructor
    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    // Geter and setter for prereqs
    public String[] getPreReqs() {
        return preReqs;
    }

    public void setPreReqs(String ... preReqs) {
        this.preReqs = preReqs;
    }

    // Getter and setter for credit
    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    // Implements abstract toString method from superclass
    public String toString(){
        return courseTitle + "\n" + description + "\n" + department + "\n" + courseID + "\n" + instructor + "\n" + credits + " credits\n\n";
    }
}

// Represents an elective course. Subclass of course
class electiveCourse extends Course{
    String term;
    int length;

    // Initialized constructor for majorCourse. Initializes inherited attributes with superclass constructor
    public electiveCourse(String courseTitle, String description, String department, int courseID, String term, int length) {
        super(courseTitle, description, department, courseID);
        this.term = term;
        this.length = length;
    }

    // Getter and setter for term
    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    // Getter and setter for course length
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Implement inherited abstract toString method
    public String toString(){
        return courseTitle + "\n" + description + "\n" + department + "\n" + courseID + "\n" + term + "\n" + length + " months\n\n";
    }
}
public class Morales_Martin_A4_Q3 {
    public static void main(String[] args) {
        electiveCourse el = new electiveCourse("Intro to Pop Culture", "Fun course!", "English", 2010, "Fall", 4);
        majorCourse mj = new majorCourse("OOP", "Object Oriented Programming with Java", "CompSci", 2477, "Jinan Fiaidhi", 0.5);
        System.out.print(el.toString() + mj.toString());
    }
}