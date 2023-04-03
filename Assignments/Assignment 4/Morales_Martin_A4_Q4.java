/*
Name: Martin Morales Arana
Student ID: 1172178
Assignment 4, Q4


 */

// Abstract class for all electronics
abstract class Electronics {
    protected String manufacturer;
    protected double cost;

    protected boolean on;

    // Initialized constructor. Defaults on to false
    public Electronics(String manufacturer, double cost) {
        this.manufacturer = manufacturer;
        this.cost = cost;
        on = false;
    }

    // Getter and setter for manufacturer
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    // Getter and setter for cost
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    // Toggles device on/off
    public void toggleOn(){on=!on;}

    // Abstract function toString
    abstract public String toString();
}

// enum for orientation of a device
enum Orientation{
    VERTICAL, HORIZONTAL
}

// Abstract class for portable electronics. Subclass of Electronics
abstract class PortableElectronics extends Electronics {
    protected double screenSize, weight;

    Orientation orient;

    // Initialized constructor
    public PortableElectronics(String manufacturer, double cost, double weight, double screenSize) {
        super(manufacturer, cost);
        this.weight = weight;
        this.screenSize = screenSize;
        orient = Orientation.VERTICAL;
    }

    // Getter and setter for screen size
    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    // Getter and setter for weight
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Toggle the orientation of the device
    public void toggleOrientation(){
        orient = (orient==Orientation.VERTICAL)? Orientation.HORIZONTAL : Orientation.VERTICAL;
    }

}

// Abstract class for home appliances. Subclass of electronics
abstract class HomeAppliances extends Electronics {
    protected double voltage;

    // Initialized constructor
    public HomeAppliances(String manufacturer, double cost, double voltage) {
        super(manufacturer, cost);
        this.voltage = voltage;
    }

    // Getter and setter for voltage
    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }
}

// Computer class subclass of Electronics
class Computer extends Electronics {
    private int memory;
    private String processor;

    // Initialized constructor
    public Computer(String manufacturer, double cost, int memory, String processor) {
        super(manufacturer, cost);
        this.memory = memory;
        this.processor = processor;
    }

    // Setters
    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    // Getters
    public int getMemory() {
        return memory;
    }

    public String getProcessor() {
        return processor;
    }

    // Implement toString abstract function
    @Override
    public String toString() {
        return "Manufacturer: " + manufacturer + "\nCost: $" + cost + "\nOn/Off: " + ((on)?"on":"off") + "\nMemory (GB): " + memory + "\nProcessor: " + processor + "\n";
    }
}

// Cell phone class subclass of portable electronics
class CellPhone extends PortableElectronics {
    private String phoneNumber;
    private double batteryLevel;

    // Initialized constructor
    public CellPhone(String manufacturer, double cost, double weight, double screenSize, String phoneNumber, double batteryLevel) {
        super(manufacturer, cost, weight, screenSize);
        this.phoneNumber = phoneNumber;
        this.batteryLevel = batteryLevel;
    }

    // Getters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    // Setters
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBatteryLevel(double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    // Overriden toString abstract function from electronics class
    @Override
    public String toString() {
        return "Manufacturer: " + manufacturer + "\nCost: $" + cost + "\nOn/Off: " + ((on)?"on":"off") + "\nOrientation: " + orient
                + "\nScreensize (in): " + screenSize + "\nWeight (g): " + weight + "\nPhone number: " + phoneNumber + "\nBattery Level: " + batteryLevel + "%\n";
    }
}

// Digital camera class, subclass to portable electronics
class DigitalCamera extends PortableElectronics {
    private String model;

    // Initialized constructor
    public DigitalCamera(String manufacturer, double cost, double weight, double screenSize, String model) {
        super(manufacturer, cost, weight, screenSize);
        this.model = model;
    }

    // Getter and setter for model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Takes a picture with the camera
    public void takePicture(){
        System.out.println("SNAP! Picture taken");
    }

    // Overriden toString abstract function from electronics class
    @Override
    public String toString() {
        return "Manufacturer: " + manufacturer + "\nCost: $" + cost + "\nOn/Off: " + ((on)?"on":"off") + "\nOrientation: " + orient
                + "\nScreensize (in): " + screenSize + "\nWeight (g): " + weight + "\nModel: " + model + "\n";
    }
}

// Clock class. Subclass to home appliances
class Clock extends HomeAppliances{
    private String time;

    // Initialized constructor
    public Clock(String manufacturer, double cost, double voltage, String time){
        super(manufacturer, cost, voltage);
        this.time = time;
    }

    // Getter and setter for time
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    // Function to ring at noon or midnight
    public void ring12(){
        if(time.equals("12:00:00") || time.equals("00:00:00")) System.out.println("It's 12. I mean... RING RING!");
    }

    // Overriden toString abstract function from electronics class
    @Override
    public String toString() {
        return "Manufacturer: " + manufacturer + "\nCost: $" + cost + "\nOn/Off: " + ((on)?"on":"off") + "\nVoltage (V): " + voltage
                + "\nTime (24-hour): " + time + "\n";
    }
}

public class Morales_Martin_A4_Q4{
    public static void main(String[] args){
        Computer pc = new Computer("Dell", 650.0, 8, "Intel Core i5");
        CellPhone cell = new CellPhone("Apple", 1000, 172, 6.06, "+1 (321) 423-5643", 80);
        DigitalCamera camera = new DigitalCamera("Canon", 1200, 701, 3.0, "EOS 90D");
        Clock clock = new Clock("Swiss", 215, 120, "5:23:23");

        System.out.println(pc);
        System.out.println(cell);
        System.out.println(camera);
        System.out.println(clock);
        pc.toggleOn();
        cell.toggleOn();
        cell.toggleOrientation();
        camera.toggleOn();
        camera.toggleOrientation();
        camera.takePicture();
        clock.toggleOn();
        clock.setTime("12:00:00");
        clock.ring12();
        System.out.print("\n");
        System.out.println(pc);
        System.out.println(cell);
        System.out.println(camera);
        System.out.println(clock);
    }
}
       
