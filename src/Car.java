import java.util.Calendar;

public class Car extends Vehicle {
    private int power;
    private Calendar productionDate;

    public Car() {
        setProductionDate(Calendar.getInstance());
    }

    public Car(String name, String colour, int price, int model, String serialNumber, int direction, int power) {
        super(name, colour, price, model, serialNumber, direction);
        setPower(power);
        setProductionDate(Calendar.getInstance());
    }

    @Override
    public void setAllFields() {
        super.setAllFields();
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

    @Override
    public String toString() {
        // Name, Colour, Serial Number, Model, Price, Direction, Speed, Power, Production date
        return String.format("%s, Power: %d, Production date: %tF", super.toString(), getPower(), getProductionDate());

    }
}