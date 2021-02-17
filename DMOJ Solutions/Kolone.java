import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Krolone {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        char[] k1 = new char[31];
        char[] k2 = new char[31];
        char[] rez = new char[61];

        int n1, n2, t, P, i;

        String[] line = in.readLine().split(" ");

        n1 = Integer.parseInt(line[0]);
        n2 = Integer.parseInt(line[1]);

        k1 = in.readLine().toCharArray();
        k2 = in.readLine().toCharArray();

        t = Integer.parseInt(in.readLine());

        for (i = 0; i < n1; i++) {
            P = n1 - i - 1;
            P += Math.min(Math.max(t - i, 0), n2);
            rez[P] = k1[i];
        }

        for (i = 0; i < n2; i++) {
            P = n1 + i;
            P -= Math.min(Math.max(t - i, 0), n1);
            rez[P] = k2[i];
        }

        for (int j = 0; j < n1 + n2; j++) {
            System.out.print(rez[j]);
        }
    }
}
