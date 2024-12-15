/**
 *
 * @author Brazdil-L-e065
 */
package brazdil;

public class Average5K {
    
    private static final int DISTANCE = 5;
    
    // TEST
    // 10 22,6 21,8 20,03 24,5 21,8 28,4 22,5 23,9 22,9 21,5
    
    /**
     * CLASS ENTRY POINT
     */
    public static void repeat() {
        while (run()) {}
    }
    
    private static boolean run() {
        System.out.print("Zadej počet běhů:\r\n");
        int pocet = Main.sc.nextInt();
        if (pocet <= 0) {
            return(false);
        }
        // Load
        System.out.print("Zadej časy běhů: \r\n");
        float[] cas = new float[pocet];
        for (int p = 0; p < pocet; p++) {
            cas[p] = Main.sc.nextFloat();
        }
        // Excude min/max
        int minIdx = 0;
        int maxIdx = 0;
        for (int sz = 1; sz < pocet; sz++) {
            if (cas[sz] > cas[maxIdx]) {
                maxIdx = sz;
            }
            if (cas[sz] < cas[minIdx]) {
                minIdx = sz;
            }
        }
        // Compute sum of times
        System.out.print("Použité hodnoty pro výpočet:\r\n");
        float sum = 0;
        int skip = 0; // What if removed value is first.
        for (int c = 0; c < pocet; c++) {
            if (c == minIdx || c == maxIdx) {
                if (c == 0) {
                    skip++; // First was skipped
                }
                // Evade min, max
                continue;
            } else {
                sum = sum + cas[c];
                // Just shitty formatting //JV trochu nedotiahnute - Skuste si test 10 20.3 28.4 22.6 21.8 24.5 21.8 22.5 23.9 22.9 21.5
                if (c == 0 || skip == 1) { // First or first was skipped
                    System.out.print("{"+cas[c]);
                } else {
                    System.out.print(", " + cas[c]);
                }
            }
        }
        System.out.print("}\r\n");
        
        // Get average time
        System.out.print(String.format("Průměrně jste 1 km uběhl za %.2f min.\r\n", sum/((pocet-2)*DISTANCE)));
        return(true);
    }
}
