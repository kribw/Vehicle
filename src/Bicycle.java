import static java.lang.Math.abs;

public class Bicycle extends Vehicle {
    private int gears;

    public Bicycle() {

    }

    public Bicycle(String name, String colour, int price, int model, String serialNumber, int gears, double speed) {
        setName(name);
        setColour(colour);
        setPrice(price);
        setModel(model);
        setSerialNumber(serialNumber);
        setGears(gears);
        setSpeed(speed);
    }

    @Override
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
        System.out.print("Gear: ");
        setGears(input.nextInt());
        System.out.print("Speed: ");
        setSpeed(input.nextDouble());
    }

    public void turnRight(int degrees) {
        if(degrees > 0 && degrees < 360) {
            setDirection((getDirection() + degrees) % 350);
        }
    }

    public void turnLeft(int degrees) {
        if(degrees > 0 && degrees < 360) {
            if(getDirection() - degrees < 0) {
                setDirection(getDirection() - degrees + 360);
            } else {
                setDirection(getDirection() - degrees);
            }
        }
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    @Override
    public String toString() {
        // Name, Colour, Serial Number, Model, Price, Direction, Gears, Speed
        return String.format("Name: %s, Colour: %s, Serial#: %s, Model: %d, Price: %d, Direction: %d, Gear: %d, Speed: %.2f", getName(), getColour(), getSerialNumber(), getModel(),getPrice(), getDirection(), getGears(), getSpeed());
    }
}