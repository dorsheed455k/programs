import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PEG {

    static char[][] a = new char[7][8];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 7; i++) {
            a[i] = in.readLine().toCharArray();
        }
        legalMoves();
    }

    public static void legalMoves() {
        int ret = 0;
        for (int r = 0; r < 7; r++) {
            for (int c = 0; c < 7; c++) {
                if( r+2 <  7 && a[r][c] == 'o' && a[r+1][c] == 'o' && a[r+2][c] == '.' ) ret++;
                if( r-2 >= 0 && a[r][c] == 'o' && a[r-1][c] == 'o' && a[r-2][c] == '.' ) ret++;
                if( c+2 <  7 && a[r][c] == 'o' && a[r][c+1] == 'o' && a[r][c+2] == '.' ) ret++;
                if( c-2 >= 0 && a[r][c] == 'o' && a[r][c-1] == 'o' && a[r][c-2] == '.' ) ret++;
            }
        }
        System.out.println(ret);
    }
}
