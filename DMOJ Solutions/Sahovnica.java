import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sahovnica {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int r, c, a, b;

        String[] l1 = in.readLine().split(" ");
        String[] l2 = in.readLine().split(" ");
        r = Integer.parseInt(l1[0]);
        c = Integer.parseInt(l1[1]);

        a = Integer.parseInt(l2[0]);
        b = Integer.parseInt(l2[1]);

        for (int i = 0; i < r*a; i++) {
            for (int j = 0; j < c*b; j++) {
                System.out.print((i / a + j / b) % 2 == 0? 'X' : '.');
            }
            System.out.println();
        }
    }
}
