
import java.util.Random;
import java.util.Scanner;

public class DayTwo {
    public void fiboN() {
        int a = 0;
        int b = 1;
        try (Scanner scn = new Scanner(System.in)) {
            System.out.print("Masukkan n: ");
            int n = scn.nextInt();
            scn.close();
            for (int i = 0; i < n; i++) {
                System.out.print((b) + " ");
                int temp = a;
                a = b;
                b = temp + b;
            }
        }
    }

    // no.6
    public long factorial() {
        try (Scanner scn = new Scanner(System.in)) {
            System.out.print("Masukkan bilangan: ");
            int a = scn.nextInt();
            scn.close();
            long sum = 1;
            for (int i = a; i > 0; i--) {
                sum *= i;
            }
            return sum;
        }
    }
    public void matrixPrint() {
        Random rand = new Random();
        try (Scanner scn = new Scanner(System.in)) {
            System.out.print("Masukkan banyak Baris: ");
            int row = scn.nextInt();
            System.out.print("Masukkan banyak Kolom: ");
            int column = scn.nextInt();
            scn.close();
            long[][] arrMatrix = new long[row][column];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    arrMatrix[i][j] = rand.nextInt(1000);
                }
            }

            System.out.println("||==============".repeat(column) + "||");
            for (int i = 0; i < row; i++) {
                System.out.print("||\t");
                for (int j = 0; j < column; j++) {
                    System.out.print(arrMatrix[i][j] + "\t||\t");
                }
                System.out.println("");
                System.out.println("||==============".repeat(column) + "||");
            }
        }
    }
}
