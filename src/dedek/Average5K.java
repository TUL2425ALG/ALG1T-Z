
package dedek;

import java.util.Locale;
import java.util.Scanner;
import javax.security.auth.Subject;

/**
 *
 * @author Dedek-J-89cc
 */
public class Average5K {
    public static void main(String[] args) {
        //22.6 21.8 20.03 24.5 21.8 28.4 22.5 23.9 22.9 21.5
        Scanner sc = new Scanner(System.in);
        sc.useLocale(new Locale("en","US"));
                
        System.out.println("Zadejte počet běhů:");
        int pocetBehu = sc.nextInt();
        while(pocetBehu > 0)
        {
            double casMin = Double.MAX_VALUE;
            double casMax = 0;
            int indexMin = -1;
            int indexMax = -1;
            double sumPole = 0;
            double prumer = 0;
            final int TRASA = 5;
                        

            double[] casy = new double[pocetBehu];

            System.out.println("Zadejte časy běhů:");
            for (int i = 0; i < casy.length; i++) {
                casy[i] = sc.nextDouble();            
            }



            for (int i = 0; i < casy.length; i++) {
                if(casy[i] < casMin)
                {
                    casMin = casy[i];
                    indexMin = i;
                }

                if(casy[i] > casMax)
                {
                    casMax = casy[i];
                    indexMax = i;
                }


            }

            System.out.println("Použité hodnoty pro výpočet:");
            System.out.print("{");        
            for (int i = 0; i < casy.length; i++) {

                if(i == indexMin || i == indexMax)
                {
                    continue;
                }
                else
                {
                    System.out.print(casy[i]);
                    sumPole = sumPole + casy[i];
                }

                if(i != casy.length-1)
                {
                    System.out.print(",");
                }
            }
            System.out.println("}");


            //vypocet prumeru
            prumer = (sumPole/TRASA)/(casy.length-2);
            System.out.format("Průměrně jste 1 km ubehl za %.2f min.\n",prumer); //vypisuje se s , a nevim proc
            
            System.out.println("Zadejte počet běhů:");
            pocetBehu = sc.nextInt();
        }
        
    }
}
