/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package krenkova;

import java.util.Scanner;

/**
 *
 * @author Krenkova-M-b5b4
 */
public class Reputation {
    public static void main(String[] args) {
        //3
        //0 3 -5 2 0 4 -3 5 0
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Zadejte počet uživatelů: ");
        int userCount = sc.nextInt();        
        int[][] rateMatrix = new int[userCount][userCount];   
        System.out.println("Zadejte hodnotící matici: ");
        for (int i = 0; i < rateMatrix.length; i++) {
            for (int j = 0; j < rateMatrix[i].length; j++) {
                rateMatrix[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("Zarovnaný zápis: ");
        for (int i = 0; i < rateMatrix.length; i++) {
            for (int j = 0; j < rateMatrix[i].length; j++) {
                System.out.format("%3d", rateMatrix[i][j]);
            }
             System.out.println();
        }
        
        int[] reputations = AverangeReputation(rateMatrix, userCount);
        System.out.println("Průměrné reputace: ");
        for (int i = 0; i < reputations.length; i++) {
            System.out.format("Uživatel %d: %d", i+1, reputations[i]);
            System.out.println();
        }
        
        int[] controversions = MostControversionalUser(rateMatrix, userCount);
        System.out.format("Nejvíce kontroverzní je uživatel: %d. Má rozdíl %d.", controversions[0], controversions[1]);
        System.out.println();
         
        
        
        System.out.println("Přátelské dvojce jsou: NESTIHLA");
//        for (int i = 0; i <= rateMatrix.length-2; i++) {
//            boolean friends = false ;
//            for (int j = 0; j <= rateMatrix[i].length-2; j++) {
//               
//                if (rateMatrix[i][j+1] > 0 && rateMatrix[i+1][j] > 0 ) {
//                    friends = true;
//                    //System.out.println(rateMatrix[i+1][j] + ", " + rateMatrix[i+1][j]);
//                }
//            }
//            if (friends) {
//                System.out.println(rateMatrix[i][0] + ", " + rateMatrix[i+1][0]);
//            }
//            
//        }


        if(IsPlatformPositive(rateMatrix))
        {
            System.out.println("Platforma je pozitivní.");
        }
        else{
            System.out.println("Platforma není pozitivní.");
        } 
    }
    
    public static int[] AverangeReputation(int[][] rateMatrix, int userCount) //JV nedavejte zbytecne userCount, zjistete ho, ze zadane matice 
    {
        int[] reputations = new int[userCount];
                  
        for (int i = 0; i < rateMatrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < rateMatrix[i].length; j++) {
                rowSum += rateMatrix[i][j];
            }
            reputations[i] = rowSum / (userCount -1); //JV pri deleni integru dostanete celociselne deleni 
        }        
        return reputations;
    }
    
    
    public static int[] MostControversionalUser(int[][] rateMatrix, int userCount)
    {
        int[] usersRating = new int[userCount];
        int[] mostControversional = new int[2];
        
        for (int i = 0; i < rateMatrix.length; i++) {
             int maxRate = Integer.MAX_VALUE; //JV maxRate by melo byt na zacatku co nejmensi, aby hned prvni hodnoceni bylo vetsi a prepsalo ho
             int minRate = Integer.MIN_VALUE; //JV zde zase opak
            for (int j = 0; j < rateMatrix[i].length; j++) {
                if(minRate <= rateMatrix[i][j])
                {
                   minRate = rateMatrix[i][j];
                }
                else if (maxRate >= rateMatrix[i][j]) 
                {
                    maxRate = rateMatrix[i][j];
                }
            }
            //JV stacilo max - min
            if(minRate < 0)
            {
                Math.abs(minRate);
            } 
            if(minRate > maxRate)
            {
                usersRating[i] = minRate-maxRate;
            }
            else
            {
                usersRating[i] = maxRate-minRate;
            }
        }
        
        for (int i = 0; i <= usersRating.length-2; i++) 
        {   
            if ( usersRating[i] >=  usersRating[i+1]) {
                mostControversional[0] = i+1;   
                mostControversional[1] =  usersRating[i]; 
            }             
        }
         
        return mostControversional;
    }
    
    public static boolean IsPlatformPositive(int[][] rateMatrix)
    {
        for (int i = 0; i < rateMatrix.length; i++) {
            boolean row = false;
            for (int j = 0; j < rateMatrix[i].length; j++) {
                if(rateMatrix[i][j] > 0)
                {
                    row = true;
                    continue;
                }
            }
            if (!row) {
                return false;
            }
        }       
        return true;
    }
    
    
}
