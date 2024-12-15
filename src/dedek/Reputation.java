
package dedek;

import java.util.Scanner;

/**
 *
 * @author Dedek-J-89cc
 */
public class Reputation {
    public static void main(String[] args) {
        //0 3 -5 2 0 4 -3 5 0
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadejte počet uživatelů:");
        int pocetUziv = sc.nextInt();
        
        int[] hodnoceni = new int[pocetUziv*pocetUziv]; //JV je nejaky konkretni duvod, proc jste zvolil jednorozmerne pole, zbytecne tezko by se Vam zistovali napr pratelske dvojice
        double[] prumery = new double[pocetUziv];
        int sum = 0;
        int index = 0;
        
        System.out.println("Zadejte hodnotici matici:");
        for (int i = 0; i < hodnoceni.length; i++) {
            hodnoceni[i] = sc.nextInt();            
        }
        
        System.out.println("Zarovnaný výpis:");
        for (int i = 0; i < hodnoceni.length; i++) {
            
            System.out.format("%2d ",hodnoceni[i]);
            
            if((i+1) % pocetUziv == 0)
            {
                System.out.println("");
            }
        }

        
        for (int i = 0; i < hodnoceni.length; i += pocetUziv) {
            for (int j = i; j < i+pocetUziv ; j++) {
                sum = sum + hodnoceni[j];
            }
            
            prumery[index] = (double)sum/(pocetUziv-1);
            sum = 0;
            index++;
        }
        
        System.out.println("Průměrné reputace");
        for (int i = 0; i < prumery.length; i++) {
            System.out.format("Uživatel %d: %.2f\n",(i+1),prumery[i]);            
        }
        
        
        int[] poleKontroverze = kontroverzni(hodnoceni, pocetUziv);        
        System.out.format("Nejvíce kontroverzní je uživatel %d. Má rozdíl %d.\n",(poleKontroverze[0]+1),poleKontroverze[1]);
        
    }
    
    public static int[] kontroverzni(int[] a, int pocetUziv)
    {
        int uzivatel = -1;
        int absMax = 0;
        int abs = 0;
        
        int[] vysledek = new int[2];
        
        for (int i = 0; i < a.length; i += pocetUziv) {
            abs = 0;
            for (int j = i; j < i+pocetUziv ; j++) {
                abs = abs + Math.abs(a[j]); //JV proc jste pocital absolutni hodnoty 3, 5 je rozdil 2 a -3 5 je rozdil 8
            }
            
            if(abs > absMax)
            {
                absMax = abs;
                uzivatel = i;
                
                vysledek[0] = uzivatel;
                vysledek[1] = absMax;
            }
            
            
        }
                
        
        return vysledek;
    }
    
    //JV chybi pratelske dvojice
    //JV chybi pozitivita
}
