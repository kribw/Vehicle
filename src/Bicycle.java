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
        setColour(input.next());
        System.out.print("Price: ");
        setPrice(input.nextInt());
        System.out.print("Model: ");
        setModel(input.nextInt());
        System.out.print("Serial#: ");
        setSerialNumber(input.next());
        System.out.print("Gear: ");
        setGears(input.nextInt());
        System.out.print("Speed: ");
        setSpeed(input.nextDouble());
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public void turnRight(int degrees) {
        if(degrees > 0 && degrees < 360) {
            setDirection((getDirection() + degrees) % 360);
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

    @Override
    public String toString() {
        // Name, Colour, Serial Number, Model, Price, Direction, Gears, Speed
        return String.format("Name: %s, Colour: %s, Serial#: %s, Model: %d, Price: %d, Direction: %d, Gear: %d, Speed: %.2f", getName(), getColour(), getSerialNumber(), getModel(),getPrice(), getDirection(), getGears(), getSpeed());
    }
}