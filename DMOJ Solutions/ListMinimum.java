import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

   public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        Integer[] a = new Integer[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(in.readLine());

        }
        Arrays.sort(a);
        for (int value : a) {
            System.out.println(value);
        }

    }
}
