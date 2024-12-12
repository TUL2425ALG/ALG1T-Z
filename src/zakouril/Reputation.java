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
public class Reputation {
    public static void main(String[] args) {
        //testy: 3 lidi, matice:  0 3 -5 2 0 4 -3 5 0
        //testy: 3 lidi, matice: 0 -3 -5 2 0 4 -3 5 0
        Scanner sc = new Scanner(System.in);
        int _pocetUzivatelu = 0;
        System.out.println("Zadejte počet uživatelů");
        _pocetUzivatelu = sc.nextInt();
        System.out.println("Zadejte hodnotící matici");
        int[][] hodnoceni = new int[_pocetUzivatelu][_pocetUzivatelu];
        for (int i = 0; i < hodnoceni.length; i++) {
            for (int j = 0; j < hodnoceni[0].length; j++) {
                hodnoceni[i][j] = sc.nextInt();
            }
        }
        System.out.println("Zarovnaný výpis");
        for (int i = 0; i < hodnoceni.length; i++) {
            for (int j = 0; j < hodnoceni[0].length; j++) {
                //(hodnoceni[i][j] < 0)? System.out.print(hodnoceni[i][j] + " ") : System.out.print(" " +hodnoceni[i][j] + " ");
                if(hodnoceni[i][j] < 0) {
                    System.out.print(hodnoceni[i][j] + " ");
                }
                else{
                    System.out.print(" " +hodnoceni[i][j] + " ");
                }
            }
            System.out.println(" ");
        }
        System.out.println("Průměrné reputace:");
        for (int i = 0; i < hodnoceni.length; i++) {
            double _prumernaReputace = 0; //vim ze muze byt int, ale potom mam operaci tohle/int, a nechtelo se mi pretypovavat (double) pred samotnou operaci
            for (int j = 0; j < hodnoceni[0].length; j++) {
                _prumernaReputace += hodnoceni[i][j];
            }
            System.out.format("Uživatel %d : %.2f %n", (i + 1), (_prumernaReputace/(hodnoceni.length-1)));
        }
        System.out.println(" ");
        int[] nalezenaKontroverze = najdiKontroverzi(hodnoceni);
        
        int nejvicKontroverzniId = 0;
        int nejvetsiRozdil = 0;
        for (int i = 0; i < nalezenaKontroverze.length; i++) {
            if (nalezenaKontroverze[i] > nejvetsiRozdil) {
                //kdybychom v teto podmince meli vetsi rovno, bralo by to naopak posledniho uzivatele ktery ma stejny nebo vetsi rozdil
                nejvetsiRozdil = nalezenaKontroverze[i];
                nejvicKontroverzniId = i;
            }
        }
        System.out.format("Nejvíce kontroverzní uživatel je %d. Má rozdíl %d. %n", (nejvicKontroverzniId + 1), nejvetsiRozdil);
        System.out.println(" ");
        System.out.println("Přátelské dvojice: ");
        //je potreba je delat prohozenim i a j - tenhle pattern je uplne vsude
        for (int i = 0; i < hodnoceni.length; i++) {
            for (int j = 0; j < hodnoceni[0].length; j++) {
                if (hodnoceni[i][j] > 0 && hodnoceni[j][i] > 0) {
                    System.out.format("Dvojice: %d a %d jsou kamarádi %n", (i+1),(j+1));
                }
            }
        }
        String _vyhodnoceniPozitivity =(jePlatformaPozitivni(hodnoceni))? "Platforma je pozitivní." : "Platforma není pozitivní.";
        System.out.println(_vyhodnoceniPozitivity);

    }
    public static int[] najdiKontroverzi(int[][] uzivatele)
    {
        int[] poleRozdilu = new int[uzivatele.length];
        for (int i = 0; i < uzivatele.length; i++) {
            int nejmensiHodnota = 100000; //spravne by melo byt maxint, ale nevim jak se presne pise
            int nejvetsiHodnota = 0;
            for (int j = 0; j < uzivatele[0].length; j++) {
                if (uzivatele[i][j] < nejmensiHodnota) {
                    nejmensiHodnota = uzivatele[i][j];
                }
                if (uzivatele[i][j] > nejvetsiHodnota) {
                    nejvetsiHodnota = uzivatele[i][j];
                }
            }
            poleRozdilu[i] = Math.abs(nejvetsiHodnota - nejmensiHodnota);
        }
        return poleRozdilu;
    }
    public static boolean jePlatformaPozitivni(int[][] uzivatele)
    {
        for (int i = 0; i < uzivatele.length; i++) {
            int pocetKladnychHodnoceni = 0;
            for (int j = 0; j < uzivatele[0].length; j++) {
                if (uzivatele[i][j] > 0) {
                    pocetKladnychHodnoceni += 1; //ano, dalo by se to jednoduse optimalizovat protoze kdyz uz je to vice jak 1, tak neni potreba kontrolovat dalsi, ale dnes jsem naspal 3 a pul hodiny a uz mi to nemysli
                }
            }
            if(pocetKladnychHodnoceni == 0) {
                return false;
            }
        }
        return true;
    }
}
