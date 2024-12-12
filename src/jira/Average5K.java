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
public class Average5K {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        final int VZDALENOST = 5;

        System.out.println("Zadejte počet běhů:");

        int pocetBehu = 0;
        double[] casyBehu = new double[0];
        double casBehu = 0;
        double prumernaRychlost = 0;
        double sumaBehu = 0;
        double[] krajniCasy = {Double.MAX_VALUE, Double.MIN_VALUE}; // [0] - nejmensi, [1] - nejdelsi
        int[] krajniIndexy = new int[2]; // [0] - nejmensi, [1] - nejdelsi

        while ((pocetBehu = sc.nextInt()) > 0) {
            casyBehu = new double[pocetBehu];
            System.out.println("Zadejte časy běhů:");
            for (int i = 0; i < pocetBehu; i++) {

                casBehu = sc.nextDouble();
                casyBehu[i] = casBehu;
                if (casBehu < krajniCasy[0]) {
                    krajniCasy[0] = casBehu;
                    krajniIndexy[0] = i;
                }
                if (casBehu > krajniCasy[1]) {
                    krajniCasy[1] = casBehu;
                    krajniIndexy[1] = i;
                }

            }
            
            System.out.println("Použité hodnoty pro výpočet:");
            System.out.print("{");
            double[] casyBehuProVypocet = new double[pocetBehu - 2]; 
            for (int i = 0, j = 0; i < casyBehuProVypocet.length; i++, j++) {
                if (j == krajniIndexy[0] || j == krajniIndexy[1]) {
                    j++;
                    if (j == krajniIndexy[0] || j == krajniIndexy[1]) { //ošetření, kdyby náhodou indexy krajních běhů byly vedle sebe
                        j++;
                    }
                }
                casyBehuProVypocet[i] = casyBehu[j];
                sumaBehu += casyBehu[j];
                if (i != casyBehuProVypocet.length - 1) {
                    System.out.print(casyBehuProVypocet[i] + ", ");
                }
            }
            System.out.print(casyBehuProVypocet[casyBehuProVypocet.length - 1] + "} \n");

            prumernaRychlost = (sumaBehu / casyBehuProVypocet.length) / VZDALENOST;

            System.out.format("Průměrně jste 1 km uběhl za %.2f min. \n", prumernaRychlost);

            System.out.println("Zadejte počet běhů:");
            prumernaRychlost = 0;
            sumaBehu = 0;
            krajniIndexy = new int[2]; // [0] - nejmensi, [1] - nejdelsi
            krajniCasy[0] = Double.MAX_VALUE; // [0] - nejmensi
            krajniCasy[1] = Double.MIN_VALUE; // [1] - nejdelsi
        }

    }

}
