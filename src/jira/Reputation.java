/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jira;

import java.util.Scanner;

/**
 *
 * @author Jira-L-4984
 */
public class Reputation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Zadejte počet uživatelů:");

        int pocetUzivatelu = sc.nextInt();

        int[][] hodnoticiMatice = new int[pocetUzivatelu][pocetUzivatelu];
        int[] reputaceUzivatelu = new int[pocetUzivatelu];

        System.out.println("Zadejte hodnotící matici:");
        for (int i = 0; i < pocetUzivatelu; i++) {
            for (int j = 0; j < pocetUzivatelu; j++) {
                hodnoticiMatice[i][j] = sc.nextInt();
            }
        }
        System.out.println("Zarovnaný výpis:");

        for (int i = 0; i < pocetUzivatelu; i++) {
            for (int j = 0; j < pocetUzivatelu; j++) {
                System.out.format("%s %d ", ((hodnoticiMatice[i][j] >= 0) ? " " : ""), hodnoticiMatice[i][j]);

                reputaceUzivatelu[i] += hodnoticiMatice[i][j]; // 0 může být přičtena, nic nezmění
            }
            System.out.println("");
        }

        System.out.println("Průměrné reputace:");
        for (int i = 0; i < pocetUzivatelu; i++) {
            System.out.format("Uživatel %d: %.2f \n", (i + 1), (reputaceUzivatelu[i] / (double) (pocetUzivatelu - 1)));
        }

        int[] kontroverznost = KontroverzniUzivatel(hodnoticiMatice); //[0] - index; [1] - rozdíl

        System.out.format("Nejvíce kontroverzní uživatel je %d. Má rozdíl %d. \n", kontroverznost[0], kontroverznost[1]);

        System.out.println("Přátelské dvojice:");

        for (int i = 0; i < pocetUzivatelu - 1; i++) {
            for (int j = i + 1; j < pocetUzivatelu; j++) {
                if (hodnoticiMatice[i][j] > 0 && hodnoticiMatice[j][i] > 0) {
                    System.out.println((i + 1) + " " + (j + 1));
                }

            }
        }

        System.out.format("Platforma %s pozitivní \n", (JePozitivni(hodnoticiMatice) ? "je" : "není"));

    }

    private static boolean JePozitivni(int[][] hodnoticiMatice) {
        boolean pozitivniUzivatel = false;
        for (int i = 0; i < hodnoticiMatice.length; i++) {
            for (int j = 0; j < hodnoticiMatice.length; j++) {
                if (hodnoticiMatice[i][j] > 0) { //0 na diagonálách to nepřeruší
                    pozitivniUzivatel = true;
                    break;
                }
            }
            if (!pozitivniUzivatel) {
                return false;
            }
            pozitivniUzivatel = false;
        }
        return true;
    }

    private static int[] KontroverzniUzivatel(int[][] hodnoticiMatice) {
        int kontroverzniUzivatel = 0;
        int nejvetsiRozdil = 0;

        int nejlepsiHodnoceni = Integer.MIN_VALUE;
        int nejhorsiHodnoceni = Integer.MAX_VALUE;
        int rozdilUzivatele = 0;
        for (int i = 0; i < hodnoticiMatice.length; i++) {
            for (int j = 0; j < hodnoticiMatice.length; j++) {
                if (i != j) {
                    if (hodnoticiMatice[i][j] > nejlepsiHodnoceni) {
                        nejlepsiHodnoceni = hodnoticiMatice[i][j];
                    }
                    if (hodnoticiMatice[i][j] < nejhorsiHodnoceni) {
                        nejhorsiHodnoceni = hodnoticiMatice[i][j];
                    }
                }
            }

            rozdilUzivatele = nejlepsiHodnoceni - nejhorsiHodnoceni;
            if (rozdilUzivatele > nejvetsiRozdil) {
                nejvetsiRozdil = rozdilUzivatele;
                kontroverzniUzivatel = i + 1;
            }

            nejlepsiHodnoceni = Integer.MIN_VALUE;
            nejhorsiHodnoceni = Integer.MAX_VALUE;

        }
        int[] hodnoty = {kontroverzniUzivatel, nejvetsiRozdil};
        return hodnoty;
    }

}
