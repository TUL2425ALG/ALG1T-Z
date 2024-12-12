package stastny;

import java.util.Scanner;

/**
 * Zápočtová prace
 * Hodnoceni uzivatelu na platforme
 * @author Patrik Stastny
 * @version 1.0 12/12/2024
 */
public class Reputation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Zadejte pocet uzivatelu: ");
        int uzivatele = sc.nextInt();
        for (int i = 0; i < uzivatele + 1; i++) {
            System.out.println("Zadejte hodnotici matici: ");
            int hodnoticimatice = sc.nextInt();
            int zarovnanyvypis = 0;
            System.out.println("zarovnany vypis: " + zarovnanyvypis);
        }
        System.out.println("prumerna reputace: ");
        int hodnoceni = 0;
        for (int i = 0; i < uzivatele; i++) {
            System.out.println("Uzivatel" + i + ": " + hodnoceni);
        }

    }
}
