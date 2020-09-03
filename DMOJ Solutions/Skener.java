import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Skener {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int r, c, zr, zc;

        String[] str = in.readLine().split(" ");
        r = Integer.parseInt(str[0]);
        c = Integer.parseInt(str[1]);
        zr = Integer.parseInt(str[2]);
        zc = Integer.parseInt(str[3]);

        String[] arr = new String[r];
        for (int i = 0; i < r; i++) {
             String st = in.readLine();
             arr[i] = st;
        }

        for (int i = 0; i < r; i++) {
            String line = "";
            for (int j = 0; j < c; j++) {
                for (int l = 0; l < zc; l++) {
                    line += arr[i].charAt(j);
                }
            }
            for (int j = 0; j < zr; j++) {
                System.out.println(line);
            }
        }

    }
}
