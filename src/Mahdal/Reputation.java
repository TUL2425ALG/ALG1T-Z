/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mahdal;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Mahdal-R-62fb
 */
//        int[][] ratings = {{0, 3, -5},
//        {2, 0, 4},
//        {-3, 5, 0}};      0 3 -5 2 0 4 -3 5 0
//
//      0 3 5 -9            0 3 5 -9 5 0 -2 4 -5 7 0 4 4 -5 8 0
//      5 0 -2 4
//`     -5 7 0 4
//      4 -5 8 0
public class Reputation {

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej pocet uzivatelu:");
        int users = sc.nextInt();
        System.out.println("Zadejte hodnotici matici:");
        int[][] ratings = new int[users][users];
        for (int i = 0; i < ratings.length; i++) {
            for (int j = 0; j < ratings.length; j++) {
                ratings[i][j] = sc.nextInt();
            }
        }

        //zarovnany vypis
        System.out.println("Zarovnany vypis:");
        for (int i = 0; i < ratings.length; i++) {
            for (int j = 0; j < ratings.length; j++) {
                if (ratings[i][j] < 0) {
                    System.out.print(" " + ratings[i][j]);
                } else {
                    System.out.print("  " + ratings[i][j]);
                }
            }
            System.out.println();
        }

        //prumerna reputace
        System.out.println("Prumerne reputace:");
        for (int i = 0; i < ratings.length; i++) {
            double avgrep = 0;
            for (int j = 0; j < ratings.length; j++) {
                avgrep = avgrep + ratings[i][j];

            }
            avgrep = avgrep / (ratings.length - 1);
            System.out.format("Uzivatel %d: %.2f\n", (i + 1), avgrep);
        }

        // kontroverzni
        int[] contr = highestDiff(ratings);
        System.out.format("Nejvice kontroverzni uzivatel je %d. Ma rozdil %d.\n", contr[0], contr[1]);

        //pratele
        System.out.println("Pratelske dvojice:");
        for (int i = 0; i < ratings.length; i++) {
            for (int j = i; j < ratings.length; j++) {
                if (ratings[i][j] > 0 && ratings[j][i] > 0) {
                    System.out.println((i + 1) + "," + (j + 1));
                }
            }
        }

        //positivita
        
        
        if (isPositive(ratings)) {
            System.out.println("Platforma je pozitivni.");
        } else {
            System.out.println("Platforma neni pozitivni.");
        }

    }

    public static boolean isPositive(int[][] matrix) {
        boolean rowPositive;
        for (int i = 0; i < matrix.length; i++) {
            rowPositive = false;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] > 0) {
                    rowPositive = true;
                }
            }
            if (rowPositive != true) {
                return false;
            }
        }
        return true;
    }

    public static int[] highestDiff(int[][] matrix) {
        int[] diffs = new int[matrix.length];
        int min;
        int max;
        int biggestDiff = -Integer.MAX_VALUE;
        int[] res = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            min = Integer.MAX_VALUE;
            max = -Integer.MAX_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] < min && matrix[i][j] != 0) {
                    min = matrix[i][j];
                }
                if (matrix[i][j] > max && matrix[i][j] != 0) {
                    max = matrix[i][j];
                }
            }
            diffs[i] = max - min;
        }
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] > biggestDiff) {
                biggestDiff = diffs[i];
                res[0] = i + 1;
                res[1] = biggestDiff;
            }

        }
        return res;
    }
}
