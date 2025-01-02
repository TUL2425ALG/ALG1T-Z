/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package honc;

import java.util.Scanner;

/**
 *
 * @author Honc-F-e282
 */
public class Reputation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadejte pocet uzivatelu:");
        int count = sc.nextInt();
        int[][] A = new int[count][count];
        
        System.out.println("Zapis hodnotici matici:");
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = sc.nextInt();
            }         
        }
        
        System.out.println("Zarovnany zapis");
        matrixOutput(A);
        
        
        int sum;
        double mean;
        System.out.println("Prumerne reputace");
        for (int i = 0; i < A.length; i++) {
            sum=0;
            for (int j = 0; j < A[i].length; j++) {
                if(A[i]!=A[j]) {
                    sum = A[i][j] + sum;
                }
            }
            mean = (double)sum/(A[i].length-1);
            System.out.println("Uzivatel "+ (i+1) + ":" + mean);
        }
        
        kontroverzni(A);
        
        System.out.println("Pratelske dvojice:"); //JV prochazet jen cast matice napr. pod diagonalou, aby se nezobrazilo 1,2 a 2,1
        for (int i = 0; i < A.length; i++) {
            for (int j = A.length-1; j > 0; j--) {
                if(A[i][j] > 0 && A[j][i] > 0){
                    System.out.println(i+","+j);
                }
            }
            
        }
        
        isPositive(A);
        
    }
    
    public static void kontroverzni(int[][] A){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[][] matrix = new int[A.length][A.length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j]=A[i][j];
            }
            
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i]!=matrix[j]) {
                    if(matrix[i][j]<min)min=matrix[i][j];
                    if(matrix[i][j]>max)max=matrix[i][j];
                }
            }
            matrix[i][i] = max - min;
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }
        
        int uzivatel = 1;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][i]>max){
                max = matrix[i][i];
                uzivatel = i+1;
            }
        }
        
        System.out.println("Nejvice kontroverzni je uzivatel " + uzivatel + ". Ma rozdil " + max + ".");
    }
    
    public static void isPositive(int[][] A){
        boolean positive = false;
        int[][]matrix = A;

        for (int i = 0; i < matrix.length; i++) {
            positive = false;
            for (int j = 0; j < matrix[i].length; j++) {
                
                if(matrix[i][j] > 0){
                    positive = true;
                    break;
                }
                
            }
            if(!positive)break;
        }
        System.out.println("Platforma " + (positive==true?"je":"neni") + " pozitivni");
    }
    
    public static void matrixOutput(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.format("%2d ",matrix[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");    
    }
    
    
}
