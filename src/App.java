
import calculator.Calculator;
import figure.*;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Rectangle rect = new Rectangle();
        int option = Integer.parseInt(scanner.nextLine());
        if (option == 1) {
            String cont;
            do {
                System.out.print((char)27+"[0m");
                try {
                    calculator.calculate();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input "+e.getMessage());
                    System.out.println("Quitting Program . . . ");
                    break;
                }
                System.out.println("Result : " + calculator.getResult());
                calculator.outputResultHistory();
                System.out.print((char)27+"[0m");
                System.out.print((char)27+"[1mContinue (y/n)?");
                cont = scanner.nextLine();
            } while (cont.equalsIgnoreCase("y"));
        } else if (option == 2) {
            rect.setxAxis(20.0);
            System.out.println(rect.getxAxis());
        }
    }

}
