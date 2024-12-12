/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farska;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Farska-L-3282
 */
public class Average5K {
    static Scanner sc = new Scanner(System.in);
    static final int PETKM = 5;
    
    public static void main(String[] args) {
        final int JEDENKM = 1;
        //static final int PETKM = 5;
        
        int pocetBehu;
        
//        System.out.println("Zadej pocet behu");
//        int pocetBehu = sc.nextInt();
        
        do{
            System.out.println("Zadej pocet behu");
            pocetBehu = sc.nextInt();
            double[] casy = loadData(pocetBehu);
            vypisHodnoty(casy);
            double[] casProKm  = casPro1Km(casy);
            //System.out.println(Arrays.toString(prumer(casy)));
            double[] sorted = sort(casProKm);
            double prumer = prumer(sorted);
            System.out.format("Prumerne jste 1km bezela za %.2f min\n", prumer);
            
        }while(pocetBehu > 0);
    }
    
    public static double[] loadData(int pocetBehu){
        double[] casy = new double[pocetBehu];
        
        for (int i = 0; i < casy.length; i++) {
            System.out.println("Zadej data pro beh " + (i + 1));
            casy[i] = sc.nextDouble();  
        }
        return casy;  
    }
    
    public static void vypisHodnoty(double[] casy){
        System.out.print("{");
        for (int i = 0; i < casy.length; i++) {
            if (casy[i] != casy[casy.length - 1]) {
                System.out.print(casy[i] + ", ");
            }else if (casy[i] == casy[casy.length - 1]){
                System.out.print(casy[i] + "} \n");
            }
        }
    }
    
    public static double[] casPro1Km(double[] casy){
        // cas pro 1 km
        double[] casPro1Km = new double[casy.length];
      
        for (int i = 0; i < casy.length; i++) {
            casPro1Km[i] = casy[i] / PETKM; 
        }
        return casPro1Km;
    }
    
    public static double[] sort(double[] casPro1Km){
        
        for (int i = 0; i < casPro1Km.length - 1 - i; i++) {
            
            double[] temp = new double[casPro1Km.length];
            if (casPro1Km[i+1] > casPro1Km[i]) {
               temp[i] = casPro1Km[i];
               casPro1Km[i] = casPro1Km[i + 1];
               casPro1Km[i + 1] = temp[i];
            }
        }
        return casPro1Km;
    }
    public static double prumer(double[] sorted){
        double soucet = 0;
        double prumer = 0;
        
        for (int i = 1; i < sorted.length - 1; i++) {
            soucet = soucet + sorted[i];
        }
        
        prumer = soucet / (sorted.length - 2);
        return prumer;
    }
}
