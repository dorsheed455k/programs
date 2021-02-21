import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Puzzel {

    static char[][] a = new char[4][5];
    static String[][] b = new String[4][5];

    public static void main(String[] args) throws IOException {
        b[0] = "ABCD".split("");
        b[1] = "EFGH".split("");
        b[2] = "IJKL".split("");
        b[3] = "MNO#".split("");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            a[i] = in.readLine().toCharArray();
        }

        int r = 0;
        for( int r1 = 0; r1 < 4; ++r1 ) {
           for(int s1 = 0; s1 < 4; ++s1) {
              for(int r2 = 0; r2 < 4; ++r2) {
                 for (int s2 = 0; s2 < 4; ++s2) {
                     if(a[r1][s1] == b[r2][s2].charAt(0)) {
                         r += Math.abs(r2 - r1) + Math.abs(s2 - s1);
                     }
                 }
              }
           }
        }

        System.out.println(r);
    }
}
