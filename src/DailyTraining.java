import java.util.Random;
import java.util.Scanner;

public class DailyTraining {
    public String generational(int year) {
        String Generation = "";
        if (year >= 1901 && year <= 1927) {
            Generation = "G.I. Generation";
        }
        else if (year >= 1928 && year <= 1945) {
            Generation = "Silent Generation";
        }
        else if (year >= 1946 && year <= 1964) {
            Generation = "Baby Boomers Generation";
        }
        else if (year >= 1965 && year <= 1980) {
            Generation = "Gen X";
        }
        else if (year >= 1981 && year <= 1996) {
            Generation = "Gen Y";
        }
        else if (year >= 1997 && year <= 2010) {
            Generation = "Gen Z";
        }
        else if (year >= 2011 && year <= 2025) {
            Generation = "Millennial Alpha";
        }
        return Generation;
    }

    public String bmi(double height, int weight) {
        double bmi = (double) weight / (double) (height * height) ;
        if (bmi < 18.5) {
            return "Underweight";
        }
        else if (bmi >= 18.5 && bmi < 25) {
            return "Normal weight";
        }
        else if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        }
        else {
            return "Obese";
        }
    }

    public String minAndMax(int a, int b, int c, int d) {
        // int min = Math.min(Math.min(a, b), Math.min(c, d));
        // int max = Math.max(Math.max(a, b), Math.max(c, d));
        int min = (int) (Double.POSITIVE_INFINITY);
        int max = (int) (Double.NEGATIVE_INFINITY);
        if (a < min) min = a;
        if (a > max) max = a;
        if (b < min) min = b;
        if (b > max) max = b;
        if (c < min) min = c;
        if (c > max) max = c;
        if (d < min) min = d;
        if (d > max) max = d;
        return "min : " + min + "\nmax : " + max;
    }

    public boolean betweenAB(int a, int b) {
        if (a >= 30 && a <= 50) {
            if (b >= 30 && b <= 50) {
                return true;
            }
        }
        return false;
    }

    // Perulangan

    //no.5
    public void fiboN() {
        int a = 0; int b = 1; 
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

    //no.6
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

    // Matrix
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

    // DAY 03
    public String dayName(int number) {
        return switch (number) {
            case 1 -> "Senin";
            case 2 -> "Selasa";
            case 3 -> "Rabu";
            case 4 -> "Kamis";
            case 5 -> "Jumat";
            case 6 -> "Sabtu";
            case 7 -> "Minggu";
            default -> "Urutan Hari tidak ditemukan di planet bumi";
        };
    }

    public int DayNumber(String day) {
        return switch (day.toLowerCase()) {
            case "senin" -> 1;
            case "selasa" -> 2;
            case "rabu" -> 3;
            case "kamis" -> 4;
            case "jumat" -> 5;
            case "sabtu" -> 6;
            case "minggu" -> 7;
            default -> -1;
        };
    }
}
