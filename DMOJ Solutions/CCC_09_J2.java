import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int f1 = Integer.parseInt(in.readLine());
        int f2 = Integer.parseInt(in.readLine());
        int f3 = Integer.parseInt(in.readLine());
        int t = Integer.parseInt(in.readLine());

        catches(f1, f2, f3, t);
    }

    public static void catches(int f1, int f2, int f3, int total) {
        int c1, c2, c3;
        int c = 0;
        for (int i = 0; i <= total / f3; i++) {
            c1 = i * f3;
            for (int j = 0; j <= total / f2; j++) {
                c2 = j * f2;
                for (int k = 0; k <= total / f1; k++) {
                    c3 = k * f1;
                    int sum = c1 + c2 + c3;
                    if(sum <= total && sum != 0) {
                        c++;
                        System.out.printf("%d Brown Trout, %d Northern Pike, %d Yellow Pickerel\n", k, j, i);
                    }
                }
            }
        }
        System.out.println("Number of ways to catch fish: " + c);
    }
}
