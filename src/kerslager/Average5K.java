/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kerslager;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Kerslager-J-51ca
 */
public class Average5K {
    
    static Scanner sc = new Scanner(System.in);
    final static int DELKA = 5;
    
    public static void main(String[] args) {
        System.out.println("Zadejte počet běhů:");
        int cnt = sc.nextInt();
        while(cnt > 0){
            if((cnt > 0) && (cnt < 3)){
                System.out.println("Průměr bez nejrychlejšího a nejpomalešího nemá smysl");
            } else{
                double[] casy = casyInput(cnt);
                output(casy);
                System.out.println("Zadejte počet běhů:");
            }
            cnt = sc.nextInt();
        }
    }
    
    
    static double[] casyInput(int cnt){
        double[] casy = new double[cnt];
        System.out.println("Zadejte časy běhů:");
        for(int i = 0; i < cnt; i++){
            casy[i] = sc.nextDouble();
        }
        return casy;
    }
    
    static void output(double[] casy){   
        //vypis casu bez min a max bez Arrays.sort()
        //vypise bez prohozeni poradi (jako v zadani)
        /*
        double min = casy[0];
        double max = casy[0];
        int minIdx = 0;
        int maxIdx = 0;
        for(int i = 0; i < casy.length; i++){
            if(casy[i] > max){
                maxIdx = i;
                max = casy[i];
            }
            if(casy[i] < min){
                minIdx = i;
                min = casy[i];
            }
        }
        System.out.println("Použité hodnoty pro výpočet");
        System.out.print("{");
        boolean first = true;
        for(int i = 0; i < casy.length; i++){
            if((i != minIdx) && (i != maxIdx)){
                if(!first){
                    System.out.print(", ");
                }
                System.out.format("%.1f", casy[i]);
                first = false;
            }
        }
        System.out.println("}");
        */
        Arrays.sort(casy);
        //{cas1, cas2, ...}
        System.out.println("Použité hodnoty pro výpočet");
        System.out.print("{");
        boolean first = true;
        for(int i = 1; i < (casy.length-1); i++){
            if(!first){
                System.out.print(", ");
            }
            System.out.format("%.1f", casy[i]);
            first = false;
        }
        System.out.println("}");
        System.out.format("Průměrně jste 1km uběhl za %.2f min.\n", avgPer1km(casy));
    }
    
    static double avgPer1km(double[] casy){
        //hledani min a max bez pouziti Arrays.sort
        /*
        double min = casy[0];
        double max = casy[0];
        int minIdx = 0;
        int maxIdx = 0;
        for(int i = 0; i < casy.length; i++){
            if(casy[i] > max){
                maxIdx = i;
                max = casy[i];
            }
            if(casy[i] < min){
                minIdx = i;
                min = casy[i];
            }
        }
        double sum = 0;
        for(int i = 0; i < casy.length; i++){
            if((i != minIdx) && (i != maxIdx)){
                sum += casy[i];
            }
        }
        */
        double[] fil = casy.clone();
        Arrays.sort(fil);
        double sum = 0;
        for(int i = 1; i < (fil.length - 1); i++){
            sum += fil[i];
        }
        
        double avgTime = sum/(casy.length - 2);
        double timePer1 = avgTime / DELKA;
        return timePer1;
    }
}
