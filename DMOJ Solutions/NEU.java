import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NEU {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, k, d;

        n = Integer.parseInt(in.readLine());
        k = Integer.parseInt(in.readLine());
        d = Integer.parseInt(in.readLine());

        int sumUsers = n;

        for (int i = 1; i <= d; i++) {
            sumUsers = sumUsers*k;
        }

        System.out.println(sumUsers);
        
    }
}
