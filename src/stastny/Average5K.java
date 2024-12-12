package stastny;

import java.util.Scanner;

/**
 * Zápočtová prace Vypocita z 5km behu prumer pro 1km
 * nejpomalejsi a nejrychlejsi cas se nebere
 * @author Patrik Stastny
 * @version 1.0 12/12/2024
 */
public class Average5K {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Zadejte pocet behu: (0 nebo zaporne pro ukonceni)");
        int n = sc.nextInt();
        if (n > 0) {
            int[] pocetbehu = new int[n];

            System.out.println("Zadejte cas behu: ");
            int cas = sc.nextInt();
            int[] times = new int[cas];

            System.out.println("Pouzite hodnoty pro vypocet:");
            //System.out.println(int[n][cas]);
            System.out.println("prumerne jste 1km ubehl za ");

            System.out.println("dokonceno.");
        } else {
            System.out.println("Program se vypina...");
        }

    }

    public static void vypocitej(int n, int[] pocetbehu, int[] times) {
        int vzdalenost5km = 5000;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (times[i] < times[j + 1]) {
                    times[i] = times[j + 1];
                    times[j + 1] = times[i];
                }
            }
            System.out.println("nejryhclejši cas:" + times[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j > i + 1; j++) {
                if (times[i] < times[j + 1]) {
                    times[i] = times[j + 1];
                    times[j + 1] = times[i];
                }
            }
            System.out.println("Nejpomalejsi cas:" + times[i]);
        }

        double[] konecnycas = new double[times.length];
        for (int i = 0; i < times.length; i++) {
            //konecnycas[i] = times[0][i];
            for (int j = 0; j < i + 1; j++) {
                if (i < j) {
                    //konecnycas[i];
                }
            }
        }
    }
}
