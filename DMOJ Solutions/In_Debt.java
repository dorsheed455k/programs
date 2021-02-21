import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class In_Debt {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, a = 0, b = 0;

        n = Integer.parseInt(in.readLine());

        int debt = 0;
        int i = 0;
        while (n-- > 0) {
            String[] ln = in.readLine().split(" ");
            String x = ln[0];
            int p = Integer.parseInt(ln[1]);
            if(x.equals("borrow")) {
                debt -= p;
            } else {
                debt += p;
            }
            if (-debt > a) {
                a = -debt;
                b = i + 1;
            }
            i++;
        }
        System.out.println(b);
    }
}
