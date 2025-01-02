/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zakouril;

import java.util.Scanner;

/**
 *
 * @author Zakouril-S-5355
 */
public class Average5K {
    final static int CELKOVA_VZDALENOST = 5;
    public static void main(String[] args) {
        //testy: pocetBehu: 10, casyBehu: 22,6 21,8 20,03 24,5 21,8 28,4 22,5 23,9 22,9 21,5
        //testy: pocetBehu: 5, casyBehu: 22,6 21,8 20,03 24,5 21,8
        //testy: pocetBehu: 5, casyBehu: 10 10 11 12 12
           while(true){         
            Scanner sc = new Scanner(System.in);
            System.out.println("Zadejte počet běhů");
            int _pocetBehu = sc.nextInt();
            if (_pocetBehu <= 0) {
                break;
            }
            double[] _casyBehu = new double[_pocetBehu];
            System.out.println("Zadejte časy běhů");
            for (int i = 0; i < _casyBehu.length; i++) {
                _casyBehu[i] = sc.nextDouble();
            }
            
            
            
            vypoctiPrumer(_casyBehu);
            System.out.println(" ");
           }
           
    }
    public static void vypoctiPrumer(double[] casyBehu){
        int fastestId = 0; 
        int slowestId = 0; 
        double fastestTime = 100000; // max int, ale nevim syntaxi //JV Integer.MAX_VALUE
        double slowestTime = 0;
        double soucetPrumeru = 0;
        //projedu forem a u kazdeho behu vydelim 5 abych ziskal prumer na km, do celkoveho vypoctu ale nebudu davat id slowest a fastest a vsechny je sectu a potom vydelim array length - 2 
        for (int i = 0; i < casyBehu.length; i++) {
            if (casyBehu[i] < fastestTime) {
                fastestTime = casyBehu[i];
                fastestId = i;
            }
            if (casyBehu[i] > slowestTime) {
                slowestTime = casyBehu[i];
                slowestId = i;
            }
        }
        for (int i = 0; i < casyBehu.length; i++) {
            if (i != slowestId && i != fastestId) { //JV bylo by optimalnejsi secíst vsechny casy a pak odecist 2 casy 
                soucetPrumeru += (casyBehu[i] / CELKOVA_VZDALENOST); //JV tady taky by stačilo delit jenom jednou na zaver
            }
        }
        
        //vypis pouzitych hodnot
        System.out.println("Použité hodnoty pro výpočet:");
            System.out.print("{");
            for (int i = 0; i < casyBehu.length; i++) {
                if (i != slowestId && i != fastestId) { 
                System.out.print(casyBehu[i] + ","); //mohl jsem udelat podminku ktera by vzdy kontrolovala jestli to nahodou neni posledni prvek, a u nej nevypisovat carku, ale potom by to nebylo vubec optimalizovane
                } //JV posledni prvek by jste idealne mohl vypisovat mimo for
            }
            System.out.format("} %n");
        
        
        
        //System.out.println("Soucet prumeru" + soucetPrumeru); // v metode nikdy nedavat print, ale je to jenom testovani
        double prumerNaKmFinalni = (soucetPrumeru / (casyBehu.length - 2));
        System.out.format("Průměrně jste 1km uběhl za %.2f minut",prumerNaKmFinalni); //vim ze d je decimal a f je float, ale nemuzu si vzpomenout jak presne se pise to zaokrouhlovani
        
        //vytvoreni pole ktere vratime: bude ve formatu: id_slowest, id_fastest,  tak, abych vedel ktere casy se nepouzili plus aby mi vratil prumerny cas
    }
    
    //JV co se tyka struktury, byla by zajimava metoda, ktere byste dal pole a ona vratila prumer 
}
