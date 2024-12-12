package capek1;

import java.util.Scanner;

public class Average5K {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                
        while(true) {
            System.out.println("Zadejte počet běhů:");
            int pocetBehu = sc.nextInt();
            
            if(pocetBehu <= 0){
                break;
            }

            double[] casy = new double[pocetBehu];
            System.out.println("Zadejte časy běhů:");
            for (int i = 0; i < casy.length; i++) {
                casy[i] = sc.nextDouble();
            }

            int iMin = hledejiMin(casy);
            int iMax = hledejiMax(casy);
            for (int i = 0; i < casy.length; i++) {
                if(i == iMin || i == iMax){
                    casy[i] = 0;
                }
            }
            
            double soucetBehu = 0;
            for (int i = 0; i < casy.length; i++) {
                soucetBehu += casy[i];
            }
            
            int vzdalenost = 5;
            double prumer5km = soucetBehu / (pocetBehu - 2);
            double prumer1km = prumer5km / vzdalenost;
            
            System.out.println("Použité hodnoty pro výpočet:");
            System.out.print("{ ");
            for (int i = 0; i < casy.length; i++) {
                if(i == iMin || i == iMax){
                    continue;
                }
                System.out.print(casy[i] + " ");
            }
            System.out.print("}");
            System.out.format("\nPrůměrně jste 1 km uběhl za %.2f min.\n", prumer1km);
        }
    }
    
    private static int hledejiMin(double[] a) {
        double min = Double.MAX_VALUE;
        int iMin = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min){
                min = a[i];
                iMin = i;
            }
        }return iMin;
    }
    
    private static int hledejiMax(double[] a) {
        double max = 0;
        int iMax = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max){
                max = a[i];
                iMax = i;
            }
        }return iMax;
    }
}
