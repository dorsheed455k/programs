import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parket {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int e, m;
        String[] ln = in.readLine().split(" ");

        e = Integer.parseInt(ln[0]);
        m = Integer.parseInt(ln[1]);
        for (int i = 3; i < 5000; i++) {
            for (int j = i; j >= 3 ; j--) {
                if (e+m == i * j && e == 2*i + 2*j-4) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }
}
