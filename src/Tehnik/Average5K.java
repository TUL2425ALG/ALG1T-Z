/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tehnik;

/**
 *
 * @author Tehnik-M-1424
 */
import java.util.Scanner;
public class Average5K {
    // 22,6 21,8 20,03 24,5 21,8 28,4 22,5 23,9 22,9 21,5
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            final int DISTANCE = 1;
            System.out.println("Zadej pocet behu: ");
            int count = sc.nextInt();

            if(count <= 0){ 
                break;
            }
            
            double[] runs = new double[count];

            runs = FillArr(runs);
            System.out.format("Prumerne jste 1 km zabehl za %.2f", Avg(runs));
            System.out.println("");
        }
    }
    
   
    
    public static double[] FillArr (double[] arr)
    {
        System.out.println("Zadej jednotlive casy behu: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextDouble();
        }
        return arr;
    }
    
    public static void PrintArr (double[] arr) //JV nevypisuje podle zadani
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    public static double Max (double[] arr)
    {
        double max = arr[0];
        double min_val = Double.MIN_VALUE; // INTEGER.MINVAL
        //JV je to trochu zmatek, jestli pocitate minimum nebo maximum, melo by to byt  int max = Double.MIN_VALUE; - nejmensi kladne cislo
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > min_val)
            {   
                min_val = arr[i];
            }
            
        }
        max = min_val;
        return max;
    }
    
    public static double Min (double[] arr)
    {
        double min = arr[0];
        double max_val = Double.MAX_VALUE; //INTEGER.MAXVAL
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<max_val)
            {   
                max_val = arr[i];
            }
            
        }
        min = max_val;
        return min;
    }
    
    public static double Avg (double[] arr)
    {
        double max = Max(arr);
        double min = Min(arr);
        double max_km = max/5.0;
        double min_km = max/5.0;
        double sum = 0;
        double avg = 0;
        
        for (int i = 0; i < arr.length; i++) {
            //JV chybi vypocet sumy
        }
        sum = sum - max_km - min_km; 
        avg = sum/((double)arr.length-2);
        return avg;

    }
}
