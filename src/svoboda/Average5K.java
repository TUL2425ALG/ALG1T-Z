/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package svoboda;

import java.util.Scanner;

/**
 *
 * @author Svoboda2-M-ca22
 */
public class Average5K {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int beh = 5;
        
        while(true){
            double nejpomal = -1;
            double nejrych = -1;
            System.out.println("Zadej počet běhů:");
            int pocet = sc.nextInt();
            int cislo1 = -1;
            int cislo2 = -1;
            double [] celkemCas = new double[pocet];
            if(pocet <= 0){
                break;
            }
            double [][] cas = new double[pocet][1];
            System.out.println("Zadej časy běhů:");
            for(int i = 0; i < pocet;i++){
                
                cas[i][0] = sc.nextDouble();
                
                if(nejpomal == -1 || cas[i][0] > nejpomal){
                    nejpomal = cas[i][0];
                    cislo1 = i;
                }else if(nejrych == -1 || cas[i][0] < nejrych){
                    nejrych = cas[i][0];
                    cislo2 = i;
                }
                
                celkemCas[i] = cas[i][0];
            }
            celkemCas[cislo1] = 0;
            celkemCas[cislo2] = 0;
            double soucet = 0;
            System.out.println("Použité hodnoty pro výpočet:");
            System.out.print("{");
            for(int i = 0; i < celkemCas.length; i++){
                
                if(celkemCas[i] <= 0){
                     
                }else{
                    System.out.print(Double.toString(celkemCas[i]) + " ");
                    soucet += celkemCas[i];
                }
                
            }
            System.out.print("}");
            System.out.println();
            double prumer = (soucet/(pocet-2))/5;
            System.out.println("Průměrně jste 1 km ubehl za " + prumer + " min.");
        }
    }
}
