import java.util.Calendar;
import java.util.Scanner;

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
        super.setAllFields();
        System.out.print("Power: ");
        setPower(input.nextInt());
    }

    @Override
    public void readData(Scanner in) {
        super.readData(in);
        String power = in.next();
        setPower(Integer.parseInt(power.substring(power.lastIndexOf(":") + 2)));
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
        return String.format("%s, Power: %d, Production date: %tF", super.toString(), getPower(), getProductionDate());
    }
}