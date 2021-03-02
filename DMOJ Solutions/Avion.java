import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Avion {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] blimps = new String[5];

        for (int i = 0; i < 5; i++) {
            blimps[i] = in.readLine();
        }

        fbiBlimp(blimps);
    }

    public static void fbiBlimp(String[] b_i) {
        int count = 0;

        for (int i = 0; i < b_i.length; i++) {
            if (b_i[i].contains("FBI")) {
                count++;
                System.out.print((i+1)+ " ");
            }
        }
        if (count == 0) {
            System.out.println("HE GOT AWAY!");
        }
    }
}
