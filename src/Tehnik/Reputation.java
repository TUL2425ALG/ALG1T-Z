/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tehnik;

import java.util.Scanner;

/**
 *
 * @author Tehnik-M-1424
 */
public class Reputation {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // 0 3 -5 2 0 4 -3 5 0 
        
        int[][] mat = Input();
        PrintMatrix(mat);
        UserAvgRep(mat);
        int[] reputations = CountRep(mat);
        ControverseUser(reputations);
        //TODO Pratelske dvojice
        System.out.println("Platforma "+ (IsPlatformPositive(mat) ? "je ":"neni ") + "pozitivni" );
        
    }
    
    public static int[][] Input()
    {
        System.out.println("Zadej pocet uzivatelu: ");
        int n = sc.nextInt();
        int[][] reviews = new int[n][n];
        System.out.println("Zadej hodnotici matici: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                reviews[i][j] = sc.nextInt();
            }
        }
        return reviews;
    }
    public static void PrintMatrix(int[][] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                //System.out.print(arr[i][j]);   
                if (arr[i][j] < 0)
                {
                   System.out.print(" "); 
                }else{
                    System.out.print("  ");
                }
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
    }
    
    public static void UserAvgRep(int[][] arr)
    {
        double avg = 0; 
        
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (i != j){ //JV ani nebylo potreba testovat +0 neovlyvni sumu
                    sum += arr[i][j];
                }
            }
            avg = (double)sum/((double)arr.length-1);
            System.out.println("Avg uzivatele " + (i+1) + " je " +avg);
            
        }
   
    }
    
    public static void ControverseUser (int[] arr)
    {
        int max = arr[0]; //JV i tady by to melo byt v abs hodnote
        int uzivatel = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) > max)
            {
                max = Math.abs(arr[i]);
                uzivatel = i;
            }
        }
        System.out.println("Nejvice kontroverzni uzivatel je " + uzivatel + " Ma rozdil " + max);
    }
    
    public static int[] CountRep(int[][] arr)
    {
        int reputation = 0;
        
        int[] reputations = new int[arr.length+1];
        
        for (int i = 0; i < arr.length; i++) {
            //int reputation = 0;
            int min = 0;
            int max = 1000;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] > min) //JV opet to nedava smysl, kdyz je vetsi, dej ho do min
                {
                    min = arr[i][j];
                }
                if (arr[i][j] < max)
                {
                    max = arr[i][j];
                }
            }
            reputation = max-min;
            //System.out.println("Reputation " + (i+1) + reputation);
            reputations[i+1] = reputation;
        }
        return reputations;
    }
    
    public static void PrintArr (int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    //JV nedokoncene
    public static boolean IsPlatformPositive(int[][] arr)
    {
        boolean status = false;
        for (int i = 0; i < arr.length; i++) {
            status = false;
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j] > 0)
                {
                    status = true;
                }
                
            }
            
        }
        
        return status;
    }
    
    //chybi pratelske dvojice
}
