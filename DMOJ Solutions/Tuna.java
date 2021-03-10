import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tuna {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int x = Integer.parseInt(in.readLine());

        int c = 0;
        for (int i = 0; i < n; i++) {
            int p1, p2;
            String[] ln = in.readLine().split(" ");
            p1 = Integer.parseInt(ln[0]);
            p2 = Integer.parseInt(ln[1]);
            if (Math.abs(p1 - p2) <= x) {
                c += Math.max(p1, p2);
            } else {
                c += Integer.parseInt(in.readLine());
            }
        }
        System.out.println(c);
    }
}
