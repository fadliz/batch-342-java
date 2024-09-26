
import calculator.Calculator;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String cont;
        do {
            System.out.print((char)27+"[0m");
            calculator.calculate();
            System.out.println("Result : " + calculator.getResult());
            calculator.outputResultHistory();
            System.out.print((char)27+"[0m");
            System.out.print((char)27+"[1mContinue (y/n)?");
            cont = scanner.nextLine();
        } while (cont.equalsIgnoreCase("y"));
    }

}
