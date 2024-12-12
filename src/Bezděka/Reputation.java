/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bezděka;

import java.util.Scanner;

/**
 *
 * @author Bezdeka-M-675a
 */
public class Reputation {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //input
        int[][] hodnMatice = Input();
        //Process
        double[] prumery = ziskejPrumerRadku(hodnMatice);
        int[] kontroverzni = najdiNejkrontroverznejsiho(hodnMatice);
        boolean[][] pratele =  najdiPratelskeDvojice(hodnMatice);
        //je pozitivni? - 
        //Output
        vypisMatici(hodnMatice);
        for (int i = 0; i < prumery.length; i++) {
            System.out.println("Uživatel " + i + ": " + prumery[i]);
        }
        System.out.println(kontroverzni[0]+1 + " " + kontroverzni[1]);
        for (int i = 0; i < pratele.length; i++) {
            for (int j = 0; j < pratele.length; j++) {
                if(pratele[i][j]){
                    System.out.println(i+1 + ", " + (j+1));
                }
                
            }
        }
    }
    private static int[][] Input(){
        int[][] matice;
        System.out.println("zadejte počet uživatelů: ");
        int pocet = sc.nextInt();
        matice = new int[pocet][pocet];
        System.out.println("zadejte hodnoty (postupně):");
            for(int i = 0; i< pocet;i++){
                for(int j = 0;j < pocet;j++){
                    matice[i][j] = sc.nextInt();
                }
            }
        return matice;
    }
    private static void vypisMatici(int[][] matice){
        System.out.println("zarovananý zápis:");
        for(int i=0;i<matice.length;i++){
            for (int j = 0; j < matice.length; j++) {
                if(matice[i][j] < 0){
                    System.out.print(matice[i][j] + " ");
                }else{
                    System.out.print(" " + matice[i][j] + " ");
                }
                
            }
            System.out.println("");
        }
    }
    private static double[] ziskejPrumerRadku(int[][] matice){
        int sumaRadku;
        double[] prumery = new double[matice.length];
        for (int i = 0; i < matice.length; i++) {
            sumaRadku = 0;
            for(int j = 0; j < matice.length;j++){
                sumaRadku += matice[i][j];
                
            }
            prumery[i] = sumaRadku/(matice.length-1);
        }
        return prumery;
    }
    private static int[] najdiNejkrontroverznejsiho(int[][] matice){
        int[] soucetRadku = new int[matice.length];
        int nejnizsiSoucetID = 0;
        int nejnizsiSoucet = Integer.MAX_VALUE;
        int nejvyssiSoucet = Integer.MIN_VALUE;
        //secti radky
        for (int i = 0; i < soucetRadku.length; i++) {
            for (int j = 0; j < soucetRadku.length; j++) {
                soucetRadku[i] += matice[i][j];
                
            }
        }
        //najdi nejnizsi soucet
        for (int i = 0; i < soucetRadku.length; i++) {
            if (soucetRadku[i] < nejnizsiSoucet) {
                nejnizsiSoucet = soucetRadku[i];
                nejnizsiSoucetID = i;
            }
            
        }
        //najdi nejvyssi soucet
        for (int i = 0; i < soucetRadku.length; i++) {
            if (soucetRadku[i] > nejvyssiSoucet) {
                nejvyssiSoucet = soucetRadku[i];
            }
            
        }
        int[] output = new int[2];
        output[0] = nejnizsiSoucetID;
        output[1] =  nejvyssiSoucet - nejnizsiSoucet;
        return output;
    }
    private static boolean[][] najdiPratelskeDvojice(int[][] matice){
        boolean[][] dvojice = new boolean[matice.length][matice.length];
        for (int i = 0; i < matice.length; i++) {
            for (int j = i+1; j < matice.length; j++) {
                if (matice[i][j] > 0 && matice[j][i] > 0) {
                    dvojice[i][j] = true;
                }else{
                    dvojice[i][j] = false;
                }
               
            }
            
        }
        return dvojice;
    }
}
