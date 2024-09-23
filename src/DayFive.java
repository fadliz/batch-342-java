public class DayFive {
    public void patternedAsteriskOne(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(((i == 0 || i == n-1 || j == 0 || j == n-1) ? " * " : "   "));
            }
            System.out.println();
        }
    }

    public void patternedAsteriskTwo(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(((i == j || i+j == n-1) ? " * " : "   "));
            }
            System.out.println();
        }
    }
}
