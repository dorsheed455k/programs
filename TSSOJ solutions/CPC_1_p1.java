import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CPH {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());

        for (int i = 0; i < t; i++) {
            String s = in.readLine();
            if (s.contains("chika")) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
