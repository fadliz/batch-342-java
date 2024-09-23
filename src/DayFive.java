import java.util.Arrays;

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
                    System.out.print(((n * 2 * (i / 2)) + (1 + (j * 2))) + "\t");
                } else {
                    // (i + 1) kali 2
                    System.out.print(((n * 2 * (i / 2)) + ((1 + j) * 2)) + "\t");
                }
            }
            System.out.println();
        }
    }

    public int calculateMean(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum / arr.length;
    }

    public int calculateMedian(int[] arr) {
        Arrays.sort(arr);
        if (arr.length % 2 == 1) {
            return arr[arr.length / 2];
        }
        return (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2;
    }

    public int calculateMode(int[] arr) {
        Arrays.sort(arr);
        int count = 1, maxCount = 1, mode = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > maxCount) {
                maxCount = count;
                mode = arr[i - 1];
            }
        }
        return mode;
    }

    public int calculateMin(int[] arr) {
        int min = arr[0];
        for (int i : arr) {
            min = i < min ? i : min;
        }
        return min;
    }

    public int calculateMax(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            max = i > max ? i : max;
        }
        return max;
    }

}
