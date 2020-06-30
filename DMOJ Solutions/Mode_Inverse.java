import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());

        int n = 0, parse;

        boolean inverseExists = false;

        for (int i = 1; i <= m; i++) {
            parse = (x * i) % m;
            if (parse == 1) {
                n = i;
               inverseExists = true;
            }
        }
        if(inverseExists) {
            System.out.println(n);
        } else {
            System.out.println("No such integer exists.");
        }

    }
}
