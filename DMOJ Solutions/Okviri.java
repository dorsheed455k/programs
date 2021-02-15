import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Okviri {

    static char[][] output = new char[5][80];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        char[] s = new char[16];

        String[] ln = in.readLine().split("");
        for (int i = 0; i < ln.length; i++) {
            s[i] = ln[i].charAt(0);
        }

        int n = ln.length;

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c <= 4*n; c++) {
                output[r][c] = '.';
            }
        }

        for (int i = 0; i < n; i++) {
            solve(s[i], 4*i+2, '#');
        }
        for (int i = 2; i < n; i+=3) {
            solve(s[i], 4*i+2, '*');
        }

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c <= 4*n; c++) {
                System.out.print(output[r][c]);
            }
            System.out.println();
        }
    }

    public static int abs(int x) {
        return x < 0? -x : x;
    }

    public static void solve(char x, int c, char y) {
        output[2][c] = x;
        for( int dr = -2; dr <= 2; ++dr ) {
            for( int dc = -2; dc <= 2; ++dc ) {
                if(abs(dr) + abs(dc) == 2) output[2+dr][c+dc] = y;
            }
        }
    }
}
