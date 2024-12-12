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
public class Reputation {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Zadej pocet uziv");
        int pocetUziv = sc.nextInt();
        
        System.out.println("Zadej hodnotici matici");
        int[][] matrix = loadMatrix(pocetUziv);
        
//        System.out.println("Zarovnany vypis");
//        zarovnanyVypis(matrix);
        System.out.println("Prumerne reputace: ");
        prumer(matrix, pocetUziv);
    }
    public static int[][] loadMatrix(int pocetUziv){
        int[][] hodnoticiMat = new int[pocetUziv][pocetUziv];     
        for (int i = 0; i < hodnoticiMat.length; i++) {
            for (int j = 0; j < hodnoticiMat.length; j++) {
                hodnoticiMat[i][j] = sc.nextInt();
            }
        }
        return hodnoticiMat;  
    }
    
    public static void zarovnanyVypis(int[][] matrix){
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                
            }
        }
    }
    public static void prumer(int[][] matrix, int pocetUziv){
        double prumer = 0;
        for (int i = 0; i < matrix.length; i++) {    
            for (int j = 0; j < matrix.length; j++) {
                prumer = (prumer + matrix[i][j]) / (pocetUziv - 1);

            }
            System.out.println("Uzivatel " + (i+1) + ": " + prumer);
            prumer = 0;
        }
    }
    
    public static void pratele(int[][] matrix){
        boolean jeKladny = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
               // matrix[i][j] a matrix[j][i] musi byt obe kladne
            }
            
        }
    }
}
