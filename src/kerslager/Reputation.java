/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kerslager;

import java.util.Scanner;

/**
 *
 * @author Kerslager-J-51ca
 */
public class Reputation {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int[][] mat = input();
        System.out.println("Zarovnaný výpis:");
        printMat(mat);
        
        System.out.println("Průměrné reputace:");
        avgRep(mat);
        
        controversial(mat);
        
        System.out.println("Přátelské dvojice:");
        friendlyDuos(mat);
        
        System.out.format("Platforma %s pozitivní.\n", isPositive(mat) ? "je" : "není");
    }
    
    static int[][] input(){
        System.out.println("Zadejte počet uživatelů:");
        int cnt = sc.nextInt();
        System.out.println("Zadejte hodnotící matici:");
        int[][] mat = new int[cnt][cnt];
        for(int i = 0; i < cnt; i++){
            for(int j = 0; j < cnt; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        return mat;
    }
    
    static void printMat(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat.length; j++){
                System.out.format("%3d", mat[i][j]);
            }
            System.out.print("\n");
        }
    }
    
    static void avgRep(int[][] mat){
        //0 3 -5 2 0 4 -3 5 0
        int sum = 0;
        for(int i = 0; i < mat.length; i++){
            sum = 0;
            for(int j = 0; j < mat.length; j++){
                if(i != j){
                    sum += mat[i][j];
                }
            }
            double avg = (double)sum/(mat.length - 1);
            System.out.format("Uživatel %d: %.2f\n", i+1, avg);
        }
    }
    
    static void controversial(int[][] mat){
        int biggestDiff = Integer.MIN_VALUE;
        int mostCon = 0;
        for(int i = 0; i < mat.length; i++){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < mat.length; j++){
                if(i != j){
                    if(mat[i][j] > max){
                        max = mat[i][j];
                    }
                    if(mat[i][j] < min){
                        min = mat[i][j];
                    }
                }
            }
            int diff = max - min;
            if(diff > biggestDiff){
                biggestDiff = diff;
                mostCon = i;
            }
        }
        System.out.format("Nevíce kontroverzní je uživatel %d. Má rozdíl %d.\n", mostCon+1, biggestDiff);
    }
    
    static void friendlyDuos(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j <= i; j++){
                if((mat[i][j] > 0) && (mat[j][i] > 0)){
                    System.out.format("%d, %d\n", j+1, i+1);
                }
            }
        }
    }
    
    static boolean isPositive(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            boolean hasPositive = false;
            for(int j = 0; j < mat.length; j++){
                if((i != j) && (mat[i][j] > 0)){
                    hasPositive = true;
                }
            }
            if(!hasPositive){
                return false;
            }
        }
        return true;
    }
}
