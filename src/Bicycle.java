public class Bicycle extends Vehicle {
    private int gears;

    public Bicycle() {

    }

    public Bicycle(String name, String colour, int price, int model, String serialNumber, int direction, int gears) {
        setName(name);
        setColour(colour);
        setPrice(price);
        setModel(model);
        setSerialNumber(serialNumber);
        setDirection(direction);
        setGears(gears);
    }

    @Override
    public void setAllFields() {
        System.out.print("Name: ");
        setName(input.next());
        System.out.print("Colour: ");
        setColour(input.next());
        System.out.print("Price: ");
        setPrice(input.nextInt());
        System.out.print("Model: ");
        setModel(input.nextInt());
        System.out.print("Serial#: ");
        setSerialNumber(input.next());
        System.out.println("Gear: ");
        setGears(input.nextInt());
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public void turnRight(int degrees) {
        System.out.println(getDirection());
    }

    public void turnLeft(int degrees) {
        System.out.println(getDirection());
    }

    @Override
    public String toString() {
        // Name, Colour, Serial Number, Model, Price, Direction, Speed, Gears
        return String.format("Name: %s, Colour: %s, Serial#: %s, Model: %d, Price: %d, Direction: %d, Speed: %.2f, Gear: %d", getName(), getColour(), getSerialNumber(), getModel(),getPrice(), getDirection(), getSpeed(), getGears());
    }
}
