/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jirkal;

import java.util.Scanner;
/**
 *
 * @author Jirkal-J-3ff5
 */
public class Average5K {
     public static void main(String[] args) {
         Scanner sc  = new Scanner(System.in);
         
         int pocetbehu = 0;
         System.out.println("Zadejte Počet běhů");
         pocetbehu = sc.nextInt();
         //int pocetbehu = 5;
         
       
         
         while (pocetbehu >= 1)
         {
             
            double behy[] = new double[pocetbehu];
            double behy1[] = new double[pocetbehu];
            
            for (int i = 0; i < pocetbehu; i++)
            {
                System.out.println("Zadejte čas pro běh " + i + ": ");
                behy[i] = sc.nextDouble();
            }
            //double[] behy1 = {0,0,0};
            //double[] behy = {22.6, 23.6, 20.03};
            double max = behy[0];
            double min = behy[0];
            for(int i = 0; i < behy.length; i++)
            {

               if(behy[i] >  max)
               {
                   max = behy[i];
               }
               if(behy[i] <  min)
               {
                   min = behy[i];
               }
               behy1[i] = behy[i]/5;
            }

            double prumer = 0;
            for(int i = 0; i < behy1.length; i++){
                if (behy1[i] != min/5 && behy[i] != max){
                   prumer += behy1[i];
                }

            }
            prumer = prumer / (behy1.length - 2);
            /*
            System.out.println("Jednotlivé běhy");
            for (int i = 0; i < behy1.length; i++){
                System.out.println(behy1[i]);
            }
   */

         
            System.out.println("Použité hodnoty pro výpočet:");
            System.out.print("{");
            for (int i = 0; i < behy.length; i++){
               
                System.out.print(behy[i] + ", ");
            }
            System.out.print("}");
            System.out.println("Pruměr běhů je: ");
            System.out.println(prumer);

             System.out.println("Pro pokračování zadejte počet běhů: ");
             pocetbehu = sc.nextInt();
         }
         
    
         
    }
     
}
