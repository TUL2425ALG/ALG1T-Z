package graf;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Graf-D-e193
 */
public class Reputation {
     private static final Scanner sc = new Scanner(System.in);
     
     public static void main(String[] args) {
        //input
        System.out.println("Zadejte počet uživatelů:");
        int numOfUsers=sc.nextInt();
        System.out.println("Zadejte hodnotící matici:");
        int[][] reviews = new int[numOfUsers][numOfUsers];
        for(int i = 0;i<numOfUsers;i++){
            for(int j = 0;j<numOfUsers;j++){
                reviews[i][j] = sc.nextInt();
            }
        }
        double[] avgUserScore = new double[numOfUsers];
        for(int i = 0; i< numOfUsers;i++){
            avgUserScore[i]=averageOfUser(reviews,i);
        }
        int[] mostControversial = controversialUser(reviews);
 
        //output
        System.out.println("Zarovnaný zápis:");
        printIntMatrix(reviews);
        
        System.out.println("Průměrné reputace:");
        for(int i = 0; i< numOfUsers;i++){
            System.out.println("Uživatel "+(i+1)+": "+avgUserScore[i]);
        }
        
        System.out.println("Nejvíce kontroverzní uživatel je "+ (mostControversial[0]+1)+". Má rozdíl "+mostControversial[1]);
        
        
         System.out.println("Přátelské dvojice:");
         for(int i = 0;i<reviews.length;i++){
            for(int j = i+1;j<reviews.length;j++){
                if(reviews[i][j]>0 && reviews[j][i]>0){
                    System.out.println((i+1)+", "+(j+1));
                }
            }   
        }
         
         System.out.println((isPlatformPositive(reviews))?"Platforma je pozitivní.":"Platforma není pozitivní");
     }
        
        
     
     public static void printIntMatrix(int[][] a ){
        for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a[i].length;j++){
                System.out.print( ((a[i][j]<0)?"":" ") + a[i][j] + " ");
            }
            System.out.print("\n");
        }
     }
     public static double averageOfUser(int[][] a,int user ){
        int sum=0;
        for(int i = 0;i<a.length;i++){
            sum+=a[user][i];
        }
        
        return (double)sum / (a.length-1);
     }
     public static int[] controversialUser(int[][] a)
     {
     int index = 0;
     int difference = 0;
     for(int i = 0;i<a.length;i++){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int j = 0;j<a[i].length;j++){
            if(a[i][j]>max){max=a[i][j]; }
            if(a[i][j]<min){min=a[i][j]; }
        }
        int diff = max-min;
        if(diff>difference){
        difference=diff;
        index=i;
        }
     }
     return new int[] {index,difference};
     }
     
     public static Boolean isPlatformPositive (int[][] a)
     {
     for(int i = 0;i<a.length;i++){
        Boolean hasPositive = false;
        for(int j = 0;j<a.length;j++){
            if(a[i][j]>0 && i!=j){
                hasPositive=true;
                break; // user has positive review, we can go to the next user (i+1) [not strictly needed, but avoids running the rest of the loop for no reason ]
            }
        }
        if(!hasPositive){
                return false;
            }
     }
     return true;
     }
     
     
}
