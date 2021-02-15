import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Volim {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int k, n, t;
        int gl;
        char z;

        k = Integer.parseInt(in.readLine());
        n = Integer.parseInt(in.readLine());

        gl = 0;
        while (gl < 210) {
            String[] ln = in.readLine().split(" ");
            t = Integer.parseInt(ln[0]);
            z = ln[1].charAt(0);
            gl += t;
            if(z == 'T' && gl <= 210) {
                k = (k % 8) + 1;
            }
        }
        System.out.println(k);
    }
}
