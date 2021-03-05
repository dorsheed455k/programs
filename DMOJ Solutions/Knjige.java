import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knjige {

    static int[] a = new int[1000001];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; i++) {
            a[i+1] = Integer.parseInt(in.readLine());
        }
        int last = n;
        for (int j = n-1; j >= 0; j--) {
            if (a[j] == last) {
                last--;
            }
        }

        System.out.println(last);

    }
}
