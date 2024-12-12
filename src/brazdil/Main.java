/**
 * 
 *
 * @author Brazdil Lukas
 */

package brazdil;

import java.util.Scanner;

public class Main { 
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.print("[1] Average5K\r\n[2] Reputation\r\n");
        switch (sc.nextInt()) {
            case 1:
                Average5K.repeat();
                break;
            case 2:
                Reputation.run();
                break;
        }
    }
}
