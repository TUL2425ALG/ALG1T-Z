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
public class Reputation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadejte počet uživatelů:");
        int pocet = sc.nextInt();
        System.out.println("Zadejte hodnotící matici:");
        int [][] hodnot = new int[pocet][pocet];
        for(int i = 0 ; i < pocet; i++){
            for(int k = 0; k < pocet; k++){
                hodnot[i][k] = sc.nextInt();
            }
        }
        System.out.println("Zarovnaný výpis:");
        for(int i = 0 ; i < pocet; i++){
            for(int k = 0; k < pocet; k++){
                System.out.print(hodnot[i][k] + " ");
            }
            System.out.println();
        
        }
        double [] idk = new double [pocet];
         System.out.println("Průměrné reputace:");
          for(int i = 0 ; i < pocet; i++){
           idk[i] = hodnoceni(hodnot)[i];
                System.out.println("uživate " + (i+1) + ": " + idk[i]);
            
            
        
        }
          
          System.out.println("Nejvíce kontroverzní uživatel je " + kontroverzni(hodnot)[1] + ". Má rozdíl " + kontroverzni(hodnot)[0]);
          if(pozitivni(hodnot) == true){
              System.out.println("Platforma je pozitivni ");
          }else{
              System.out.println("Platforma není pozitivni ");
          }
        
    }
    
    public static  double[] hodnoceni(int pole[][]){
        double [] prumer = new double[pole.length];
        
        for(int i = 0 ; i < pole.length; i++){
            for(int k = 0; k < pole.length; k++){
                prumer[i] += pole[i][k];
            }
            prumer[i] = prumer[i]/(pole.length - 1);
        }
        return prumer;
        
    }
    public static  int[] kontroverzni(int pole[][]){
        int [] kon = new int[pole.length];
       
        int nejh = -1;
        int nejl = -1;
                
        for(int i = 0 ; i < pole.length; i++){
            for(int k = 0; k < pole.length; k++){
                if(nejl == -1 || pole[i][k] > nejl){
                    nejl = pole[i][k];
                   
                }else if(nejh == -1 || pole[i][k] < nejh){
                    nejh = pole[i][k];
                    
                }
                
                
            }
            int l = Math.abs(nejl);
            int h = Math.abs(nejh);
            kon[i] = h + l;
        }
        int nejv = -1;
        
        int [] result = new int[2];
        for(int i = 0 ; i < kon.length; i++){
            if(nejv == -1 || kon[i] > nejv){
                
                
                result[0] = kon[i];
                result[1] = i-1;
            }
            
        }
       
        return result;
        
    }
    public static  int[][] pratele(int pole[][]){
        int [][] p = new int[pole.length][2];
    
       
                
        for(int i = 0 ; i < pole.length; i++){
            for(int k = 0; k < pole.length; k++){
                if(i != 0 && pole[i][k] > 0 || pole[i-1][k+1] >0){
                    p[i][1] = i;
                    p[i][1] = i-1;
                }
                
                
            }
            
        }
        
        
        return p;
        
    }
    public static  boolean pozitivni(int pole[][]){
      
        boolean pozitiv = false;
        int c = 0;
        for(int i = 0 ; i < pole.length; i++){
            for(int k = 0; k < pole.length; k++){
                if(pole[i][k] > 0 && pozitiv == false){
                    pozitiv = true;
                    c++;
                }
                
            }
             pozitiv = false;
        }
        if (c == pole.length){
            return true;
        }else{
            return false;
        }
            
        
        
        
    }
}
