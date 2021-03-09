import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Nasljedstvo {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, o;

        n = Integer.parseInt(in.readLine());
        o = Integer.parseInt(in.readLine());

        int max = o / (n-1);
        int min = max;
        if (max * (n-1) == o) {
            --min;
        }
        min = o + min;
        max = o + max;
        System.out.println(min + " " + max);
    }
}
