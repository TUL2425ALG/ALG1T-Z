package kosek;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
//3
//0 3 -5 2 0 4 -3 5 0
//3
//0 -3 -5 2 0 4 -3 5 0
//3
//0 -5 5 2 0 4 -3 5 0
//3
//0 -5 5 2 0 4 3 5 0
//2
//0 2 1 0
//3
//0 5 5 2 0 4 3 5 0
public class Reputation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Zadejte počet uživatelů:");
            int n = sc.nextInt();

            if (n <= 0) {
                break;
            }

            System.out.println("Zadejte hodnotící matici:");
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            System.out.println("Zarovaný výpis:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf(" %4d ", matrix[i][j]);
                }
                System.out.println("");
            }

            System.out.println("Průměrné reputace:");
            double[] average = average(matrix);
            for (int i = 0; i < n; i++) {
                System.out.printf("Uživatel %d: %.2f\n", i + 1, average[i]);
            }

            int[] controversial = controversial(matrix);
            int controversialIndex = findMostControversial(controversial);

            System.out.println("Nejvíce kontroverzní uživatel je " + (controversialIndex + 1) + ". Má rozdíl " + controversial[controversialIndex] + ".");

            System.out.println("Přátelské dvojice:");
            int[][] friendly = friendly(matrix);
            for (int i = 0; i < n; i++) {
                if (friendly[i][0] > 0 && friendly[i][1] > 0) {
                    System.out.println(friendly[i][0] + "," + friendly[i][1]);
                }
            }

            if (isPositive(matrix)) {
                System.out.println("Platforma je pozitivní.\n");
            } else {
                System.out.println("Platforma není pozitivní.\n");
            }
        }
    }

    public static int[][] friendly(int[][] matrix) {
        int n = matrix.length;
        int[][] friendly = new int[n][2];

        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] > 0 && matrix[j][i] > 0) {
                    friendly[index][0] = i + 1;
                    friendly[index][1] = j + 1;
                    index++;
                }
            }
        }

        return friendly;
    }

    public static boolean isPositive(int[][] matrix) {
        int n = matrix.length;
        boolean[] positive = new boolean[n];

        for (int i = 0; i < n; i++) {
            positive[i] = false;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0) {
                    positive[i] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!positive[i]) {
                return false;
            }
        }

        return true;
    }

    public static int findMostControversial(int[] controversial) {
        int n = controversial.length;
        int mostControversial = controversial[0];
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (mostControversial < controversial[i]) {
                mostControversial = controversial[i];
                index = i;
            }
        }

        return index;
    }

    public static int[] controversial(int[][] matrix) {
        int n = matrix.length;
        int[] controversial = new int[n];
        int[] min = new int[n];
        int[] max = new int[n];

        for (int i = 0; i < n; i++) {
            max[i] = Integer.MIN_VALUE;
            min[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > max[i] && matrix[i][j] != 0) {
                    max[i] = matrix[i][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < min[i] && matrix[i][j] != 0) {
                    min[i] = matrix[i][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            controversial[i] = Math.abs(min[i] - max[i]);
        }

        return controversial;
    }

    public static double[] average(int[][] matrix) {
        int n = matrix.length;
        double[] average = new double[n];

        double sum;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }
            average[i] = sum / (n - 1);
        }

        return average;
    }
}
