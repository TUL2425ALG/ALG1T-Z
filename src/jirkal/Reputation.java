/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jirkal;

import java.util.Scanner;
/**
 *
 * @author Jirkal-J-3ff5
 */
public class Reputation {
    public static void main(String[] args) {
      Scanner sc  = new Scanner(System.in);
        int pocetuzivatelu = 0;
        System.out.println("Zadejte počet uživatelů: ");
        pocetuzivatelu = sc.nextInt();
        //int matice[][] = new int[3][3];
        //int matice[][] = {{0,3,-5}, {2,0,4}, {-3,5,0}};
        int matice[][] = new int[pocetuzivatelu][pocetuzivatelu];
        //zapsání matice
        System.out.println("Zapište matici: ");
        
        for (int i = 0; i < pocetuzivatelu; i++)
        {
            for (int j = 0; j < pocetuzivatelu; j++)
            {
                matice[i][j] = sc.nextInt();
            }
            
        }
        
        //matice vypsaná zarovnaně bohužel se tam pletou ty mínusy nevim jestli se jich mám nějak zbavovat
           for (int i = 0; i < matice.length; i++)
           {
                for (int j = 0; j < matice[i].length; j++)
            {
                System.out.print(matice[i][j]); //JV chtelo tam pouzit format 
            }
               System.out.println();
           }
        
          //vypsání přátelských dvojic 
            System.out.println("Přátelské dvojice: ");
            for (int i = 0; i < matice.length - 1; i++)
            {
                for (int j = i; j < matice[i].length; j++)
            {
                if (matice[i][j] > 0 | matice[j][i] > 0)
                {
                    System.out.println((i+1) + ", " +  (j+1));
                }
            }
           }
        
        
        
        //průmerná hodnota uživatele
        for (int i = 0; i < matice.length; i++)
        {
            int prumer = 0; 
            for (int j = 0; j < matice[i].length; j++)
            {
                prumer += matice[i][j];
            }
            System.out.println("Průměr uživatele " + (i + 1) +  ": " + prumer / (matice[i].length - 1));
        }
        
        Kontroverze(matice);
        
        
        String platforma = IsPositive(matice) ? "Platforma je pozitivní" : "Platforma je negativní";
        System.out.println(platforma);
    }
    
    public static boolean IsPositive(int matice[][]){
        boolean positive = false;
        for (int i = 0; i < matice.length; i++)
        {
            boolean innerpositive = false;
            for (int j = 0; j < matice[i].length; j++)
            {
                if( matice[i][j] > 0)
                {
                  innerpositive = true;  //JV tu uz mohl byt break
                }
            }
            if (!innerpositive){
                positive = false;
                break;
            }
            else{
                positive = true;
            }
        }
        return positive;
    }
    
    //kontroverzní uživatel
    public static void Kontroverze(int matice[][]){

        double hodnoty[][] = new double[matice.length][2];
         for (int i = 0; i < matice.length; i++)
        {
            int max = matice[i][0];
            int min = matice[i][0];
            for (int j = 0; j < matice[i].length; j++)
            {
                if (matice[i][j] > max)
                {
                    max = matice[i][j];
                }
                if (matice[i][j] < min)
                {
                    min = matice[i][j];
                }
            }
            hodnoty[i][0] = min;
            hodnoty[i][1] = max;
        }
        double hodnoty1[] = new double[matice.length]; //JV trochu zbytecne komplikovany algoritmus
        for (int i = 0; i < hodnoty.length; i++)
        {
            double reverse = 0;
            if(hodnoty[i][0] - hodnoty[i][1] < 0)
            {
                reverse = (hodnoty[i][0] - hodnoty[i][1]) - (2*(hodnoty[i][0] - hodnoty[i][1]));
            }
            hodnoty1[i] = reverse;
        }
        double kontr = 0;
        int kontrindex = 0;
        for (int i = 0; i < hodnoty.length; i++)
        {
            if(hodnoty1[i] > kontr)
            {
                kontr = hodnoty1[i];
                kontrindex = (i + 1);
            }
        }
        System.out.println("Nejvíce kontroverzní uživatel je " + kontrindex + "." + "  Má rozdíl " + kontr + ".");
         
        
    }
}
