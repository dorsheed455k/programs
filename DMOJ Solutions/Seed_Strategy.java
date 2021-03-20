import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Seed_Strategy {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, k, t;
        int ans = 0;
        n = Integer.parseInt(in.readLine());
        k = Integer.parseInt(in.readLine());

        for (int i = 0; i < k; i++) {
            t = Integer.parseInt(in.readLine());
            if (t == 1) {
                ans += 30;
            } else if(t == 2) {
                ans += 60;
            } else if(t == 3) {
                ans += 300;
            }
        }
        n = n * 60;
        if (ans <= n) {
            System.out.println("Continue");
        } else {
            System.out.println("Return");
        }
    }
}
