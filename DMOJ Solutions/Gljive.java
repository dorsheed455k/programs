import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gljive {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int s = 0;
        for (int i = 0; i < 10; i++) {
            int x = Integer.parseInt(in.readLine());

            if(s+x >= 100) {
                if (s+x-100 <= 100-s) s += x;
                System.out.println(s);
                return;
            }
            s += x;
        }
        System.out.println(s);
    }
}
