import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quality_Scenes {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int a, b, c, d;

        a = Integer.parseInt(in.readLine());
        b = Integer.parseInt(in.readLine());
        c = Integer.parseInt(in.readLine());
        d = Integer.parseInt(in.readLine());

        if ((c < b && d >= b) || (a < d && b >= d)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
