public class DayFour {
    public void matrixIndexPrint(int size) {
        System.out.println(((char)27 + "[4m--------").repeat(size) + ((char)27 + "[4m-"));
        for (int i = 0; i < size; i++) {
            System.out.print((char)27 + "[0m ");
            for (int j = 0; j < size; j++) {
                System.out.print((char)27+"[0m|[" + i + "," + j + "]|" + ((char)27 + "[0m "));
            }
            System.out.println();
        }
    }

    public void matrixStarPrint(int size) {
        System.out.println(((char)27 + "[4m--------").repeat(size) + ((char)27 + "[4m-"));
        for (int i = 0; i < size; i++) {
            System.out.print((char)27 + "[0m ");
            for (int j = 0; j < size; j++) {
                System.out.print((char)27+"[0m|[*]|" + ((char)27 + "[0m "));
            }
            System.out.println();
        }
    }

    public void matrixRCIndexPrint(int row, int column) {
        System.out.println(((char)27 + "[4m--------").repeat(column) + ((char)27 + "[4m-"));
        for (int i = 0; i < row; i++) {
            System.out.print((char)27 + "[0m ");
            for (int j = 0; j < column; j++) {
                System.out.print((char)27+"[0m|[" + i + "," + j + "]|" + ((char)27 + "[0m "));
            }
            System.out.println();
        }
    }

    public void matrixRCStarPrint(int row, int column) {
        System.out.println(((char)27 + "[4m------").repeat(column) + ((char)27 + "[4m-"));
        for (int i = 0; i < row; i++) {
            System.out.print((char)27 + "[0m ");
            for (int j = 0; j < column; j++) {
                System.out.print((char)27+"[0m|[*]|" + ((char)27 + "[0m "));
            }
            System.out.println();
        }
    }

    public void triangleNumPrint(int num, boolean reverse) {
        System.out.println("===".repeat(num+1));
        for (int i = 0; i < num; i++) {
            System.out.print("|");
            int temp = 1;
            for (int j = 1; j <= num; j++) {
                if (reverse) {
                    System.out.print(j >= (num-i) ? ("  ") + (temp++) : "   ");
                    
                } else {
                    System.out.print(j <= i+1 ? j + "  " : "   ");
                }
            }
            System.out.print(" |");
            System.out.println();
        }
        System.out.println("===".repeat(num+1));
    }

    public void triangleNumPrintAsterisk(int num, boolean reverse) {
        System.out.println("===".repeat(num+1));
        for (int i = 0; i < num; i++) {
            System.out.print("|");
            for (int j = 1; j <= num; j++) {
                if (reverse) {
                    System.out.print(j >= (num-i) ? ("  *") : "   ");
                } else {
                    System.out.print(j <= i+1 ? "*  " : "   ");
                }
            }
            System.out.print(" |");
            System.out.println();
        }
        System.out.println("===".repeat(num+1));
    }
}
