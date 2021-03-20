import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class New_Chapter {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String[] ln = in.readLine().split(" ");

        int count = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(ln[i]);
            if (x%2 == i%2) {
                count++;
            }
        }
        System.out.println(count);
    }
}
