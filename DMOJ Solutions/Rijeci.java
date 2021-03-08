import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rijeci {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int a = 1, b = 0;
        int n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; i++) {
            int pa = a, pb = b;
            a = pb;
            b = pa + pb;
        }

        System.out.println(a + " " + b);
    }
}
