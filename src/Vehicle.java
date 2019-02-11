import java.util.Scanner;

public abstract class Vehicle {
    private String colour, name, serialNumber;
    private int model, price, direction;
    private double speed;
    protected Scanner input;

    public Vehicle() {
        setColour("Red");
        setName("Lada");
        setSerialNumber("12-345");
        setModel(1980);
        setPrice(2000);
        setDirection(0);
    }

    public Vehicle(String colour, String name, String serialNumber, int model, int price, int direction) {
        setColour(colour);
        setName(name);
        setSerialNumber(serialNumber);
        setModel(model);
        setPrice(price);
        setDirection(direction);
    }

    public void setAllFields(Scanner input) {
        setColour(input.next());
        setName(input.next());
        setSerialNumber(input.next());
        setModel(input.nextInt());
        setPrice(input.nextInt());
    }

    public abstract void turnLeft(int degrees);
    public abstract void turnRight(int degrees);

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        // Name, Colour, Serial Number, Model, Price, Direction, Speed
        return String.format("Name: %s, Colour: %s, Serial#: %s, Model: %d, Price: %d, Direction: %d, Speed: %.2f", getName(), getColour(), getSerialNumber(), getModel(),getPrice(), getDirection(), getSpeed());
    }

}
