/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package honc;

import java.util.Scanner;

/**
 *
 * @author Honc-F-e282
 */
public class Average5k {
    public static void main(String[] args) {
        while(true){
        Scanner sc = new Scanner(System.in);
        double suma = 0;
        int length = 1;
        System.out.println("Zadej pocet behu:");
        int runs = sc.nextInt();
        if(runs<=0)break;
        System.out.println("Zadej casy behu:");
        double[] a = new double[runs];
        for (int i = 0; i < runs; i++) {
            a[i] = sc.nextDouble();
            suma = suma + a[i];
        }
        
        System.out.println("Pouzite hodnoty"); //JV pouzite mely byt hodnoty bez min a max 
        System.out.print("{");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + (i == a.length-1?"":","));
        }
        System.out.print("}");
        System.out.println("");
        
        double min = Double.MAX_VALUE;
        double max = Double.MAX_VALUE*-1; //zatim
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            } 
        }
        double mean = (suma-min-max)/(runs-2);
        mean = mean*((double)length/5);
        //System.out.println("Prumerne jste "+length+" zabehl za "+ mean + "min"); //format
        System.out.format("Prumerne jste  %d kilometr zabehl za %.2f min",length,mean);
        System.out.println();
    }}
}
