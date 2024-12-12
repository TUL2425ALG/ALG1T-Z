/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Samborskyj;

import java.util.Scanner;

/**
 * 10 
 * 22,6 21,8 20,03 24,5 21,8 28,4 22,5 23,9 22,9 21,5
 *
 * @author Samborskyj-N-daef
 */
public class Average5K {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int DELKA_TRASY = 5;
        double prumerny_cas = 0;
        int pocet_behu;
        double[] behy_nej;
        double[] cas_behu;
        System.out.println("Zadejte počet běhů");
        while ((pocet_behu = sc.nextInt()) > 0) {
            System.out.println("Zadejte časy běhů");
            behy_nej = new double[2];
            cas_behu = new double[pocet_behu];
            cas_behu[0] = sc.nextDouble();
            behy_nej[0] = cas_behu[0];
            for (int i = 1; i < pocet_behu; i++) {
                cas_behu[i] = sc.nextDouble();
                if (cas_behu[i] < behy_nej[0]) {
                    behy_nej[0] = cas_behu[i];
                }
                if (cas_behu[i] > behy_nej[1]) {
                    behy_nej[1] = cas_behu[i];
                }
            }
            System.out.println("Použité hodnoty pro výpočet:");
            System.out.print("{ ");
            for (int i = 0; i < cas_behu.length; i++) {
                if (cas_behu[i] != behy_nej[0] && cas_behu[i] != behy_nej[1]) {
                    prumerny_cas += (double) cas_behu[i] / DELKA_TRASY;
                    System.out.print(cas_behu[i] + ", ");
                }
            }

            System.out.print("} \n");
            prumerny_cas = (double) prumerny_cas / (cas_behu.length - 2);
            System.out.format("Průměrně jste 1 km uběhl za %.2f min. \n", prumerny_cas);
            System.out.println("Zadejte počet běhů");
        }
    }
}
