import java.util.Calendar;

public class Bicycle extends Vehicle {
    private int gears;
    private Calendar productionDate;

    public Bicycle() {
        setProductionDate(Calendar.getInstance());
    }

    public Bicycle(String name, String colour, int price, int model, String serialNumber, int gears, double speed) {
        this();
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

    public Calendar getProductionDate() {
        return productionDate;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public void setProductionDate(Calendar date) {
        this.productionDate = date;
    }

    public void accelerate(int speedFactor) {
        double tempspeed = 0;

        if(getSpeed() == 0) {
            tempspeed  = (speedFactor * 0.3);
        } else {
            tempspeed = (getSpeed() * 0.5 * speedFactor);
        }

        if (tempspeed > MAX_SPEED_BIKE) {
            setSpeed(MAX_SPEED_BIKE);
        } else {
            setSpeed(tempspeed);
        }
        System.out.println("Vehicle accelerated to: " + getSpeed() + " km/h.");
    }

    public void breaks(int speedFactor) {
        setSpeed(getSpeed()/(speedFactor*0.5));
        System.out.println("Vehicle slowed down to: " + getSpeed() + " km/h.");
    }

    @Override
    public String toString() {
        // Name, Colour, Serial Number, Model, Price, Direction, Gears, Speed, Production date
        return String.format("Name: %s, Colour: %s, Serial#: %s, Model: %d, Price: %d, Direction: %d, Gear: %d, Speed: %.2f, Production date: %tF", getName(), getColour(), getSerialNumber(), getModel(),getPrice(), getDirection(), getGears(), getSpeed(), getProductionDate());
    }
}