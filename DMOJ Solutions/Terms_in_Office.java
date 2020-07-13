import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TermsOffice {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(in.readLine());
        int y = Integer.parseInt(in.readLine());

        terms(x,y);
    }

    public static void terms(int x, int y) {
        int m = 0, tr = 0, p = 0, d = 0;

        for (int i = x; i <= y ; i++) {
            if(m == 0 && tr == 0 && p == 0 && d == 0) {
                System.out.printf("All positions change in year %d\n", i);
            }
            m = (m+1) % 4;
            tr= (tr+1) % 2;
            p = (p+1) % 3;
            d = (d+1) % 5;
        }
    }
}
