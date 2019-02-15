import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public abstract class Vehicle implements Cloneable, Driveable, Fileable, Comparable<Vehicle> {

    private String colour, name, serialNumber;
    private int model, price, direction;
    private double speed;
    private Calendar buyingDate;

    protected Scanner input = new Scanner(System.in).useLocale(Locale.US);

    public Vehicle() {
        setBuyingDate(Calendar.getInstance());
    }

    public Vehicle(String name, String colour, int price, int model, String serialNumber, int direction) {
        this();
        setName(name);
        setColour(colour);
        setPrice(price);
        setModel(model);
        setSerialNumber(serialNumber);
        setDirection(direction);
    }

    public void setAllFields() {
        System.out.print("Name: ");
        setName(input.nextLine());
        System.out.print("Colour: ");
        setColour(input.nextLine());
        System.out.print("Price: ");
        setPrice(input.nextInt());
        System.out.print("Model: ");
        setModel(input.nextInt());
        input.nextLine(); // "flushes" line before nextline
        System.out.print("Serial#: ");
        setSerialNumber(input.nextLine());
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

    public Calendar getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(Calendar buyingDate) {
        this.buyingDate = buyingDate;
    }

    public void stop() {
        setSpeed(0);
        System.out.println("Vehicle stops.");
    }

    public int compareTo(Vehicle other) {
        if (this.getPrice() > other.getPrice()) {
            return 1;
        }
        else if (this.getPrice() < other.getPrice()) {
            return -1;
        }
        else {
            return 0;
        }
    }

    public void writeData(PrintWriter out) throws IOException {
        out.write(getClass().getName());
        out.write(", ");
        out.write(toString());
        System.out.println("Vehicle written to file: " + toString());
    }

    public void readData(Scanner in) {
        String name = in.next();
        setName(name.substring(name.lastIndexOf(":") + 2));
        String colour = in.next();
        setColour(colour.substring(colour.lastIndexOf(":") + 2));
        String serial = in.next();
        setSerialNumber(serial.substring(serial.lastIndexOf(":") + 2));
        String model = in.next();
        setModel(Integer.parseInt(model.substring(model.lastIndexOf(":") + 2)));
        String price = in.next();
        setPrice(Integer.parseInt(price.substring(price.lastIndexOf(":") + 2)));
        String direction = in.next();
        setDirection(Integer.parseInt(direction.substring(direction.lastIndexOf(":") + 2)));
        String speed = in.next();
        setSpeed(Double.valueOf(speed.substring(speed.lastIndexOf(":") + 2)));
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        // Name, Colour, Serial Number, Model, Price, Direction, Speed
        return String.format("Name: %s, Colour: %s, Serial#: %s, Model: %d, Price: %d, Direction: %d, Speed: %.2f", getName(), getColour(), getSerialNumber(), getModel(), getPrice(), getDirection(), getSpeed());
    }
}