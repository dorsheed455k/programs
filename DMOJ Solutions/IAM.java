import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Itami_Manga {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String best = "";
        double rate = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String[] ln = in.readLine().split(" ");
            String title = ln[0];
            double r = Double.parseDouble(ln[1]);
            if(r > rate) {
                rate = r;
                best = title;
            }
        }

        System.out.println(best);
    }
}
