package kosek;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
//10
//22,6 21,8 20,03 24,5 21,8 28,4 22,5 23,9 22,9 21,5
//4,54
//3
//22,8 20,4 19
//4,08
//4
//22,8 20,4 19 18
//3,94
public class Average5K {

    private static final int DISTANCE = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Zadejte počet běhů:");
            int n = sc.nextInt();

            if (n <= 0) {
                break;
            }

            System.out.println("Zadejte časy běhů:");
            double[] times = new double[n];
            for (int i = 0; i < n; i++) {
                times[i] = sc.nextDouble();
            }

            double max = findMax(times);
            double min = findMin(times);
            double[] newTimes = new double[n];
            boolean deletedMax = false;
            boolean deletedMin = false;
            for (int i = 0; i < n; i++) {
                if (!deletedMax && max == times[i]) {
                    deletedMax = true;
                    continue;
                }
                if (!deletedMin && min == times[i]) {
                    deletedMin = true;
                    continue;
                }
                newTimes[i] = times[i];
            }
            times = null; //JV to ani netrebalo, drzi to puvodni zadane data

            System.out.print("{");
            for (int i = 0; i < n; i++) {
                if (i != newTimes.length - 1 && newTimes[i] != 0) {
                    if (i > 0 && newTimes[i + 1] == 0) {
                        System.out.printf("%.1f", newTimes[i]);
                    } else {
                        System.out.printf("%.1f, ", newTimes[i]);
                    }
                } else {
                    if (i == newTimes.length - 1 && newTimes[i] != 0) {
                        System.out.printf("%.1f", newTimes[i]);
                    }
                }
            }
            System.out.print("}\n");

            System.out.printf("Průměrně jste 1 km uběhl za %.2f min.\n", calculate(newTimes));
            System.out.println("");
        }
    }

    public static double findMax(double[] a) {
        int n = a.length;
        double max = a[0];

        for (int i = 0; i < n; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        return max;
    }

    public static double findMin(double[] a) {
        int n = a.length;
        double min = a[0];

        for (int i = 0; i < n; i++) {
            if (min > a[i]) {
                min = a[i];
            }
        }

        return min;
    }

    public static double calculate(double[] times) {
        int n = times.length;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            if (times[i] != 0) {
                sum += times[i] / DISTANCE;
            }
        }

        double averageTime = sum / (n - 2);

        return averageTime;
    }
}
