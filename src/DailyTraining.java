public class DailyTraining {
    public String generational(int year) {
        String Generation = "";
        if (year >= 1901 && year <= 1927) {
            Generation = "G.I. Generation";
        }
        else if (year >= 1928 && year <= 1945) {
            Generation = "B.C. Generation";
        }
        else if (year >= 1946 && year <= 1964) {
            Generation = "Millennial Generation";
        }
        else if (year >= 1965 && year <= 1980) {
            Generation = "Gen X";
        }
        else if (year >= 1981 && year <= 1996) {
            Generation = "Gen Y";
        }
        else if (year >= 1997 && year <= 2010) {
            Generation = "Boomer Generation";
        }
        else if (year >= 2011 && year <= 2025) {
            Generation = "Millennial Generation";
        }
        else if (year >= 2026 && year <= 2040) {
            Generation = "Gen Z";
        }
        return Generation;
    }

    public String bmi(int height, int weight) {
        double bmi = (double) weight / (height * height) * 703;
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
        if (a < min) {
            min = a;
        } else if (a > max) {
            max = a;
        }
        if (b < min) {
            min = b;
        } else if (b > max) {
            max = b;
        }
        if (c < min) {
            min = c;
        } else if (c > max) {
            max = c;
        }
        if (d < min) {
            min = d;
        } else if (d > max) {
            max = d;
        }
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
}
