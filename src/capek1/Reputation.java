package capek1;

import java.util.Scanner;

public class Reputation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadejte počet uživatelů:");
        int pocetUzivatelu = sc.nextInt();
        
        int n = pocetUzivatelu;
        int[][] matice = new int[n][n];
        System.out.println("Zadejte hodnotící matici:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matice[i][j] = sc.nextInt();
            }
        }
        
        double[] prumernaReputace = new double[n];
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {
                sum += matice[i][j];
            }
            prumernaReputace[i] = (sum / (n - 1));
        }
        
        int[] rozdilPole = new int[2];
        rozdilPole = nejvetsiRozdil(matice);
        
        System.out.print("Zarovnaný výpis:");
        for (int i = 0; i < n; i++) {
            System.out.println("");
            for (int j = 0; j < n; j++) {
                System.out.print(matice[i][j] + " ");
            }
        }
        System.out.println("");
        System.out.println("Průměrná repotace:");
        for (int i = 0; i < prumernaReputace.length; i++) {
            System.out.format("Uživatel %d: %.2f\n", (i + 1), prumernaReputace[i]);
        }
        System.out.format("Nejvíce kontroverzní uživatel je %d. Má rozdíl %d.", (rozdilPole[0] + 1), rozdilPole[1]);
    }
    
    private static int[] nejvetsiRozdil(int[][] a) {
        int iMin;
        int iMax;
        int rozdil;
        int maxRozdil = -1;
        int iMaxRozdil = -1;
        
        for (int i = 0; i < a.length; i++) {
           iMin = hledejiMin(a[i]);
           iMax = hledejiMax(a[i]);
           rozdil = Math.abs(a[i][iMin] - a[i][iMax]);
           if(rozdil > maxRozdil){
               maxRozdil = rozdil;
               iMaxRozdil = i;
           }
        }
        int[] rozdilPole = new int[2];
        rozdilPole[0] = iMaxRozdil;
        rozdilPole[1] = maxRozdil;
        return rozdilPole;
    }
    
    private static int hledejiMin(int[] a) {
        int min = Integer.MAX_VALUE;
        int iMin = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min){
                min = a[i];
                iMin = i;
            }
        }return iMin;
    }
    
    private static int hledejiMax(int[] a) {
        int max = 0;
        int iMax = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max){
                max = a[i];
                iMax = i;
            }
        }return iMax;
    }
}