import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Magija {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        char[][] arr = new char[201][201];
        int r, c, a, b;


        String[] line = in.readLine().split(" ");

        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);

        for (int i = 0; i < r; i++) {
            String[] ln = in.readLine().split("");
            for (int j = 0; j < c; j++) {
                arr[i][j] = ln[j].charAt(0);
                arr[2*r-i-1][j] = arr[i][j];
                arr[i][2*c-j-1] = arr[i][j];
                arr[2*r-i-1][2*c-j-1] = arr[i][j];
            }
        }

        String[] ll = in.readLine().split(" ");
        a = Integer.parseInt(ll[0]);
        b = Integer.parseInt(ll[1]);

        arr[a-1][b-1] = arr[a-1][b-1] == '#' ? '.' : '#';

        for (int i = 0; i < 2*r; i++) {
            for (int j = 0; j < 2*c; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
