/*
MyRectangle class with attributes and methods described in main
 */
public class MyRectangle {
    private int width, height;
    private MyPoint coordinates;

    // Constructors
    public MyRectangle() {
        coordinates = new MyPoint();
        width = 1;
        height = 1;
    }

    public MyRectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public MyRectangle(MyPoint coordinates) {
        this.coordinates = coordinates;
        width = 1;
        height = 1;
    }

    public MyRectangle(int width, int height, MyPoint coordinates) {
        this.width = width;
        this.height = height;
        this.coordinates = coordinates;
    }

    /**
     * Moves rectangle to coordinates (x, y)
     * @param x x coordinate
     * @param y y coordinate
     */
    public void moveRectangle(int x, int y)
    {
        coordinates.setX(x);
        coordinates.setY(y);
    }

    /**
     *
     * @return area of rectangle
     */
    public int computeArea(){
        return width*height;
    }

    // Getters and setters
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
