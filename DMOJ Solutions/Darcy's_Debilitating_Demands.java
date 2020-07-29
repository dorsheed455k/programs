import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, a, b, c;
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());
        int[] arr = new int[3];
        while (t-- > 0) {
            n = Integer.parseInt(in.readLine());
            arr[0] = Integer.parseInt(in.readLine());
            arr[1] = Integer.parseInt(in.readLine());
            arr[2] = Integer.parseInt(in.readLine());
            solveProblem(n, arr);
        }
    }

    static void solveProblem(int n, int[] arr) {

        int[] ans = new int[3];
        for (int i = 2; i >= 0 ; i--) {
            int sub = Math.min(n, arr[i]);
            ans[i] = sub;
            n -= sub;
        }

        if(n != 0) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < 3; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
