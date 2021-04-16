import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Attendance {

    static int n, k;
    static String[] present;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());

        present = new String[n];
        for (int i = 0; i < n; i++) {
            present[i] = in.readLine();
        }

        k = Integer.parseInt(in.readLine());

        for (int i = 0; i < k; i++) {
            int q = Integer.parseInt(in.readLine());
            if (present[q-1].equals("yes")) {
                System.out.println("here");
            } else {
                System.out.println("not here");
            }
        }
    }
}
