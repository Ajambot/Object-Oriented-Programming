/*
Name: Martin Morales Arana
Student ID: 1172178
Assignment 3, Q1

The program shows the concept of inheritance by implementing a superclass Document with subclasses Email and File
that represent their respective file formats. All of them have a text field and a toString method. Specialized subclasses
include other data fields like sender, recipient and pathname. In the main program, we create four Documents and check if the files,
we print the Documents and we check if they contain specific keywords.
 */
/**
 * Superclass to Email and File. Defines a protected (to inherit) text field, a setter and a toString method
 */
class Document{
    protected String text;

    public void setText(String text) {
        this.text = text;
    }

    public String toString(){
        return "Text: \"" + text + "\"";
    }
}

/**
 * Subclass to Document. Defines additional String attributes sender, recipient, and title.
 * Has constructor, accessors, and mutators. Overrides toString to concatenate all new attributes as well
 */
class Email extends Document{
    private String sender, recipient, title; //  attributes

    /**
     * Constructor with all values initialized
     * @param sender sender of the email
     * @param recipient recipient of the email
     * @param title title of the email
     * @param body body of the email
     */
    public Email(String sender, String recipient, String title, String body) {
        this.sender = sender;
        this.recipient = recipient;
        this.title = title;
        text = body;
    }

    // Getters and setters for Sender
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    // Getters and setters for Recipient
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    // Getters and setters for Title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getters and setters for Body
    public String getBody(){
        return text;
    }

    public void setBody(String body){
        text = body;
    }

    /**
     * Redefined toString method that initializes all values
     * @return String with values of all instance variables
     */
    @Override
    public String toString(){
        return "Sender: " + sender + "\nRecipient: " + recipient
                + "\nTitle: " + title + "\nBody: " + text;
    }
}

/**
 * Subclass to Document. Defines additional String attribute pathname, which contains pathname of the text file.
 * Has constructor, accessors, and mutators. Overrides toString to concatenate all new attributes as well
 */
class File extends Document{
   private String pathname; // pathname of file

    /**
     * Constructor with all values initialized
     * @param pathname pathname of the text file
     * @param text text inside the file
     */
    public File(String pathname, String text) {
        this.pathname = pathname;
        this.text = text;
    }

    // Getter and setter for pathName
    public String getPathname() {
        return pathname;
    }

    public void setPathname(String pathname) {
        this.pathname = pathname;
    }

    // Getter and setter for text
    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    /**
     * Redefined toString method that initializes all values
     * @return String with values of all instance variables
     */
    @Override
    public String toString() {
        return "Pathname: " + pathname + "\nText: " + text;
    }
}

public class Morales_Martin_A3_Q1 {
    public static void main(String[] args) {

        // Create 2 Email objects and 2 File objects
        Email email1 = new Email("Pablo", "Tasha", "Backyardigans party",
                "Are you coming to the party?");
        Email reply = new Email("Tasha", "Pablo", "Re: Backyardigans party",
                "Ofc. Cu there");

        File file1 = new File("C:/user/Austin/superSecretBackyardiganStuff/IntoTheThickofIt.txt",
                "We're tramping through the bush.\n" +
                        "On and on we push. Into the thick of it,\n" +
                        "But we can't see where we're going.\n" +
                        "We've made a stellar start.");

        File file2 = new File("C:/user/Uniqua/CutePuppies/NoCutePuppiesHereLol.txt",
                "I'll go anywhere around the globe and sneak in undetected\n" +
                        "There's one thing you can expect from me, and that's the unexpected\n" +
                        "'Cause I'm an international Super Spy!\n" +
                        "Super Spy!");

        // I didn't include Tyrone because he sucks

        // Check if the 4 objects contain certain keywords
        System.out.printf("Email1 " + ((ContainsKeyword(email1, "Castaways"))? "contains" : "does not contain") +
                " the keyword \"Castaways\"\n");
        System.out.printf("Reply " + ((ContainsKeyword(reply, "Ofc"))? "contains" : "does not contain") +
                " the keyword \"Ofc\"\n");
        System.out.printf("File1 " + ((ContainsKeyword(file1, "Into the thick of it"))? "contains" : "does not contain") +
                " the keyword \"Into the thick of it\"\n");
        System.out.printf("File2 " + ((ContainsKeyword(file2, "Tyrone"))? "contains" : "does not contain") +
                " the keyword \"Tyrone\"\n");
    }

    /**
     * Subroutine that checks if the text field in a Document subclass has a certain keyword
     * @param docObject Document subclass object
     * @param keyword keyword to be found in text field
     * @return true if keyword is in docObject, else false
     */
    public static boolean ContainsKeyword(Document docObject, String keyword)
    {
        if (docObject.toString().indexOf(keyword,0) >= 0)
            return true;
        return false;
    }
}