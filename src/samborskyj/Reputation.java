/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package samborskyj;

import java.util.Scanner;

/**
 * 3
 * 0 3 -5 2 0 4 -3 5 0
 *
 * @author Samborskyj-N-daef
 */
public class Reputation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pocet_uzivatelu;
        int[][] hodnoceni_uzivatelu;
        double prumerna_reputace;
        System.out.println("Zadejte počet uživatelů");
        pocet_uzivatelu = sc.nextInt();
        hodnoceni_uzivatelu = new int[pocet_uzivatelu][pocet_uzivatelu];
        System.out.println("Zadejte hodnotící matici");
        //Naplneni + vypis matice
        for (int i = 0; i < pocet_uzivatelu; i++) {
            for (int j = 0; j < pocet_uzivatelu; j++) {
                hodnoceni_uzivatelu[i][j] = sc.nextInt();
                if (hodnoceni_uzivatelu[i][j] >= 0) {
                    System.out.print(" " + hodnoceni_uzivatelu[i][j] + " ");
                } else {
                    System.out.print(hodnoceni_uzivatelu[i][j] + " ");
                }
            }
            System.out.println("");
        }
        System.out.println("Průměrné reputace:");
        //Prumerna reputace
        for (int i = 1; i <= hodnoceni_uzivatelu.length; i++) {
            prumerna_reputace = 0;
            for (int j = 0; j < hodnoceni_uzivatelu.length; j++) {
                prumerna_reputace += hodnoceni_uzivatelu[i - 1][j];
            }
            prumerna_reputace /= pocet_uzivatelu - 1;
            System.out.println("Uživatel " + i + ": " + prumerna_reputace);
        }
        
        NejviceKontroverzni(hodnoceni_uzivatelu);
        /* Nestihl jsem
        System.out.println("Přatelské dvojice:");
        
        for (int i = 0; i < hodnoceni_uzivatelu.length*hodnoceni_uzivatelu.length; i++) {
            for (int j = 0; j < hodnoceni_uzivatelu.length; j++) {
                if(hodnoceni_uzivatelu[i][i+j] > 0){
                    
                }                
            }
        }
        */
        
        if(PozitivniPlatforma(hodnoceni_uzivatelu)) System.out.println("Platforma je pozitivní.");
        else System.out.println("Platforma není pozitivní.");
    }

    public static void NejviceKontroverzni(int[][] hodnoceni_uzivatelu) {
        int nejnizsi_hodnoceni;
        int nejvyssi_hodnoceni;
        int kontroverzni_uzivatel_rozdil = 0;
        int kontroverzni_uzivatel = 0;
        for (int i = 1; i <= hodnoceni_uzivatelu.length; i++) {
            nejvyssi_hodnoceni = 0;
            nejnizsi_hodnoceni = 0;
            for (int j = 0; j < hodnoceni_uzivatelu.length; j++) {
                if (hodnoceni_uzivatelu[i - 1][j] > nejvyssi_hodnoceni) {
                    nejvyssi_hodnoceni = hodnoceni_uzivatelu[i - 1][j];
                }
                if (hodnoceni_uzivatelu[i - 1][j] < nejnizsi_hodnoceni) {
                    nejnizsi_hodnoceni = hodnoceni_uzivatelu[i - 1][j];
                }
            }
            if (nejvyssi_hodnoceni - nejnizsi_hodnoceni > kontroverzni_uzivatel_rozdil) {
                kontroverzni_uzivatel_rozdil = nejvyssi_hodnoceni - nejnizsi_hodnoceni;
                kontroverzni_uzivatel = i;
            }
        }
        System.out.println("Nejvíce kontroverzní uživatel je " + kontroverzni_uzivatel + ". Má rozdíl " + kontroverzni_uzivatel_rozdil + ".");
    }
    public static boolean PozitivniPlatforma(int[][] matice){
        boolean kladne_hodnoceni;
        for (int i = 0; i < matice.length; i++) {
            kladne_hodnoceni = false;
            for (int j = 0; j < matice.length; j++) {
                if(matice[i][j] > 0){
                    kladne_hodnoceni = true;
                    //Pokud byla nalezena alespon jedna kladna hodnota, jdeme na dalsiho uzivatele
                    break;
                }
            }
            if(kladne_hodnoceni == false) return false; 
        }
        return true;
    }
}
