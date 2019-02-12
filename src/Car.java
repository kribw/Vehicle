public class Car extends Vehicle {
    private int power;

    public Car() {

    }

    public Car(String name, String colour, int price, int model, String serialNumber, int direction, int power) {
        setName(name);
        setColour(colour);
        setPrice(price);
        setModel(model);
        setSerialNumber(serialNumber);
        setDirection(direction);
        setPower(power);
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
        System.out.print("Serial#: ");
        setSerialNumber(input.next());
        System.out.println("Power: ");
        setPower(input.nextInt());
    }

    public void turnLeft(int degrees) {
        if(degrees > 0 && degrees < 360) {
            if(getDirection() - degrees < 0) {

            } else {
                setDirection(getDirection() - degrees);
            }
        }
    }

    public void turnRight(int degrees) {
        if(degrees > 0 && degrees < 360) {
            setDirection((getDirection() + degrees) % 360);
        }
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        // Name, Colour, Serial Number, Model, Price, Direction, Speed, Power
        return String.format("Name: %s, Colour: %s, Serial#: %s, Model: %d, Price: %d, Direction: %d, Speed: %.2f, Power: %d", getName(), getColour(), getSerialNumber(), getModel(),getPrice(), getDirection(), getSpeed(), getPower());
    }
}