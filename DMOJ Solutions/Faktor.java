import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Faktor {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int a, i;

        String[] line = in.readLine().split(" ");

        a = Integer.parseInt(line[0]);
        i = Integer.parseInt(line[1]);

        int n = a * i - a + 1;

        System.out.println(n);
    }
}
