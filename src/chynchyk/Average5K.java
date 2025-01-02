package chynchyk;

import java.util.Scanner;

public class Average5K {
    public static void main(String[] args) {
        final double beh = 5.0;
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("Zadejte pocet bezcu: ");
            int pocet = sc.nextInt();
            if (pocet <= 0) {
                break;
            }
        }
        
        double[] cas = new double[pocet];
        System.out.println("Zadejte cas behu: ");
        for (int i = 0; i < pocet; i++){
            cas[i] = sc.nextDouble();
        }

        double prumer = 0;
        double max = Double.MAX_VALUE;
        double min = Double.MIN_VALUE;
        
        for (double time : cas){
         prumer += time;
         
        }
        System.out.format("Průměrné jste 1km ubehl za %.2f min.", prumer);
    }
}