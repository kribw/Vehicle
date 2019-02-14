/**
 * TestVehicles oppretter Bicycle og Car objekter, legger disse i et ArrayList
 * Lar bruker manipulere data i arrayet på forskjellige måter
 */

import java.util.*;
import java.io.*;

public class VehicleTest {
  public static void main(String[] args) {
    VehicleTest vtest = new VehicleTest();
    try {
      vtest.menuLoop();
    } catch(IOException e) {
      System.out.println("IO Exception!");
      System.exit(1);
    } catch(CloneNotSupportedException e) {
      System.out.println("CloneNotSupportedException");
      System.exit(2);
    }
  }

  private void menuLoop() throws IOException, CloneNotSupportedException {
    Scanner scan = new Scanner(System.in);
    ArrayList<Vehicle> arr = new ArrayList<Vehicle>();
    Vehicle vehicle;

    arr.add(new Car("Volvo","Black",85000,2010,"1010-11",163,0));
    arr.add(new Bicycle("Diamant","yellow",4000,1993,"BC100",10,0));
    arr.add(new Car("Ferrari Testarossa","red",1200000,1996,"A112",350,0));
    arr.add(new Bicycle("DBS","pink",5000,1994,"42",10,0));

    while(true) {
      System.out.println("1...................................New car");
      System.out.println("2...............................New bicycle");
      System.out.println("3......................Find vehicle by name");
      System.out.println("4..............Show data about all vehicles");
      System.out.println("5.......Change direction of a given vehicle");
      System.out.println("6.........................Test clone method");
      System.out.println("7..............................Exit program");
      System.out.print(".............................Your choice? ");
      int choice = scan.nextInt();
      System.out.println();

      switch (choice) {
        case 1:
          //legg til en ny bil
          vehicle = new Car();
          vehicle.setAllFields();
          arr.add(vehicle);
          break;

        case 2:
          //legg til en ny sykkel
          vehicle = new Bicycle();
          vehicle.setAllFields();
          arr.add(vehicle);
          break;

        case 3:
          //vis info om gitt kjøretøy
          System.out.print("Name of vehicle: ");
          scan.nextLine(); // flush scanner
          String search =  scan.nextLine();

          for(Vehicle loop : arr) {
            if(loop.getName().toLowerCase().contains(search.toLowerCase())) {
              System.out.println(loop);
            }
          }
          break;

        case 4:
          //vis info om alle kjøretøy
          for(Vehicle loop : arr) {
            System.out.println(loop);
          }
          System.out.println();
          break;

        case 5:
          // Finn kjøretøy med gitt navn, sett ny retning
          System.out.print("Name of vehicle: ");
          scan.nextLine(); // flush scanner
          String search2 =  scan.nextLine();

          for(Vehicle loop : arr) {
            if(loop.getName().toLowerCase().contains(search2.toLowerCase())) {
              System.out.print("Direction [R/L]: ");
              String direction = scan.next();
              System.out.print("Degrees [0-360]: ");
              int degrees = scan.nextInt();
              if(direction.toLowerCase().equals("r")){
                loop.turnRight(degrees);
              } else if(direction.toLowerCase().equals("l")) {
                loop.turnLeft(degrees);
              }
            }
          }
          break;

        case 6:
          //clone and change date
          Vehicle testCar = new Car("Test car", "Blue", 52000, 2011, "123-456", 0, 200);
          Vehicle clonedCar = (Vehicle)testCar.clone();
          clonedCar.setBuyingDate((Calendar)testCar.getBuyingDate().clone());

          Calendar newDate = Calendar.getInstance();
          newDate.set(1990,3,22);
          testCar.setBuyingDate(newDate);

          if(testCar.getBuyingDate() != clonedCar.getBuyingDate()) {
            System.out.println("Date objects are separate, deep copy successful.");
          } else {
            System.out.println("Date objects are not separate. Deep copy may have failed.");
          }

          System.out.printf("%tF\n", testCar.getBuyingDate());
          System.out.printf("%tF\n", clonedCar.getBuyingDate());
          break;

        case 7:
          scan.close();
          System.exit(0);

        default:
          System.out.println("Wrong input!");
      }
    }
  }
}