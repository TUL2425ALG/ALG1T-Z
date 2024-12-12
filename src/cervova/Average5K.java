/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cervova;

import java.util.Scanner;
//Test: in: 10; 22,6 21,8 20,03 24,5 21,8 28,4 22,5 23,9 22,9 21,5


/**
 *
 * @author Cervova-A-d47b
 */
public class Average5K {
    public static void main(String[] args) {
        
        final double VZDALENOST = 5;
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadejte pocet behu:");
        int pocetBehu = sc.nextInt();
        while(pocetBehu > 0){
            double [] behy = new double [pocetBehu];

            System.out.println("Zadejte casy behu:");
            for (int i = 0; i < behy.length; i++) {
                behy[i] = sc.nextDouble();

            }

            System.out.println("Pouzite hodnoty pro vypocet:");
            System.out.print("{");
            for (int i = 0; i < behy.length; i++) {
                System.out.print(behy[i] + ", ");
                if (i == behy.length-1){
                    System.out.print(behy[i]+ "}");
                }
            }
            System.out.println("");
            
            prumer1km(behy,VZDALENOST);
            
            System.out.println("Zadejte pocet behu:");
            pocetBehu = sc.nextInt();
        }
    }
    
    private static void prumer1km (double [] behy, final double VZDALENOST){
        
        double [] casy1km = new double[behy.length];
        
        for (int i = 0; i < behy.length; i++) {
            casy1km[i] = behy[i]/VZDALENOST;
            
        }
        
        for (int i = 0; i < casy1km.length-1; i++) {
            if(casy1km[i]>casy1km[i+1]){
                double temp = casy1km[i];
                casy1km[i] = casy1km[i+1];
                casy1km[i+1] = temp;
            }   
        }
        
        double [] zahrnuteCasy = new double [casy1km.length-2];
        for (int i = 1; i < zahrnuteCasy.length; i++) {
            zahrnuteCasy[i] = casy1km[i+1];
            
        }
        
        double soucetCasy1km = 0;
        for (int i = 0; i < zahrnuteCasy.length; i++) {
            soucetCasy1km += casy1km[i];
            
        }
        
        double prumernaRychlost1km = soucetCasy1km/zahrnuteCasy.length;
       
        System.out.format("Prumerne jste 1 km ubehl za %.2f min.%n", prumernaRychlost1km);
    }
}