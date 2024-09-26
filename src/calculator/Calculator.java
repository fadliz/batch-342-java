package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    private final Scanner scanner;
    private Double result;
    private static final ArrayList<Double> resultHistory = new ArrayList<>();

    public Calculator() {
        this.scanner = new Scanner(System.in);
    }

    public Double getResult() {
        return result;
    }

    public void addition(Double num1, Double num2) {
        this.result = num1 + num2;
    }

    public void subtraction(Double num1, Double num2) {
        this.result = num1 - num2;
    }

    public void multiplication(Double num1, Double num2) {
        this.result = num1 * num2;
    }

    public void division(Double num1, Double num2) {
        this.result = num1 / num2;
    }

    public void square(Double num1) {
        this.result = Math.pow(num1, 2);
    }

    public void power(Double num1, Double num2) {
        this.result = Math.pow(num1, num2);
    }

    public void squareRoot(Double num1) {
        this.result = Math.sqrt(num1);
    }

    private void menu() {
        System.out.print("\n1. Addition");
        System.out.print("\t\t2. Subtraction");
        System.out.print("\n3. Multiplication");
        System.out.print("\t4. Division");
        System.out.print("\n5. Square");
        System.out.print("\t\t6. Power");
        System.out.print("\n7. Square Root");
        System.out.print("\t\t0. Exit\n\n");
    }

    public void calculate() {
        Double num1;
        Double num2;
        if (result == null) {
            System.out.print("Input First Number : ");
            num1 = Double.valueOf(scanner.nextLine());
        } else {
            num1 = result;
        }
        menu();
        System.out.print("Pick Operation : ");
        Short operation = Short.valueOf(scanner.nextLine());
        switch (operation) {
            case 1 -> {
                System.out.print("Input Second Number : ");
                num2 = Double.valueOf(scanner.nextLine());
                this.addition(num1, num2);
            }
            case 2 -> {
                System.out.print("Input Second Number : ");
                num2 = Double.valueOf(scanner.nextLine());
                this.subtraction(num1, num2);
            }
            case 3 -> {
                System.out.print("Input Second Number : ");
                num2 = Double.valueOf(scanner.nextLine());
                this.multiplication(num1, num2);
            }
            case 4 -> {
                System.out.print("Input Second Number : ");
                num2 = Double.valueOf(scanner.nextLine());
                this.division(num1, num2);
            }
            case 5 -> {
                this.square(num1);
            }
            case 6 -> {
                System.out.print("Input Second Number : ");
                num2 = Double.valueOf(scanner.nextLine());
                this.power(num1, num2);
            }
            case 7 -> {
                this.squareRoot(num1);
            }
        }
        if (result == null) result = num1;
        resultHistory.add(result);
    }

    public void outputResultHistory(){
        System.out.println();
        System.out.println((char)27+"[4mResult History");
        for(int i = 0; i < resultHistory.size(); i++){
            System.out.println("Result " + (i+1) + " : " + resultHistory.get(i));
        }
    }
}
