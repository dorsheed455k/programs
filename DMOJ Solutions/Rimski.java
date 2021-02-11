import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rimiski {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] p = new int[255];
        char[] st = new char[35];

        String num = in.readLine();
        for (int i = 0; i < num.length(); i++) {
            st[i] = num.charAt(i);
        }

        for (int i = 0; st[i] != 0; i++) {
            p[(int) st[i]]++;
        }

        if (p['C'] == 1) {
            System.out.print("XC");
            p['C']--;
            p['X']--;
        }
        if (p['L'] == 1) {
            if (p['X'] == 1 || (p['X'] == 2 && p['I'] == 1 && p['V'] == 0)) {
                System.out.print("X");
                p['X']--;
            }
            System.out.print("L");
            p['L']--;
        }

        while (p['X'] > 1) {
            System.out.print("X");
            p['X']--;
        }
        if (p['X'] == 1 && p['V'] == 0 && p['I'] == 1) {
            System.out.print("IX");
            p['X']--;
            p['I']--;
        }
        if (p['X'] == 1) {
            System.out.print("X");
            p['X']--;
        }
        if( p['I'] == 1 && p[ 'V' ] == 1 ) {
            System.out.print( "I" ); p['I']--;
        }
        if( p['V'] == 1 ) {
            System.out.print( "V" ); p['V']--;
        }

        while( p['I'] > 0 ) {
            System.out.print("I"); p['I']--; 
        }
        System.out.println();
    }
}
