import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Preokret {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int a = 0, b = 0;
        int a_i = 0, b_i = 0;
        int ties = 1;
        int maxSucc = 0;
        for (int i = 0; i < n; i++) {
            int s = Integer.parseInt(in.readLine());
            if(s == 1) {
                a++;
                a_i++;
                if(a_i > maxSucc && a > b) {
                    maxSucc = a_i;
                }
                b_i = 0;
            } else {
                b++;
                b_i++;
                if(b_i > maxSucc && b > a) {
                    maxSucc = b_i;
                }
                a_i = 0;
            }

            if(a == b) {
                ties++;
            }
        }

       System.out.println(a + " " + b +
               "\n" + ties +
               "\n" + maxSucc);
    }
}
