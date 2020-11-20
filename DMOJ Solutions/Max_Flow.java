import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(in.readLine());
            System.out.println(findMaxFlow(n, in));
        }
    }

    public static int findMaxFlow(int n, BufferedReader in) throws IOException {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(in.readLine());
            if(a > max) {
                max = a;
            }
        }

        return max;
    }
}
