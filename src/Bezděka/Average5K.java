package Bezděka;

import java.util.Scanner;

/**
 * @author Bezdeka-M-675a
 */
public class Average5K {
    private static Scanner sc = new Scanner(System.in);
    final static double VZDALENOST = 5;
    public static void main(String[] args) {
        /*double[] c = new double[10];
        c[0] = 22.6;
        c[1] = 21.8;
        c[2] = 20.03;
        c[3] = 24.5;
        c[4] = 21.8;
        c[5] = 28.4;
        c[6] = 22.5;
        c[7] = 23.9;
        c[8] = 22.9;
        c[9] = 21.5;
        double[] po = new double[c.length-2];
        po = ZiskejPoleBezMinMax(c);
        Output(po,ZiskejPrumer(po));*/
        mainLoop();
    }
    private static void mainLoop(){
        double[] casy;
        while(true){
            //input
            System.out.println("Zadej Počet běhů: ");
            int pocet = sc.nextInt();
            if(pocet <= 0)return;
            casy = new double[pocet];
            System.out.println("Zadejte časy běhů (postupně)");
            for(int i = 0; i< pocet;i++){
                casy[i] = sc.nextDouble();
            }
            double[] poleBezMinMax = ZiskejPoleBezMinMax(casy);
            
            Output(poleBezMinMax, ZiskejPrumer(poleBezMinMax));
        }
    }
    //process
    private static double[] ZiskejPoleBezMinMax(double[] pole){
        double bezMinMax[] = new double[pole.length-2];
        double nejrychlejsiCas = Double.MAX_VALUE;
        double nejpomalejsiCas = Double.MIN_VALUE;
        double nejrychlejsiID = -1;
        double nejpomalejsiID = -1;
       
        for(int i = 0; i < pole.length;i++){
            if(pole[i] > nejpomalejsiCas){
                nejpomalejsiCas = pole[i];
                nejpomalejsiID = i;
            }else if(pole[i] < nejrychlejsiCas){
                nejrychlejsiCas = pole[i];
                nejrychlejsiID = i;
        }
        }
        int offset = 0;
            for(int i=0; i<pole.length;i++){
                if (i == nejrychlejsiID||i==nejpomalejsiID) {
                    offset++;
                    continue;
                }
                bezMinMax[i-offset] = pole[i];
            }
        return bezMinMax;
    }
    private static double ZiskejPrumer(double[] casy){
        double sumCasu = 0;
        for(int i = 0; i < casy.length; i++){
                sumCasu += casy[i];
        }
        return (sumCasu/(casy.length))/VZDALENOST;
    }
    
    
    private static void Output(double[] casy, double prumer){
        System.out.print("{");
        for(int i = 0; i < casy.length; i++){
            System.out.print(casy[i]);
            if(i != casy.length -1){
                System.out.print(",");
            }
        }
        //bohužel si nepamatuju format na 2 decimální čísla
        int desetinnyPrumer =(int) (prumer * 100); 
        System.out.println("}");
        System.out.format("Průměrně 1km uběhli za : " + (desetinnyPrumer/100f) + " min" );
    }
}
