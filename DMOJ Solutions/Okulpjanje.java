import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Okulpjanje {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int l, p;

        String[] l1 = in.readLine().split(" ");
        l = Integer.parseInt(l1[0]);
        p = Integer.parseInt(l1[1]);

        String[] l2 = in.readLine().split(" ");
        for (int i = 0; i < 5; i++) {
            int x = Integer.parseInt(l2[i]);
            System.out.printf("%d%s", x-l*p, (i == 4? "\n" : " "));
        }
    }
}
