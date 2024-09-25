import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner scn = new Scanner(System.in)) {
            DaySeven training = new DaySeven();
            long balance = 0;
            training.moneyTransferProgram(balance);

            scn.close();
        }
    }

}