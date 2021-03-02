import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Astro {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] h_i = new int[4];
        int[] m_i = new int[4];

        for (int i = 0; i < 4; i++) {
            String[] ln = in.readLine().split(":");
            h_i[i] = Integer.parseInt(ln[0]);
            m_i[i] = Integer.parseInt(ln[1]);
        }
        int t1 = h_i[0] * 60 + m_i[0];
        int t2 = h_i[1] * 60 + m_i[1];
        int p1 = h_i[2] * 60 + m_i[2];
        int p2 = h_i[3] * 60 + m_i[3];
        boolean n = false;

        for (int i = 0; i < 10000; i++) {
            int nt = t1 + i*p1;
            if (nt < t2 || (nt - t2) % p2 != 0) {
                continue;
            }
            n = true;
            int m = nt%60; nt /= 60;
            int h = nt%24; nt /= 24;
            int d = nt%7;
            dayOfWeek(d);
            System.out.printf("%02d:%02d", h, m);
            break;
        }

        if (!n) {
            System.out.println("Never");
        }
    }

    public static void dayOfWeek(int d) {
        if (d == 0) System.out.println("Saturday");
        if (d == 1) System.out.println("Sunday");
        if (d == 2) System.out.println("Monday");
        if (d == 3) System.out.println("Tuesday");
        if (d == 4) System.out.println("Wednesday");
        if (d == 5) System.out.println("Thursday");
        if (d == 6) System.out.println("Friday");
    }
}
