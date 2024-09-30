
import calculator.Calculator;
import figure.*;
import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int option = 4;
        switch (option) {
            case 1 -> {
                String cont;
                do {
                    System.out.print((char) 27 + "[0m");
                    try {
                        calculator.calculate();
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input " + e.getMessage());
                        System.out.println("Quitting Program . . . ");
                        break;
                    }
                    System.out.println("Result : " + calculator.getResult());
                    calculator.outputResultHistory();
                    System.out.print((char) 27 + "[0m");
                    System.out.print((char) 27 + "[1mContinue (y/n)?");
                    cont = scanner.nextLine();
                } while (cont.equalsIgnoreCase("y"));
            }
            case 2 -> {
                Rectangle rect = new Rectangle(4.0,2.0);
                System.out.println(rect.calculateCircumference());
            }
            case 3 -> {
                Parking parkSystem = new Parking();
                parkSystem.printTariff();
            }
            case 4 -> {
                ShipmentDate shp = new ShipmentDate();
                shp.calculateEstimatedDateReceived();
            }
            case 5 -> {
                ConvertHourFormat chf = new ConvertHourFormat();
                chf.convertFormat("11:30 PM");
            }
            default -> {
            }
        }
        

    }

}
