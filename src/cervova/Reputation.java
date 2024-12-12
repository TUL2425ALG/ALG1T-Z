/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cervova;

import java.util.Scanner;
//Test: in: 3, 0 3 -5 2 0 4 -3 5 0


/**
 *
 * @author Cervova-A-d47b
 */
public class Reputation {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadejte pocet uzivatelu:");
        int pocetUzivatelu = sc.nextInt();
        
        int [][] hodnoticiMatice = new int [pocetUzivatelu][pocetUzivatelu];
        
        System.out.println("Zadejte hodnotici matici:");
        for (int i = 0; i < hodnoticiMatice.length; i++) {
            for (int j = 0; j < hodnoticiMatice[0].length; j++) {
                hodnoticiMatice[i][j] = sc.nextInt();   
            }
            
        }
        zarovnanyVypis(hodnoticiMatice);
        prumernaReputace(hodnoticiMatice);
        nejviceKontroverzni(hodnoticiMatice);
        pratelskeDvojice(hodnoticiMatice);
        pozitivniPlatforma(hodnoticiMatice);
            
    }
    
    private static void zarovnanyVypis (int [][] hodnoticiMatice){
        System.out.println("Zarovnany vypis");
        for (int i = 0; i < hodnoticiMatice.length; i++) {
            for (int j = 0; j < hodnoticiMatice[0].length; j++) {
                if(hodnoticiMatice[i][j] < 0){
                    System.out.print(hodnoticiMatice[i][j] + " ");
                }else{
                    System.out.print(" " + hodnoticiMatice[i][j] + " ");
                }
                
            }
            System.out.println("");
        }
    }
    
    private static void prumernaReputace (int [][] hodnoticiMatice){
        
        
        System.out.println("Prumerne reputace");
        for (int i = 0; i < hodnoticiMatice.length; i++) {
            int soucetHodnoceni = 0;
            for (int j = 0; j < hodnoticiMatice[0].length; j++) {
                soucetHodnoceni += hodnoticiMatice[i][j];
                
            }
            System.out.println("Uzivatel " + (i+1) + ". " + (double)(soucetHodnoceni/(hodnoticiMatice.length-1)));
        }
    }
    
    private static void nejviceKontroverzni(int[][] hodnoticiMatice){
        
        int nejvetsiVzdalenost = 0;
        int uzivatelNejvetsiVzdalenost = 0;
        for (int i = 0; i < hodnoticiMatice.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int vzdalenost = 0;
            for (int j = 0; j < hodnoticiMatice[0].length-1; j++) {
                if (hodnoticiMatice[i][j]< min){
                    min = hodnoticiMatice[i][j];
                }
                if (hodnoticiMatice[i][j]> max){
                    max = hodnoticiMatice[i][j];
                }
            }
            
            vzdalenost = (Math.abs(min)+Math.abs(max));
            
            if (vzdalenost > nejvetsiVzdalenost){
                nejvetsiVzdalenost = vzdalenost;
                uzivatelNejvetsiVzdalenost = i + 1;
            }
            
        }
        System.out.println("Nejvice kontroverzni je uzivatel " + uzivatelNejvetsiVzdalenost + ". Ma rozdil " + nejvetsiVzdalenost + ".");
    }
    
    private static void pratelskeDvojice (int[][] hodnoticiMatice){
        
        for (int i = 0; i < hodnoticiMatice.length-1; i++) {
            int [] dvojice = new int [2];
            for (int j = 1; j < hodnoticiMatice[0].length; j++) {
                if (hodnoticiMatice[i][j] > 0 && hodnoticiMatice[i+1][j-1]>0){
                     dvojice[0] = i+1;
                     dvojice [1] = i+2;
                     System.out.println(dvojice[0] + ", " + dvojice[1]);    
                    }  
                } 
            }
            
        }
 
    
    private static void pozitivniPlatforma(int [][] hodnoticiMatice){
        
        boolean pozitivniPlatforma = false;
        for (int i = 0; i < hodnoticiMatice.length; i++) {
            for (int j = 0; j < hodnoticiMatice[0].length; j++) {
                if (hodnoticiMatice [i][j] > 0){
                    pozitivniPlatforma = true;
                }
                
            }
            if (!pozitivniPlatforma){
                break;
            }
        }
        System.out.println("Platforma " + (pozitivniPlatforma ? "je": "neni")+ " pozitivni.");
    }
        
}

