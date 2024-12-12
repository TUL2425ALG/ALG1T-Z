/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graf;

import java.util.Scanner;

/**
 *
 * @author Graf-D-e193
 */
public class Average5K {
     private static final Scanner sc = new Scanner(System.in);
     
     public static void main(String[] args) {
         int numOfRuns=0;
         Boolean shouldContinue = true;
         while(shouldContinue){
             System.out.println("Zadejte počet běhů:");
             numOfRuns=sc.nextInt();
             if(numOfRuns<1){
                shouldContinue=false;
             }else{
                 
                double[] times = new double[numOfRuns];
                //input
                System.out.println("Zadejte časy běhů:");
                for(int i = 0; i< numOfRuns;i++){
                    times[i]=sc.nextDouble();
                }
             
                //processing
                double avg1KmTime = averageValueInArrayNoMaxMin(times)/5;
             
                //output
                System.out.println("Použité hodnoty pro výpočet:");
                System.out.println(doubleArrayToString(times));
                System.out.printf("Průměrně jste 1 km uběhli za %.2f min.\n",avg1KmTime);
                
             }
             
         }
         
      }
     public static String doubleArrayToString(double[] a){
         String output="{";
         for(int i = 0;i<a.length;i++){
            output+=a[i];
            if(i<a.length-1){
                output+=", ";
            }
         }
         return output+"}";
     }
     public static double averageValueInArrayNoMaxMin(double[] a){
         if(a.length<3){//To avoid / 0 in return
            return 0;
         }
         double sum=0;
         double max=0;
         double min=Double.MAX_VALUE;
         for(int i = 0;i<a.length;i++){
            sum+=a[i];
            if(a[i]>max){max=a[i]; }
            if(a[i]<min){min=a[i]; }
         }
         return (sum-min-max)/(a.length-2);
     }
}
