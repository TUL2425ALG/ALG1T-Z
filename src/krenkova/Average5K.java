/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package krenkova;

import java.util.Scanner;

/**
 *
 * @author Krenkova-M-b5b4
 */
public class Average5K {
    public static void main(String[] args) {
        //10
        //22,6 21,8 20,03 24,5 21,8 28,4 22,5 23,9 22,9 21,5
        
        
        final int DISTANCE = 5;
        int runCount;
        double slowestRun = -Double.MAX_VALUE;
        double fastestRun = Double.MAX_VALUE;
        double averangeRun = 0;
        boolean continuous = true;
        
        Scanner sc = new Scanner(System.in);
        
        while(continuous)
        {
            System.out.println("Zadejte počet běhů: ");
            runCount = sc.nextInt();
            if(runCount <= 0)
            {
                continuous = false;
                break;
            }
            System.out.println("Zadejte časy běhů: ");
            double[] runTimes = new double[runCount];
            for(int i = 0; i <= runCount-1; i++)
            {
                runTimes[i] = sc.nextDouble();
            }

            for(int i = 0; i < runTimes.length; i++)
            {
                if (runTimes[i] <= fastestRun) {
                    fastestRun = runTimes[i];
                }
                if (runTimes[i] >= slowestRun)
                {
                    slowestRun = runTimes[i];   
                }
            }
            //System.out.print("pomalý"+slowestRun+ " rychly" + fastestRun );
            for(int i = 0; i < runTimes.length; i++)
            {
                if (runTimes[i] == fastestRun) {
                    runTimes[i] = 0;
                }
                if (runTimes[i] == slowestRun)
                {
                    runTimes[i] = 0;
                }
            }

            System.out.println("Použíté hodnoty pro výpočet: ");
            System.out.print("{ ");
            for(int i = 0; i < runTimes.length; i++)
            {
                if (runTimes[i] == 0) {
                    continue;
                }
                else
                {
                    System.out.print(runTimes[i] + " ");
                    runTimes[i] = runTimes[i] / DISTANCE;
                    averangeRun += runTimes[i];
                }

            }
            System.out.println("}");
            averangeRun = averangeRun / (runCount-2);

            System.out.format("Průměrně jste 1km uběhl za %.2f min.", averangeRun);
            System.out.println( );
        }
        
    }
    
    
}
