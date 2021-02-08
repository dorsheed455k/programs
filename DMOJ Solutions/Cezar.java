import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cezar {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n;
        int[] arr = new int[100];

        int s = 0, x, k;

        n = Integer.parseInt(in.readLine());

        for (int i = 2; i <= 11 ; i++) {
            arr[i] = 4;
        }
        arr[10] = 4 * 4;

        for (int i = 0; i < n; i++) {
            k = Integer.parseInt(in.readLine());
            arr[k]--;
            s += k;
        }

        x = 21 - s;

        int v = 0;
        for (int i = x + 1; i <= 11; i++) {
            v += arr[i];
        }

        if(52 - n - v > v) {
            System.out.println("VUCI");
        } else {
            System.out.println("DOSTA");
        }

    }
}
