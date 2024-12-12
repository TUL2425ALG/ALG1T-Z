/**
 *
 * @author Brazdil-L-e065
 */

package brazdil;

import java.util.Vector;

public class Reputation {
    
    //TEST
    // 3 0 3 -5 2 0 4 -3 5 0
    
    /**
     * CLASS ENTRY POINT
     */
    public static void run() {
        
        // Create matrix
        System.out.print("Zadejte počet uživatelů:\r\n");
        int ucnt = Main.sc.nextInt();
        int[][] rank = new int[ucnt][ucnt];
        
        // Feed data
        System.out.print("Zadejte hodnotící matici:\r\n");
        for (int r = 0; r < ucnt; r++) {
            for (int c = 0; c < ucnt; c++) {
                rank[r][c] = Main.sc.nextInt();
            }
        }
        
        // Display matrix
        for (int r = 0; r < ucnt; r++) {
            for (int c = 0; c < ucnt; c++) {
                System.out.print(String.format("%3d", rank[r][c])); // 1 space, 1 sign, 1 value
            }
            System.out.print("\r\n");
        }
        
        // Dump user rep
        System.out.print("Průměrné reputace:\r\n");
        float sum = 0;
        for (int u = 0; u < ucnt; u++) {
            // Rank of one user
            for (int pos = 0; pos < ucnt; pos++) {
                sum = sum + (float)rank[u][pos];
            }
            System.out.print(String.format("Uživatel %d: %.2f\r\n", (u + 1), (sum/(ucnt-1)))); // average -> sum / user count without currently processed user
            sum = 0;
        }
        
        // Most controversal user
        con controversal = getContr(rank, ucnt);
        System.out.print(String.format("Nejvíce kontroverzní uživatel je %d. Má rozdíl %.2f.\r\n", controversal.id+1, controversal.diff));
        
        // Friendly users
        System.out.print("Přátelské dvojice:\r\n");
        for (int u1 = 0; u1 < ucnt; u1++) {
            for (int u2 = 0; u2 < ucnt; u2++) {
                if (rank[u1][u2] > 0 && rank[u2][u1] > 0 && u1 < u2) { // u1 < u2 : This is so dumb.
                    System.out.print((u1+1)+", "+(u2+1)+"\r\n");
                }
            }
        }
        
        // Platform mood
        if (isPositive(rank, ucnt)) {
            System.out.print("Platforma je positivní.\r\n");
        }
    }
    
    /**
     * 
     * @param val data
     * @param ucnt user count (matrix size)
     * @return true if all users have at least one ranking > 0.
     */
    private static boolean isPositive(int[][] val, int ucnt) {
        boolean uHasRank = false; // user has one rank > 0
        for (int u = 0; u < ucnt; u++) { // user
            for (int r = 0; r < ucnt; r++) { // rank
                if (val[u][r] > 0) {
                    uHasRank = true;
                }
            }
            // Current user is ok, we have reason to proceed to the next
            if (!uHasRank) {
                return(false);
            }
        }
        // All users have at least one rank > 0
        return(true);
    }
    
    /**
     * 
     * @param data data
     * @param ucnt user count
     * @return user node with biggest difference in rankings.
     */
    private static con getContr(int [][] data, int ucnt) {
        Vector<con> db = new Vector<con>(); // V přednáškové presentaci ArrayList byl.
        for (int i = 0; i < ucnt; i++) {
            con usr = new con();
            usr.id = i;
            int min = 0;
            int max = 0;
            for (int val = 0; val < ucnt; val++) {
                if (data[i][val] > max) {
                    max = data[i][val];
                }
                if (data[i][val] < min) {
                    min = data[i][val];
                }
            }
            usr.diff = max - min;
            db.add(usr);
        }
        float minDiff = db.elementAt(1).diff;
        int idx = 0;
        for (con c : db) {
            if (c.diff > minDiff) {
                minDiff = c.diff;
                idx = c.id;
            }
        }
        return db.elementAt(idx);
    }
    // Holder for user when estimating biggest difference.
    private static class con {
        int id = -1;
        float diff = 0;
    }
}
