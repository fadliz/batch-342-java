public class DayFive {
    public void patternedAsteriskOne(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(((i == 0 || i == n - 1 || j == 0 || j == n - 1) ? " * " : "   "));
            }
            System.out.println();
        }
    }

    public void patternedAsteriskTwo(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(((i == j || i + j == n - 1) ? " * " : "   "));
            }
            System.out.println();
        }
    }

    public void reversedCountMatrix(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((n * (n - i) - j) + "\t");
            }
            System.out.println();
        }
    }

    public void oddEvenCountMatrix(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    // 1 + (i * 2) = 3
                    System.out.print(((n * 2 * (i/2)) + (1 + (j * 2))) + "\t");
                } else {
                    // (i + 1) kali 2
                    System.out.print(((n * 2 * (i/2)) + ((1 + j) * 2)) + "\t");
                }
            }
            System.out.println();
        }
    }
}
