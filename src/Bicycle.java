import java.util.Calendar;

public class Bicycle extends Vehicle {
    private int gears;
    private Calendar productionDate;

    public Bicycle() {
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

    @Override
    public String toString() {
        // Name, Colour, Serial Number, Model, Price, Direction, Gears, Speed, Production date
        return String.format("%s, Gear: %d, Production date: %tF", super.toString(), getGears(), getProductionDate());
    }
}