import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Bicycle extends Vehicle {
    private int gears;
    private Calendar productionDate;

    public Bicycle() {
        super();
        setProductionDate(Calendar.getInstance());
    }

    public Bicycle(String name, String colour, int price, int model, String serialNumber, int gears, double speed) {
        super(name, colour, price, model, serialNumber, 0);
        setGears(gears);
        setSpeed(speed);
        setProductionDate(Calendar.getInstance());
    }

    @Override
    public void setAllFields() {
        super.setAllFields();
        System.out.print("Gear: ");
        setGears(input.nextInt());
        System.out.print("Speed: ");
        setSpeed(input.nextDouble());
    }

    @Override
    public void readData(Scanner in) {
        super.readData(in);
        String gear = in.next();
        setGears(Integer.parseInt(gear.substring(gear.lastIndexOf(":") + 2)));
        String productionDate = in.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date date = sdf.parse(productionDate.substring(productionDate.lastIndexOf(":") + 2));
            getProductionDate().setTime(date);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void turnRight(int degrees) {
        System.out.println("Bicycle has turned " + degrees + " degrees to the right.");
    }

    public void turnLeft(int degrees) {
        System.out.println("Bicycle has turned " + degrees + " degrees to the left.");
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
        return String.format("%s, Gear: %d, Production date: %tF", super.toString(), getGears(), getProductionDate());
    }
}