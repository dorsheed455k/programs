import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Big_Clock {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int h, m, n;

        String[] ln = in.readLine().split(" ");

        h = Integer.parseInt(ln[0]);
        m = Integer.parseInt(ln[1]);
        n = Integer.parseInt(in.readLine());

        h += n/60;
        h %= 24;
        m += n%60;
        if (m >= 60) {
            m -= 60;
            h++;
            h %= 24;
        }
        System.out.println(h + " " + m);
    }
}
