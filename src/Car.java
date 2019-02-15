import java.util.Calendar;

public class Car extends Vehicle {
    private int power;
    private Calendar productionDate;

    public Car() {
        setProductionDate(Calendar.getInstance());
    }

    public Car(String name, String colour, int price, int model, String serialNumber, int direction, int power) {
        this();
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
        // Name, colour, price, model, serialnumber, power
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
        System.out.print("Power: ");
        setPower(input.nextInt());
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

    public int getPower() {
        return power;
    }

    public Calendar getProductionDate() {
        return productionDate;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setProductionDate(Calendar date) {
        this.productionDate = date;
    }

    public void accelerate(int speedFactor) {
        double tempspeed = 0;

        if(getSpeed() == 0) {
            tempspeed = (speedFactor * 0.5);
        } else {
            tempspeed = (speedFactor * getSpeed());
        }

        if(tempspeed > MAX_SPEED_CAR) {
            setSpeed(MAX_SPEED_CAR);
        } else {
            setSpeed(tempspeed);
        }
        System.out.println("Vehicle accelerated to: " + getSpeed() + " km/h.");
    }

    public void breaks(int speedFactor) {
        setSpeed(getSpeed() / speedFactor);
        System.out.println("Vehicle slowed down to: " + getSpeed() + " km/h.");
    }

    @Override
    public String toString() {
        // Name, Colour, Serial Number, Model, Price, Direction, Speed, Power, Production date
        //return String.format("Name: %s, Colour: %s, Serial#: %s, Model: %d, Price: %d, Direction: %d, Speed: %.2f, Power: %d, Production date: %tF", getName(), getColour(), getSerialNumber(), getModel(),getPrice(), getDirection(), getSpeed(), getPower(), getProductionDate());
        return String.format("%s, Power: %d, Production date: %tF", super.toString(), getPower(), getProductionDate());

    }
}