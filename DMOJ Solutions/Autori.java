import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String long_var = in.readLine();

        String short_var = "";

        for (int i = 0; i < long_var.length(); i++) {
            if(long_var.charAt(i) > 64 && long_var.charAt(i) < 91) {
                short_var += long_var.charAt(i);
            }
        }

        System.out.println(short_var);
    }
}
