import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kino {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String s = in.readLine();
        int l = 0;
        int c = n+1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') {
                l++;
            }
        }
        c -= l/2;
        System.out.println(Math.min(c, n));
    }
}
