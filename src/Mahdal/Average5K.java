/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mahdal;

import static java.lang.Double.MAX_VALUE;
import java.util.Scanner;

/**
 *
 * @author Mahdal-R-62fb
 */
public class Average5K {

    public static void main(String[] args) {
//        int runs = 6;
//        double times[] = {10, 15 , 15, 15, 20, 15};
//        10 15 15 15 20 15
//        int runs = 10;
//        double times[] = {22.6,21.8,20.03,24.5,21.8,28.4,22.5,23.9,22.9,21.5};
//        22,6 21,8 20,03 24,5 21,8 28,4 22,5 23,9 22,9 21,5
        final int DISTANCE = 5;
        double maxtime = -Double.MAX_VALUE;
        double mintime = Double.MAX_VALUE;
        double totaltime = 0;
        double avg;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Zadejte pocet behu");
            int runs = sc.nextInt();
            if (runs <= 0) {
                break;
            }
            double[] times = new double[runs];
            System.out.println("Zadejte casy behu v minutach");
            //nacitani
            for (int i = 0; i < times.length; i++) {
                times[i] = sc.nextDouble();
            }
            //min,max
            for (int i = 0; i < times.length; i++) {
                if (times[i] < mintime) {
                    mintime = times[i];
                }
                if (times[i] > maxtime) {
                    maxtime = times[i];
                }
                totaltime = totaltime + times[i];
            }

            avg = (totaltime - mintime - maxtime) / ((runs - 2) * DISTANCE);
            System.out.print("Pouzite hodnoty pro vypocet:\n{");
            for (int i = 0; i < times.length; i++) {
                if (times[i] != maxtime && times[i] != mintime) {
                    if (i == times.length - 1) {
                        System.out.print(times[i]);
                    } else {
                        System.out.print(times[i] + ", ");
                    }
                }
            }
            System.out.println("}");
            System.out.format("Prumerne jste 1km ubehl za %.2f min.\n", avg);

        }
    }
}
